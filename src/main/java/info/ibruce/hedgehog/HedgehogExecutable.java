package info.ibruce.hedgehog;

import java.util.concurrent.Future;

/**
 * Created by bruce-sha on 2016/2/28
 */
public interface HedgehogExecutable<T> {
    Future<T> async();
}
