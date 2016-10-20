package cn.edu.ustc.dbutils;

import cn.edu.ustc.domain.Account;
import cn.edu.ustc.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * dbutils,Commons DbUtils是Apache组织提供的一个对JDBC进行简单封装的开源工具类库，
 * 使用它能够简化JDBC应用程序的开发，同时也不会影响程序的性能。
 * 它就是一个简单的jdbc封装工具.
 * 使用dbutils可以简化操作.
 * 要使用dbutils需要导入jar包.
 * Created by ustcck on 2016/10/10.
 */
public class DbUtilsTest {
/*
    dbutils核心
		1.QueryRunner类
    它是用于执行sql语句的类。
            1.query 用于执行select
			2.update 用于执行update delete insert
			3.batch 批处理
		2.ResultSetHandler接口
            用于定义结果集的封装
    它提供九个实现类，可以进行不同的封装。
            3.DbUtils类
    它提供关于关闭资源以及事务rollback,commit操作。
    */

    @Test
    public void selectTest() throws SQLException {
        String sql = "select * from account";

        QueryRunner queryRunner = new QueryRunner();
        List<Account> as = queryRunner.query(JdbcUtils.getConnection(), sql, new BeanListHandler<Account>(Account.class));

        for (Account a : as) {
            System.out.println(a.toString());
        }
    }

    @Test
    public void addTest() throws SQLException {
        String sql = "insert into account values(null,?,?)";
        QueryRunner queryRunner = new QueryRunner();

        int row = queryRunner.update(JdbcUtils.getConnection(), sql, "张三", 10000d);
        System.out.println(row);
    }
}
