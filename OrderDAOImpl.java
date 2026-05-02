package library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
	 @Override
	    public void addOrder(OrderDTO order) {
	        String sql = "INSERT INTO orders(customer_name, table_number, item_name, quantity, total_amount, order_status) VALUES (?, ?, ?, ?, ?, ?)";
	        try (Connection con = DBConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setString(1, order.getCustomerName());
	            ps.setInt(2, order.getTableNumber());
	            ps.setString(3, order.getItemName());
	            ps.setInt(4, order.getQuantity());
	            ps.setDouble(5, order.getTotalAmount());
	            ps.setString(6, order.getOrderStatus());

	            ps.executeUpdate();
	            System.out.println("✅ Order placed successfully!");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public List<OrderDTO> getAllOrders() {
	        List<OrderDTO> list = new ArrayList<>();
	        String sql = "SELECT * FROM orders";

	        try (Connection con = DBConnection.getConnection();
	             Statement st = con.createStatement();
	             ResultSet rs = st.executeQuery(sql)) {

	            while (rs.next()) {
	                list.add(new OrderDTO(
	                        rs.getInt("order_id"),
	                        rs.getString("customer_name"),
	                        rs.getInt("table_number"),
	                        rs.getString("item_name"),
	                        rs.getInt("quantity"),
	                        rs.getDouble("total_amount"),
	                        rs.getString("order_status")
	                ));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return list;
	    }

	    @Override
	    public void deleteOrder(int id) {
	        String sql = "DELETE FROM orders WHERE order_id=?";
	        try (Connection con = DBConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setInt(1, id);
	            ps.executeUpdate();
	            System.out.println("🗑️ Order deleted!");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void updateOrderStatus(int id, String status) {
	        String sql = "UPDATE orders SET order_status=? WHERE order_id=?";
	        try (Connection con = DBConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setString(1, status);
	            ps.setInt(2, id);
	            ps.executeUpdate();
	            System.out.println("🔄 Order status updated!");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public OrderDTO getOrderById(int id) {
	        String sql = "SELECT * FROM orders WHERE order_id=?";
	        try (Connection con = DBConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                return new OrderDTO(
	                        rs.getInt("order_id"),
	                        rs.getString("customer_name"),
	                        rs.getInt("table_number"),
	                        rs.getString("item_name"),
	                        rs.getInt("quantity"),
	                        rs.getDouble("total_amount"),
	                        rs.getString("order_status")
	                );
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

}
