package cn.edu.zzti.pi.micro_center.model.base;

import cn.edu.zzti.pi.micro_center.util.StrUtils;

public enum ErrorCode {

    SYSTEM_SUCCESS("0000", "处理成功"),

    SYSTEM_FAILED("0001", "处理失败"),

    NOT_YET_ACHIEVED("0002", "还未实现"),

    ABNORMAL_NETWORK_COMMUNICATION("1001", "网络通讯异常"),
    ;

    private final String code;
    private final String desc;

    ErrorCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static ErrorCode byCode(String code) {
        for (ErrorCode c : values()) {
            if (StrUtils.equals(c.code, code)) {
                return c;
            }
        }
        return null;
    }
}
