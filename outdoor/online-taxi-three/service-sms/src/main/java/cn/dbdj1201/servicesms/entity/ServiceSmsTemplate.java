package cn.dbdj1201.servicesms.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;
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
public class ServiceSmsTemplate implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 短信模板ID
     */
    private String templateId;

    private String templateName;

    /**
     * 模板内容
     */
    private String content;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 模板类型（1：营销；2：通知；3：订单）
     */
    private Boolean templateType;


}
