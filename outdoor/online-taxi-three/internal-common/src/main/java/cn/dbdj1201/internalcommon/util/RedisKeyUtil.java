package cn.dbdj1201.internalcommon.util;

import cn.hutool.core.util.StrUtil;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * @Author: dbdj1201
 * @Date: 2020/09/20
 */
public class RedisKeyUtil {
    //分隔符
    public final static String split = ":";
    public  static String getRedisKey(String... name) {
        StringBuffer sb = new StringBuffer();
        for (String str : name) {
            if (StrUtil.isNotBlank(str)) {
                sb.append(str);
                sb.append(split);
            }
        }
        sb = sb.deleteCharAt(sb.lastIndexOf(split));

        return sb.toString();
    }

    public static String getRedisKeyJoin(String... name){
        ArrayList<String> strlist = Lists.newArrayList();
        for (String str : name) {
            if (StrUtil.isNotBlank(str)) {
                strlist.add(str);
            }
        }
        return Joiner.on("_").join(strlist);
    }
}