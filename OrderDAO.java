package library;

import java.util.List;

public interface OrderDAO {
	void addOrder(OrderDTO order);
    List<OrderDTO> getAllOrders();
    void deleteOrder(int id);
    void updateOrderStatus(int id, String status);
    OrderDTO getOrderById(int id);

}
