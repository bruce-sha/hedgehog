package info.ibruce.hedgehog;

/**
 * Created by bruce-sha on 2016/2/28
 */
public interface HedgehogCacheable<T> {
    String cacheKey();

    T defaultValue();
}
