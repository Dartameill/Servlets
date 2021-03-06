

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MyDataBase {
    private final String url = "jdbc:postgresql://localhost:8888/postgres";
    private final String user = "postgres";
    private final String password = "88654732";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            String query = "UPDATE public.customers SET email = ? WHERE id= ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "new@gmail.com");
            pstmt.setInt(2, 2);
            pstmt.execute();
            System.out.println("Records inserted......");
        } catch (SQLException var4) {
            System.out.println(var4.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) {
        MyDataBase app = new MyDataBase();
        app.connect();
    }
}
