package hello.core.discount;

import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;

public interface DiscountPolicy {

    int discount(Member member, int price);


}
