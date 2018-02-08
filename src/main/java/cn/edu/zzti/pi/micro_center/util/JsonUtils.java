package cn.edu.zzti.pi.micro_center.util;

import com.alibaba.fastjson.JSONObject;

import javax.websocket.DecodeException;

public final class JsonUtils {

    public static <T> T parseObject(String str, Class<T> clazz) throws DecodeException {
        return JSONObject.parseObject(str, clazz);
    }

    public static String toString(Object obj) throws DecodeException {
        return JSONObject.toJSONString(obj);
    }
}
