package com.bervie.pattern;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA
 *
 * @author Bervie
 * @date 2019/06/07
 */
public class ConcurrentExecutor {
    public static void execute(final RunHandler runHandler,int executeCount,int concurrentCount) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //控制信号量，此处用于控制并发的线程数
        final Semaphore semaphore = new Semaphore(concurrentCount);
        //闭锁，可实现计数量递减
        final CountDownLatch countDownLatch = new CountDownLatch(executeCount);
        for (int i = 0;i<executeCount;i++){
            executorService.execute(() -> {
                try {
                    //执行此方法用于获取执行许可，
                    //当总计未释放的许可数不超过executeCount时，
                    //则允许同行，否则线程阻塞等待，直到获取到许可
                    semaphore.acquire();
                    runHandler.handler();
                    //释放许可
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }

    }
    public interface RunHandler{
        void handler();
    }
}
