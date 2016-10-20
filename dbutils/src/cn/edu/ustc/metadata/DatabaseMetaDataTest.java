package cn.edu.ustc.metadata;

import cn.edu.ustc.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DatabaseMetaDataTest,问题:怎样获取一个DataBaseMetaData?
 * Connection接口中定义了一个方法 getMetaData();
 * Created by ustcck on 2016/10/10.
 */
public class DatabaseMetaDataTest {
    public static void main(String[] args) throws SQLException {
        Connection con = JdbcUtils.getConnection();

        //获取DatabaseMetaData
        DatabaseMetaData metaData = con.getMetaData();

        String driverName = metaData.getDriverName();
        System.out.println(driverName);

        String url = metaData.getURL();
        System.out.println(url);

        String userName = metaData.getUserName();
        System.out.println(userName);

        String databaseProductName = metaData.getDatabaseProductName();
        System.out.println(databaseProductName);

        String databaseProductVersion = metaData.getDatabaseProductVersion();
        System.out.println(databaseProductVersion);

        ResultSet account = metaData.getPrimaryKeys(null, null, "account");
        while (account.next()) {
            System.out.println(account.getObject(3));
        }
    }
}
