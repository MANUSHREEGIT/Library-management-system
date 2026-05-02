package library;

public class OrderDTO {
	 private int orderId;
	    private String customerName;
	    private int tableNumber;
	    private String itemName;
	    private int quantity;
	    private double totalAmount;
	    private String orderStatus;

	    public OrderDTO() {}

	    public OrderDTO(String customerName, int tableNumber, String itemName, int quantity, double totalAmount, String orderStatus) {
	        this.customerName = customerName;
	        this.tableNumber = tableNumber;
	        this.itemName = itemName;
	        this.quantity = quantity;
	        this.totalAmount = totalAmount;
	        this.orderStatus = orderStatus;
	    }

	    public OrderDTO(int orderId, String customerName, int tableNumber, String itemName, int quantity, double totalAmount, String orderStatus) {
	        this.orderId = orderId;
	        this.customerName = customerName;
	        this.tableNumber = tableNumber;
	        this.itemName = itemName;
	        this.quantity = quantity;
	        this.totalAmount = totalAmount;
	        this.orderStatus = orderStatus;
	    }

	    // Getters & Setters
	    public int getOrderId() { return orderId; }
	    public void setOrderId(int orderId) { this.orderId = orderId; }
	    public String getCustomerName() { return customerName; }
	    public void setCustomerName(String customerName) { this.customerName = customerName; }
	    public int getTableNumber() { return tableNumber; }
	    public void setTableNumber(int tableNumber) { this.tableNumber = tableNumber; }
	    public String getItemName() { return itemName; }
	    public void setItemName(String itemName) { this.itemName = itemName; }
	    public int getQuantity() { return quantity; }
	    public void setQuantity(int quantity) { this.quantity = quantity; }
	    public double getTotalAmount() { return totalAmount; }
	    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
	    public String getOrderStatus() { return orderStatus; }
	    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }

}
