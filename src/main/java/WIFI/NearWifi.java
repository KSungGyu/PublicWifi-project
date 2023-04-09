package WIFI;

import DTO.WifiDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NearWifi {
    public List<WifiDto> near(double x, double y) {

        List<WifiDto> wifiList = new ArrayList<>();

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

            String sql = " SELECT wifi_information.* "
                    + "	,(6371*acos(cos(radians(?))*cos(radians(w.LAT))*cos(radians(w.LNT)-radians(?))+sin(radians(?))*sin(radians(w.LAT)))) AS distance "
                    + " FROM wifi wifi_information"
                    + " order by distance "
                    + " limit 20 ";
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setDouble(1, x);
            preparedstatement.setDouble(2, y);
            preparedstatement.setDouble(3, x);


            rs = preparedstatement.executeQuery();

            while (rs.next()) {

                WifiDto wifi = new WifiDto();
                wifi.setDistance(rs.getDouble("distance"));
                wifi.setX_SWIFI_MGR_NO(rs.getString("WIFI_MGR_NO"));
                wifi.setX_SWIFI_WRDOFC(rs.getString("WIFI_WRDOFC"));
                wifi.setX_SWIFI_MAIN_NM(rs.getString("WIFI_MAIN_NM"));
                wifi.setX_SWIFI_ADRES1(rs.getString("WIFI_ADRES1"));
                wifi.setX_SWIFI_ADRES2(rs.getString("WIFI_ADRES2"));
                wifi.setX_SWIFI_INSTL_FLOOR(rs.getString("WIFI_INSTL_FLOOR"));
                wifi.setX_SWIFI_INSTL_TY(rs.getString("WIFI_INSTL_TY"));
                wifi.setX_SWIFI_INSTL_MBY(rs.getString("WIFI_INSTL_MBY"));
                wifi.setX_SWIFI_SVC_SE(rs.getString("WIFI_SVC_SE"));
                wifi.setX_SWIFI_CMCWR(rs.getString("WIFI_CMCWR"));
                wifi.setX_SWIFI_CNSTC_YEAR(rs.getString("WIFI_CNSTC_YEAR"));
                wifi.setX_SWIFI_INOUT_DOOR(rs.getString("WIFI_INOUT_DOOR"));
                wifi.setX_SWIFI_REMARS3(rs.getString("WIFI_REMARS3"));
                wifi.setLAT(String.valueOf(rs.getDouble("LAT")));
                wifi.setLNT(String.valueOf(rs.getDouble("LNT")));
                wifi.setWORK_DTTM(rs.getString("WORK_DTTM"));

                wifiList.add(wifi);

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

        return wifiList;

    }
}
