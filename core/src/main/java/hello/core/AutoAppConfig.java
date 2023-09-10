package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

//설정 정보 어노테이션
@Configuration
//스프링 빈을 자동으로 끌어 올리는 어노테이션
//@Component 어노테이션이 붙은 클래스를 스캔하여 스프링 빈으로 등록함
@ComponentScan(
        basePackages = "hello.core.member",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
//Filter -> 조건에 해당하는 클래스는 제외함
//basePackage -> 탐색위치 기준 설정
public class AutoAppConfig {

}
