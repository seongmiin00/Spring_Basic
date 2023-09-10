package hello.core.order;

public interface OrderService {
    Order creataOrder(Long memberId, String itemName, int itemPrice);
}
