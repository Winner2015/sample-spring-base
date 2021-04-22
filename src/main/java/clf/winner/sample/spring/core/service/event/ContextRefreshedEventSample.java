package clf.winner.sample.spring.core.service.event;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ContextRefreshedEventSample implements ApplicationListener<ContextRefreshedEvent> {

    private static Logger logger = Logger.getLogger(ContextRefreshedEventSample.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        logger.info("### ContextRefreshedEvent");
    }

    /**五种标准事件：
     * 1、ContextRefreshedEvent: ApplicationContext 被初始化或刷新时
     * 2、ContextStartedEvent： spring初始化完，时触发
     * 3、ContextStoppedEvent:spring停止后触发，一个停止了的动作，可以通过start()方法从新启动
     * 4、ContextClosedEvent: spring关闭，所有bean都被destroyed掉了,这个时候不能被刷新，或者从新启动了
     * 5、RequestHandledEvent: web环境，请求经过DispatcherServlet时被触发，在request完成之后
     */

}
