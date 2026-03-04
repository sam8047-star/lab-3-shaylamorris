

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCRUD {

    private final String url = "jdbc:mysql://localhost:3306/school";
    private final String user = "root";
    private final String password = "IST888IST888";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void create(Customer customer) {
        String sql = "INSERT INTO Customer VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, customer.getId());
            stmt.setString(2, customer.getFirstName());
            stmt.setString(3, customer.getLastName());
            stmt.setString(4, customer.getEmail());
            stmt.setString(5, customer.getPhone());
            stmt.setString(6, customer.getAddress());

            stmt.executeUpdate();
            System.out.println("MySQL INSERTED: " + customer);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> readAll() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM Customer";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Customer c = new Customer(
                        rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address")
                );
                customers.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

    public void update(Customer customer) {
        String sql = "UPDATE Customer SET email=? WHERE id=?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, customer.getEmail());
            stmt.setInt(2, customer.getId());
            stmt.executeUpdate();

            System.out.println("MySQL UPDATED: " + customer);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM Customer WHERE id=?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("MySQL DELETED ID: " + id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}