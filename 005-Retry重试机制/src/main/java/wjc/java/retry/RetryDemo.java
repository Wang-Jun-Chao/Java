package wjc.java.retry;

import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import com.google.common.base.Predicates;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-05-20 15:09
 **/
public class RetryDemo {

    private final static Retryer<Boolean> RETRYER = RetryerBuilder.<Boolean>newBuilder()
            //抛出runtime异常、checked异常时都会重试，但是抛出error不会重试。
            .retryIfException()
            //返回false也需要重试
            .retryIfResult(Predicates.equalTo(false))
            //重调策略
            .withWaitStrategy(WaitStrategies.fixedWait(10, TimeUnit.SECONDS))
            //尝试次数
            .withStopStrategy(StopStrategies.stopAfterAttempt(3))
            .build();

    public static void main(String[] args) {
        try {
            RETRYER.call(updateReimAgentsCall);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Callable<Boolean> updateReimAgentsCall = new Callable<Boolean>() {
        @Override
        public Boolean call() throws Exception {
            int i = (int) (Math.random() * 10);

            if (i % 2 == 0) {
                System.out.println("do task failed.");
                return false;
            }

            System.out.println("task finished");
            return true;
        }
    };
}
