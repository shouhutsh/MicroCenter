package cn.edu.zzti.pi.micro_center.exception;

public class BizException extends RuntimeException {

    private String respCode;

    public BizException(String respCode) {
        this.respCode = respCode;
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public BizException(String message, String respCode) {
        super(message);
        this.respCode = respCode;
    }

    public BizException(String message, Throwable cause, String respCode) {
        super(message, cause);
        this.respCode = respCode;
    }

    public BizException(Throwable cause, String respCode) {
        super(cause);
        this.respCode = respCode;
    }

    public BizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String respCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.respCode = respCode;
    }
}
