package cn.dbdj1201.internalcommon.dto.servicesms.request;

import cn.dbdj1201.internalcommon.dto.servicesms.SmsTemplateDto;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @author yueyi2019
 */
@Data
public class SmsSendRequest{

	private String[] receivers;
	private List<SmsTemplateDto> data;

	@Override
	public String toString() {
		return "SmsSendRequest [receivers=" + Arrays.toString(receivers) + ", data=" + data + "]";
	}

}