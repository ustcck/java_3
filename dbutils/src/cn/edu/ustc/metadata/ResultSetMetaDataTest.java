package cn.edu.ustc.metadata;

import cn.edu.ustc.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * ResultSetMetaData,可以通过ResultSet的getMetaData()方法获取.
 * Created by ustcck on 2016/10/10.
 */
public class ResultSetMetaDataTest {
    public static void main(String[] args) throws SQLException {
        Connection con = JdbcUtils.getConnection();

        String sql = "select * from account";
        ResultSet resultSet = con.createStatement().executeQuery(sql);

        ResultSetMetaData metaData = resultSet.getMetaData();
//        System.out.println(metaData.getColumnCount());
//        System.out.println(metaData.getColumnType(3));
//        System.out.println(metaData.getColumnName(2));

        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            System.out.print(metaData.getColumnName(i) + "\t");
        }

        System.out.println();
        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(resultSet.getObject(i) + "\t");
            }
            System.out.println();
        }

    }
}
