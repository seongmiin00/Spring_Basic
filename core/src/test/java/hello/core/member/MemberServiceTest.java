package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberServiceTest {

    @Test
    void join(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        //given 무엇을
        Member member = new Member(1L,"memberA",Grade.VIP);

        //when 언제
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then 어떻게
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
