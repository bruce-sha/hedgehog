package info.ibruce.hedgehog;

import java.util.concurrent.TimeUnit;

/**
 * Created by bruce-sha on 2016/2/28
 */
public interface HedgehogRetryable {
    void retry(int count, TimeUnit timeUnit, int intervalTime);
}
