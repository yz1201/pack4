package cn.dbdj1201.internalcommon.dto.serviceverificationcode.request;

import lombok.Data;

/**
 * @author yueyi2019
 */
@Data
public class VerifyCodeRequest {

	private int identity;

	private String phoneNumber;
	
	private String code;
}