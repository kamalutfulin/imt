import java.sql.Connection;
import java.sql.Driver;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private final static String url = "jdbc:postgresql://localhost:5432/imt";
    private final static String login = "postgres";
    private final static String password = "kama5101894";

    private static final String INSERT_NEW = "INSERT INTO accounts VALUES(?,?,?,?,?)";

    public void showDB() {
        try {
            String url = "jdbc:postgresql://localhost:5432/imt";
            String login = "postgres";
            String password = "kama5101894";
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM accounts ");
                while (rs.next()) {
                    String str = " Имя: " + rs.getString("firstname") + ", возраст " + rs.getString(2)
                            + ", рост " + rs.getString(3) + ", вес " + rs.getString(4) + ", имт " + rs.getString(5);
                    System.out.println("Пользователь : " + str);
                }
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void create(String firstName, int age, double height, double weight, double imt) {
        PreparedStatement preparedStatement = null;
        try (Connection connection = DriverManager.getConnection(url, login, password);
             Statement statement = connection.createStatement()) {
            preparedStatement = connection.prepareStatement(INSERT_NEW);
            preparedStatement.setString(1, firstName);
            preparedStatement.setInt(2, age);
            preparedStatement.setDouble(3, height);
            preparedStatement.setDouble(4, weight);
            preparedStatement.setDouble(5, imt);
            preparedStatement.execute();

            System.out.println("Данные успешно внесены");
            System.out.println("1 - создать учетку пользователя в базе данных ");
            System.out.println("2 - показать текущую информацию в базе данных ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
