package library;

import java.util.List;

public class OrderService {
	OrderDAO dao = new OrderDAOImpl();

    public void placeOrder(String name, int table, String item, int qty, double price) {
        double total = qty * price;
        dao.addOrder(new OrderDTO(name, table, item, qty, total, "Preparing"));
    }

    public void viewOrders() {
        List<OrderDTO> list = dao.getAllOrders();
        for (OrderDTO o : list) {
            System.out.println(o.getOrderId() + " | " + o.getCustomerName() + " | Table " + o.getTableNumber()
                    + " | " + o.getItemName() + " | Qty:" + o.getQuantity()
                    + " | ₹" + o.getTotalAmount() + " | " + o.getOrderStatus());
        }
    }

    public void deleteOrder(int id) {
        dao.deleteOrder(id);
    }

    public void updateStatus(int id, String status) {
        dao.updateOrderStatus(id, status);
    }

    public void searchOrder(int id) {
        OrderDTO o = dao.getOrderById(id);
        if (o != null) {
            System.out.println(o.getOrderId() + " | " + o.getCustomerName() + " | Table " + o.getTableNumber()
                    + " | " + o.getItemName() + " | Qty:" + o.getQuantity()
                    + " | ₹" + o.getTotalAmount() + " | " + o.getOrderStatus());
        } else {
            System.out.println("❌ Order not found!");
        }
    }

}
