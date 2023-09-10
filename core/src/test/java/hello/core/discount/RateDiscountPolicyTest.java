package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();
    @Test
    void vip_o(){
        Member member = new Member(1L,"member1", Grade.VIP);
        int discount = rateDiscountPolicy.discount(member,10000);
        Assertions.assertThat(discount).isEqualTo(1000);
    }
    @Test
    void vip_x(){
        Member member = new Member(1L,"member2", Grade.BASIC);
        int discount = rateDiscountPolicy.discount(member,10000);
        Assertions.assertThat(discount).isEqualTo(1000);
    }
}