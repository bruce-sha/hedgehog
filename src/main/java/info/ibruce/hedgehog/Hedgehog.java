package info.ibruce.hedgehog;

import info.ibruce.hedgehog.config.HedgehogConfig;
import info.ibruce.hedgehog.exception.HedgehogRuntimeException;

import java.util.concurrent.*;

/**
 * Created by bruce-sha on 2016/2/28
 */
public abstract class Hedgehog<T> implements HedgehogInvokable<T>, HedgehogExecutable<T>, HedgehogCacheable<T>, HedgehogRetryable {

    static final ExecutorService executor = Executors.newFixedThreadPool(HedgehogConfig.cpuConsumedWorkers());

    protected HedgehogConfig config;

    protected abstract T run() throws Exception;

    @Override
    public String cacheKey() {
        return null;
    }

    @Override
    public T defaultValue() {
        return null;
    }

    @Override
    public void retry(int count, TimeUnit timeUnit, int intervalTime) {

    }

    @Override
    public Future<T> async() {
        return executor.submit(() -> run());
    }

    @Override
    public T execute() {
        try {
            return async().get();
        } catch (Exception e) {
            throw decomposeException(e);
        }
    }

    public void shutdownAndAwaitTermination(ExecutorService pool) {

        pool.shutdown(); // Disable new tasks from being submitted
        try {
            // Wait a while for existing tasks to terminate
            if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                pool.shutdownNow(); // Cancel currently executing tasks
                // Wait a while for tasks to respond to being cancelled
                if (!pool.awaitTermination(60, TimeUnit.SECONDS))
                    System.err.println("Pool did not terminate");
            }
        } catch (InterruptedException ie) {
            // (Re-)Cancel if current thread also interrupted
            pool.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }


    protected RuntimeException decomposeException(Exception e) {

        return new HedgehogRuntimeException(e);

//        if (e instanceof IllegalStateException) {
//            return (IllegalStateException) e;
//        }
//        if (e instanceof HystrixBadRequestException) {
//            return (HystrixBadRequestException) e;
//        }
//        if (e.getCause() instanceof HystrixBadRequestException) {
//            return (HystrixBadRequestException) e.getCause();
//        }
//        if (e instanceof HystrixRuntimeException) {
//            return (HystrixRuntimeException) e;
//        }
//        // if we have an exception we know about we'll throw it directly without the wrapper exception
//        if (e.getCause() instanceof HystrixRuntimeException) {
//            return (HystrixRuntimeException) e.getCause();
//        }
//        // we don't know what kind of exception this is so create a generic message and throw a new HystrixRuntimeException
//        String message = getLogMessagePrefix() + " failed while executing.";
//        logger.debug(message, e); // debug only since we're throwing the exception and someone higher will do something with it
//        return new HystrixRuntimeException(HystrixRuntimeException.FailureType.COMMAND_EXCEPTION, this.getClass(), message, e, null);

    }
}
