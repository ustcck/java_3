package cn.edu.ustc.metadata;

import cn.edu.ustc.utils.JdbcUtils;

import java.sql.*;

/**
 * ParameterMetaDataTest,参数元数据主要用于获取:sql语句中占位符的相关信息.
 * 问题:怎样获取ParameterMetaData?在PreparedStatement中有一个方法getParameterMetaData可以获取.
 * Created by ustcck on 2016/10/10.
 */
public class ParameterMetaDataTest {
    public static void main(String[] args) throws SQLException {
        Connection con = JdbcUtils.getConnection();

        String sql = "select * from account where id=?;";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();

        int parameterCount = parameterMetaData.getParameterCount();
        System.out.println(parameterCount);


    }
}
