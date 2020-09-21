package cn.dbdj1201.servicesms.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author dbdj1201
 * @since 2020-09-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ServiceSmsRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 电话
     */
    private String phoneNumber;

    /**
     * 消息体
     */
    private String smsContent;

    /**
     * 发送时间
     */
    private LocalDateTime sendTime;

    /**
     * 推送类型 （1：营销,2:通知）
     */
    private Boolean pushType;

    /**
     * 发送状态（0：失败；1：成功）
     */
    private Boolean status;

    /**
     * 操作者
     */
    private String operator;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 失败次数
     */
    @TableField("sendNumber")
    private Integer sendNumber;


}
