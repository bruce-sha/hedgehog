package info.ibruce.hedgehog.exception;

/**
 * Created by bruce-sha on 2016/2/28
 */
public class HedgehogRuntimeException extends RuntimeException {

    public HedgehogRuntimeException() {
    }

    public HedgehogRuntimeException(String message) {
        super(message);
    }

    public HedgehogRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public HedgehogRuntimeException(Throwable cause) {
        super(cause);
    }

    public HedgehogRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
