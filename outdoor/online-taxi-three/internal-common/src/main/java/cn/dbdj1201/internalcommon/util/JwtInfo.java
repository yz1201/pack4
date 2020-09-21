package cn.dbdj1201.internalcommon.util;

import lombok.Data;

@Data
public class JwtInfo{
    String subject;
    Long issueDate;
}