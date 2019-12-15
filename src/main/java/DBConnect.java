import java.sql.*;

public class DBConnect {
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/telega?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String name = "root";
            String password = "050493";

            Connection con = DriverManager.getConnection(url, name, password);

            Statement st = con.createStatement();
            String str;
            str = st.executeQuery("SELECT COUNT(*) FROM OBLIGATION").toString();
            System.out.println(st.executeQuery("SELECT * FROM OBLIGATION").toString());

            ResultSet rst;
            rst = st.executeQuery("SELECT * FROM OBLIGATION");

            while (rst.next()) {
                System.out.println(rst.getInt("ROW_ID"));
               // System.out.println(rst.getDate("COUPON_DATE"));
                System.out.println(String.valueOf(rst.getInt(1)));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
//jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
