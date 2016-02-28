package info.ibruce.hedgehog.config;

/**
 * Created by bruce-sha on 2016/2/28
 */
public class HedgehogConfig {

    static final int workers = Runtime.getRuntime().availableProcessors();

    public static int cpuConsumedWorkers() {
        return workers + 1;
    }

    public static int ioConsumedWorkers() {
        return workers * 2 + 1;
    }

}
