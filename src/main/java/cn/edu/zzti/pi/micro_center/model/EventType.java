package cn.edu.zzti.pi.micro_center.model;

import cn.edu.zzti.pi.micro_center.model.event_entity.*;
import cn.edu.zzti.pi.micro_center.util.StrUtils;

public enum EventType {

    Register("register", "注册事件", RegisterModel.class),
    Notification("notification", "通知事件", NotificationModel.class),
    Command("command", "命令事件", CommandModel.class),
    Subscript("subscript", "订阅事件", SubscriptModel.class),
    Unsubscribe("unsubscribe", "退订阅事件", UnsubscribeModel.class),
    ;

    private final String code;
    private final String desc;
    private final Class<? extends AbstractEventModel> clazz;

    EventType(String code, String desc, Class<? extends AbstractEventModel> clazz) {
        this.code = code;
        this.desc = desc;
        this.clazz = clazz;
    }

    public static EventType byCode(String code) {
        for (EventType e : values()) {
            if(StrUtils.equals(e.code, code)) {
                return e;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public Class<? extends AbstractEventModel> getClazz() {
        return clazz;
    }
}
