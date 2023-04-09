package WIFI;
import DTO.HistoryDto;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class History {
    public void InserHistory(double x, double y) {
        String url = "jdbc:mariadb://localhost:3306/wifi";
        String dbUserId = "testuser";
        String dbPassword = "rlatjdrb12";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = " INSERT into HISTORY (LAT, LNT, HISTORY_DT) "
                    + " values (?, ? ,now()) " ;

            preparedstatement = connection.prepareStatement(sql);

            preparedstatement.setDouble(1, x);
            preparedstatement.setDouble(2, y);


            int affected = preparedstatement.executeUpdate();

            if (affected > 0) {
                System.out.println(" 저장 성공 ");
            } else {
                System.out.println(" 저장 실패 ");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


            try {
                if (preparedstatement != null && !preparedstatement.isClosed()) {
                    preparedstatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


}
