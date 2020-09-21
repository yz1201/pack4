package cn.dbdj1201.servicesms.service.impl;

import cn.dbdj1201.internalcommon.dto.ResponseResult;
import cn.dbdj1201.internalcommon.dto.servicesms.SmsTemplateDto;
import cn.dbdj1201.internalcommon.dto.servicesms.request.SmsSendRequest;
import cn.dbdj1201.servicesms.constant.SmsStatusEnum;
import cn.dbdj1201.servicesms.entity.ServiceSmsRecord;
import cn.dbdj1201.servicesms.entity.ServiceSmsTemplate;
import cn.dbdj1201.servicesms.service.IServiceSmsRecordService;
import cn.dbdj1201.servicesms.service.IServiceSmsTemplateService;
import cn.dbdj1201.servicesms.service.ISmsService;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class SmsServiceImpl implements ISmsService {

    /**
     * 缓存用于替换内容的模板
     */
    private Map<String, String> templateMaps = new HashMap<>();

    @Autowired
    private IServiceSmsRecordService smsRecordService;

    @Autowired
    private IServiceSmsTemplateService smsTemplateService;

    @Override
    public ResponseResult sendSms(SmsSendRequest request) {
        log.info(request.toString());

        for (String phoneNumber : request.getReceivers()) {
            List<SmsTemplateDto> templates = request.getData();

            ServiceSmsRecord sms = new ServiceSmsRecord();
            sms.setPhoneNumber(phoneNumber);
            // 81B*10 1024 1K 10*1024  1M
            for (SmsTemplateDto template : templates) {
                // 从DB加载模板内容至缓存
                if (!templateMaps.containsKey(template.getId())) {
                    //此处注释掉的内容为，将db模板加载到内存
                    ServiceSmsTemplate t = this.smsTemplateService.getOne(new QueryWrapper<ServiceSmsTemplate>().eq("template_id", template.getId()));
                    System.out.println(t.getContent());
                    log.info("msg-{}", t.getContent());
                    templateMaps.put(template.getId(),
                            t.getContent());
                }

                // 替换占位符
                String content = templateMaps.get(template.getId());
                for (Map.Entry<String, Object> entry : template.getTemplateMap().entrySet()) {
                    content = StringUtils.replace(content, "${" + entry.getKey() + "}", "" + entry.getValue());
                }

                // 发生错误时，不影响其他手机号和模板的发送
                try {
                    int result = send(phoneNumber, template.getId(), template.getTemplateMap());

                    // 组装SMS对象
                    sms.setSendTime(LocalDateTime.now());
                    sms.setOperator("");
                    sms.setStatus(true);
                    sms.setSendNumber(0);
                    sms.setSmsContent(content);

                    if (result != SmsStatusEnum.SEND_SUCCESS.getCode()) {
                        throw new Exception("短信发送失败");
                    }
                } catch (Exception e) {
                    sms.setStatus(false);
                    sms.setSendNumber(1);
                    log.error("发送短信（" + template.getId() + "）失败：" + phoneNumber, e);
                } finally {
                    sms.setCreateTime(LocalDateTime.now());
                    this.smsRecordService.save(sms);
                }
            }
        }
        return ResponseResult.success("");
    }

    private int send(String phoneNumber, String templateId, Map<String, ?> map) throws Exception {
        JSONObject param = new JSONObject();
        param.putAll(map);

        return sendMsg(phoneNumber, templateId, param.toString());
    }

    private int sendMsg(String phoneNumber, String templateCode, String param) {

        /*
           供应商 发 短信
         */
        return SmsStatusEnum.SEND_SUCCESS.getCode();

    }
}
