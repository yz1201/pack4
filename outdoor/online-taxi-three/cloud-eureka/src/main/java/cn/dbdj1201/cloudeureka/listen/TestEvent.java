package cn.dbdj1201.cloudeureka.listen;

import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


/**
 * @Author: dbdj1201
 * @Date: 2020-09-16 15:00
 */
@Component
public class TestEvent {

    @EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        //服务下线就发邮件，发短信
        System.out.println("下线" + event.getServerId());
    }

}
