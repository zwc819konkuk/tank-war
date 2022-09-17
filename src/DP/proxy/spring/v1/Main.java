package DP.proxy.spring.v1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("DP/proxy/spring/v1/app.xml");
        Tank t = (Tank)context.getBean("tank");
        t.move();
    }
}
