package wjc.dubbo.d004.genericcall.consumer;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.MetadataReportConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.apache.dubbo.config.utils.ReferenceConfigCache;
import org.apache.dubbo.rpc.service.GenericService;
import wjc.dubbo.demo.api.DemoService;

import java.util.HashMap;
import java.util.Map;

public class GenericCallConsumerApplication {
    public static void main(String[] args) {
        if (isClassic(args)) {
            runWithRefer();
        } else {
            runWithBootstrap();
        }
    }

    private static boolean isClassic(String[] args) {
        return args.length > 0 && "classic".equalsIgnoreCase(args[0]);
    }

    private static void runWithBootstrap() {
        ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
        reference.setInterface("wjc.dubbo.demo.api.DemoService");
        reference.setGeneric("true");

        ApplicationConfig applicationConfig = new ApplicationConfig("dubbo-demo-generic-call-consumer");
        Map<String, String> parameters = new HashMap<>();
        applicationConfig.setParameters(parameters);

        MetadataReportConfig metadataReportConfig = new MetadataReportConfig();
        metadataReportConfig.setAddress("zookeeper://192.168.241.129:2181");

        DubboBootstrap bootstrap = DubboBootstrap.getInstance();
        bootstrap.application(applicationConfig)
                .registry(new RegistryConfig("zookeeper://192.168.241.129:2181"))
                .reference(reference)
                .start();

        // generic invoke
        GenericService genericService = (GenericService) ReferenceConfigCache.getCache().get(reference);
        while (true) {
            try {
                Object genericInvokeResult = genericService.$invoke("sayHello", new String[]{String.class.getName()},
                        new Object[]{"dubbo generic invoke"});
                System.out.println(genericInvokeResult);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void runWithRefer() {
        ReferenceConfig<DemoService> reference = new ReferenceConfig<>();
        reference.setApplication(new ApplicationConfig("dubbo-demo-generic-call-consumer"));
        reference.setRegistry(new RegistryConfig("zookeeper://192.168.241.129:2181"));
        reference.setInterface(DemoService.class);
        DemoService service = reference.get();
        String message = service.sayHello("dubbo");
        System.out.println(message);
    }
}
