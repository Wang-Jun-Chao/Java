package wjc.dubbo.d002.xml.consumer;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import wjc.dubbo.demo.api.DemoService;
import wjc.dubbo.demo.api.GreetingService;
import wjc.dubbo.demo.api.RestDemoService;
import wjc.dubbo.demo.api.TripleService;

import java.util.concurrent.CompletableFuture;

public class XmlConsumerApplication {
    /**
     * In order to make sure multicast registry works, need to specify '-Djava.net.preferIPv4Stack=true' before
     * launch the application
     */
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-consumer.xml");
        context.start();
        DemoService demoService = context.getBean("demoService", DemoService.class);
        GreetingService greetingService = context.getBean("greetingService", GreetingService.class);
        RestDemoService restDemoService = context.getBean("restDemoService", RestDemoService.class);
        TripleService tripleService = context.getBean("tripleService", TripleService.class);

        new Thread(() -> {
            while (true) {
                try {
                    String greetings = greetingService.hello();
                    System.out.println(greetings + " from separated thread.");
                } catch (Exception e) {
//                    e.printStackTrace();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    String restResult = restDemoService.sayHello("rest");
                    System.out.println(restResult + " from separated thread.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    String restResult = tripleService.hello();
                    System.out.println(restResult + " from separated thread.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }).start();

        while (true) {
            try {
                CompletableFuture<String> hello = demoService.sayHelloAsync("world");
                System.out.println("result: " + hello.get());

                String greetings = greetingService.hello();
                System.out.println("result: " + greetings);
            } catch (Exception e) {
//                e.printStackTrace();
            }

            Thread.sleep(5000);
        }
    }
}
