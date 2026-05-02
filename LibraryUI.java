package library;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LibraryUI extends JFrame {
	private JTextField nameField, tableField, itemField, qtyField, priceField, idField;
    private JTextArea outputArea;

    OrderService service = new OrderService();

    public LibraryUI() {
        setTitle("📚 Library Seat Reservation System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(6, 2));

        nameField = new JTextField();
        tableField = new JTextField();
        itemField = new JTextField();
        qtyField = new JTextField();
        priceField = new JTextField();
        idField = new JTextField();

        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Seat No:"));
        inputPanel.add(tableField);
        inputPanel.add(new JLabel("Book/Item:"));
        inputPanel.add(itemField);
        inputPanel.add(new JLabel("Quantity:"));
        inputPanel.add(qtyField);
        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(priceField);
        inputPanel.add(new JLabel("Order ID:"));
        inputPanel.add(idField);

        add(inputPanel, BorderLayout.NORTH);

        // Buttons
        JPanel buttonPanel = new JPanel();

        JButton addBtn = new JButton("Reserve");
        JButton viewBtn = new JButton("View");
        JButton deleteBtn = new JButton("Delete");
        JButton updateBtn = new JButton("Update Status");
        JButton searchBtn = new JButton("Search");

        buttonPanel.add(addBtn);
        buttonPanel.add(viewBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(updateBtn);
        buttonPanel.add(searchBtn);

        add(buttonPanel, BorderLayout.CENTER);

        // Output Area
        outputArea = new JTextArea();
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        // 🔘 Button Actions

        addBtn.addActionListener((ActionEvent e) -> {
            String name = nameField.getText();
            int table = Integer.parseInt(tableField.getText());
            String item = itemField.getText();
            int qty = Integer.parseInt(qtyField.getText());
            double price = Double.parseDouble(priceField.getText());

            service.placeOrder(name, table, item, qty, price);
            outputArea.setText("✅ Seat Reserved!");
        });

        viewBtn.addActionListener(e -> {
            List<OrderDTO> list = service.dao.getAllOrders();
            outputArea.setText("");
            for (OrderDTO o : list) {
                outputArea.append(o.getOrderId() + " | " + o.getCustomerName() +
                        " | Seat " + o.getTableNumber() +
                        " | " + o.getItemName() +
                        " | Qty:" + o.getQuantity() +
                        " | ₹" + o.getTotalAmount() +
                        " | " + o.getOrderStatus() + "\n");
            }
        });

        deleteBtn.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            service.deleteOrder(id);
            outputArea.setText("🗑️ Deleted!");
        });

        updateBtn.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            String status = JOptionPane.showInputDialog("Enter Status:");
            service.updateStatus(id, status);
            outputArea.setText("🔄 Updated!");
        });

        searchBtn.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            OrderDTO o = service.dao.getOrderById(id);

            if (o != null) {
                outputArea.setText(o.getOrderId() + " | " + o.getCustomerName() +
                        " | Seat " + o.getTableNumber() +
                        " | " + o.getItemName() +
                        " | Qty:" + o.getQuantity() +
                        " | ₹" + o.getTotalAmount() +
                        " | " + o.getOrderStatus());
            } else {
                outputArea.setText("❌ Not Found!");
            }
        });
    }

	public static void main(String[] args) {
        new LibraryUI().setVisible(true);

	}

}
