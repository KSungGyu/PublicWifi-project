package DB;

import DTO.HistoryDto;
import DTO.WifiDto;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import DTO.WifiDto;
public class DbTest {

    public void DbSelect(){
        String url = "jdbc:mariadb://localhost:3306/wifi";
        String dbUserId = "testuser";
        String dbPassword = "rlatjdrb12";

        try{
            Class.forName("org.mariadb.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        String memberTypeValue = "X_SWIFI_MGR_NO, X_SWIFI_WRDOFC, X_SWIFI_MAIN_NM, X_SWIFI_ADRES1, X_SWIFI_ADRES2, X_SWIFI_INSTL_FLOOR, X_SWIFI_INSTL_TY, X_SWIFI_INSTL_MBY, X_SWIFI_SVC_SE, X_SWIFI_CMCWR, X_SWIFI_CNSTC_YEAR, X_SWIFI_INOUT_DOOR, X_SWIFI_REMARS3, LAT, LNT, WORK_DTTM";

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = " select X_SWIFI_MGR_NO, X_SWIFI_WRDOFC, X_SWIFI_MAIN_NM, X_SWIFI_ADRES1, X_SWIFI_ADRES2, X_SWIFI_INSTL_FLOOR, X_SWIFI_INSTL_TY, X_SWIFI_INSTL_MBY, X_SWIFI_SVC_SE, X_SWIFI_CMCWR, X_SWIFI_CNSTC_YEAR, X_SWIFI_INOUT_DOOR, X_SWIFI_REMARS3, LAT, LNT, WORK_DTTM" +
                    " from wifi_information " ;

            preparedStatement = connection.prepareStatement(sql);

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String X_SWIFI_MGR_NO = rs.getString("X_SWIFI_MGR_NO");
                String X_SWIFI_WRDOFC = rs.getString("X_SWIFI_WRDOFC");
                String X_SWIFI_MAIN_NM = rs.getString("X_SWIFI_MAIN_NM");
                String X_SWIFI_ADRES1 = rs.getString("X_SWIFI_ADRES1");
                String X_SWIFI_ADRES2 = rs.getString("X_SWIFI_ADRES2");
                String X_SWIFI_INSTL_FLOOR = rs.getString("X_SWIFI_INSTL_FLOOR");
                String X_SWIFI_INSTL_TY = rs.getString("X_SWIFI_INSTL_TY");
                String X_SWIFI_INSTL_MBY = rs.getString("X_SWIFI_INSTL_MBY");
                String X_SWIFI_SVC_SE = rs.getString("X_SWIFI_SVC_SE");
                String X_SWIFI_CMCWR = rs.getString("X_SWIFI_CMCWR");
                String X_SWIFI_CNSTC_YEAR = rs.getString("X_SWIFI_CNSTC_YEAR");
                String X_SWIFI_INOUT_DOOR = rs.getString("X_SWIFI_INOUT_DOOR");
                String X_SWIFI_REMARS3 = rs.getString("X_SWIFI_REMARS3");
                String LAT = rs.getString("LAT");
                String LNT = rs.getString("LNT");
                String WORK_DTTM = rs.getString("WORK_DTTM");
            }

        }  catch(SQLException e) {
            e.printStackTrace();
        }  finally {

            try {
                if(rs != null && !rs.isClosed()){
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                if(rs != null && !preparedStatement.isClosed()){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                if(rs != null && !connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void DbInsert(WifiDto wifi){
        String url = "jdbc:mariadb://localhost:3306/wifi";
        String dbUserId = "testuser";
        String dbPassword = "rlatjdrb12";

        try{
            Class.forName("org.mariadb.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;


        try {

            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = " insert into wifi_information (X_SWIFI_MGR_NO, X_SWIFI_WRDOFC, X_SWIFI_MAIN_NM, X_SWIFI_ADRES1, X_SWIFI_ADRES2, X_SWIFI_INSTL_FLOOR, X_SWIFI_INSTL_TY, X_SWIFI_INSTL_MBY, X_SWIFI_SVC_SE, X_SWIFI_CMCWR, X_SWIFI_CNSTC_YEAR, X_SWIFI_INOUT_DOOR, X_SWIFI_REMARS3, LAT, LNT, WORK_DTTM) " +
                    " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " ;

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, wifi.getX_SWIFI_MGR_NO());
            preparedStatement.setString(2, wifi.getX_SWIFI_WRDOFC());
            preparedStatement.setString(3, wifi.getX_SWIFI_MAIN_NM());
            preparedStatement.setString(4, wifi.getX_SWIFI_ADRES1());
            preparedStatement.setString(5, wifi.getX_SWIFI_ADRES2());
            preparedStatement.setString(6, wifi.getX_SWIFI_INSTL_FLOOR());
            preparedStatement.setString(7, wifi.getX_SWIFI_INSTL_TY());
            preparedStatement.setString(8, wifi.getX_SWIFI_INSTL_MBY());
            preparedStatement.setString(9, wifi.getX_SWIFI_SVC_SE());
            preparedStatement.setString(10, wifi.getX_SWIFI_CMCWR());
            preparedStatement.setString(11, wifi.getX_SWIFI_CNSTC_YEAR());
            preparedStatement.setString(12, wifi.getX_SWIFI_INOUT_DOOR());
            preparedStatement.setString(13, wifi.getX_SWIFI_REMARS3());
            preparedStatement.setDouble(14, Double.parseDouble(wifi.getLAT()));
            preparedStatement.setDouble(15, Double.parseDouble(wifi.getLNT()));
            preparedStatement.setString(16, wifi.getWORK_DTTM());


            int affected = preparedStatement.executeUpdate();

            if(affected>0) {
                System.out.println("저장 성공");
            } else {
                System.out.println(" 저장 실패");
            }

        }  catch(SQLException e) {
            e.printStackTrace();
        }  finally {

            try {
                if(rs != null && !rs.isClosed()){
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                if(rs != null && !preparedStatement.isClosed()){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                if(rs != null && !connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void DbUpdate(WifiDto wifi) {
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

            String sql = " UPDATE WIFI " + " set WIFI_WRDOFC = ? " + "	, WIFI_MAIN_NM = ? " + "	, WIFI_ADRES1 = ? " + "	, WIFI_ADRES2 = ? " + "	, WIFI_INSTL_FLOOR = ? " + "	, WIFI_INSTL_TY = ? " + "	, WIFI_INSTL_MBY = ? " + "	, WIFI_SVC_SE = ? " + "	, WIFI_CMCWR = ? " + "	, WIFI_CNSTC_YEAR = ? " + "	, WIFI_INOUT_DOOR = ? " + "	, WIFI_REMARS3 = ? " + "	, LAT = ? " + "	, LNT = ? " + "	, WORK_DTTM = ? " + " WHERE WIFI_MGR_NO = ? " ;

            preparedstatement = connection.prepareStatement(sql);

            preparedstatement.setString(1, wifi.getX_SWIFI_WRDOFC());
            preparedstatement.setString(2, wifi.getX_SWIFI_MAIN_NM());
            preparedstatement.setString(3, wifi.getX_SWIFI_ADRES1());
            preparedstatement.setString(4, wifi.getX_SWIFI_ADRES2());
            preparedstatement.setString(5, wifi.getX_SWIFI_INSTL_FLOOR());
            preparedstatement.setString(6, wifi.getX_SWIFI_INSTL_TY());
            preparedstatement.setString(7, wifi.getX_SWIFI_INSTL_MBY());
            preparedstatement.setString(8, wifi.getX_SWIFI_SVC_SE());
            preparedstatement.setString(9, wifi.getX_SWIFI_CMCWR());
            preparedstatement.setString(10, wifi.getX_SWIFI_CNSTC_YEAR());
            preparedstatement.setString(11, wifi.getX_SWIFI_INOUT_DOOR());
            preparedstatement.setString(12, wifi.getX_SWIFI_REMARS3());
            preparedstatement.setDouble(13, Double.parseDouble(wifi.getLAT()));
            preparedstatement.setDouble(14, Double.parseDouble(wifi.getLNT()));
            preparedstatement.setString(15, wifi.getWORK_DTTM());
            preparedstatement.setString(16, wifi.getX_SWIFI_MGR_NO());


            int affected = preparedstatement.executeUpdate();

            if (affected > 0) {
                System.out.println(" 수정 성공 ");
            } else {
                System.out.println(" 수정 실패 ");
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

    public List<HistoryDto> loadHistory() {

        List<HistoryDto> historyList = new ArrayList<>();

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

            String sql = " SELECT historyId, historyX, historyY, historyDate "
                    + "FROM history_information ";
            preparedstatement = connection.prepareStatement(sql);

            rs = preparedstatement.executeQuery();

            while (rs.next()) {

                HistoryDto history = new HistoryDto();
                history.setHistoryId(rs.getInt("HistoryId"));
                history.setHistoryX(rs.getDouble("HistoryX"));
                history.setHistoryY(rs.getDouble("HistoryY"));
                history.setHistoryDate(rs.getDate("HistoryDate").toString());

                historyList.add(history);

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

        return historyList;

    }
}


