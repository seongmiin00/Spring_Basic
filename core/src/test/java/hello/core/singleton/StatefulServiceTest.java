package hello.core.singleton;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //사용자1이 10000원 주문
        int member1Price = statefulService1.order("member1", 10000);
        //사용자2가 20000원 주문
        int member2Price = statefulService2.order("member2", 20000);

        //사용자1이 주문금액 조회
//        int price = statefulService1.getPrice();
        System.out.println("price1 = " + member1Price);
        System.out.println("price2 = " + member2Price);

//        Assertions.assertThat(member1Price).isEqualTo(10000);
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}