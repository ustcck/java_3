package cn.edu.ustc.dbutils;

import cn.edu.ustc.domain.Account;
import cn.edu.ustc.utils.DataSourceUtils;
import cn.edu.ustc.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * QueryRunner
 * 			1.QueryRunner怎样获取
                 1.new QueryRunner()
                 如果是使用这种构造创建的QueryRunner,它的事务是手动控制.
                 2.new QueryRunner(DataSource ds);
                 如果是使用这种构造，它的事务是自动事务，简单说，一条sql一个事务。

            2.QueryRunner中的三个核心方法
                 query
                 update
                 batch
                 对于上述三个方法，它们提供很多重载。
                 如果QueryRunner在创建时，没有传递DataSource参数，那么在使用
                 query,update,batch方法时，要传递Connection参数
                 如果QueryRunner在创建时，传递了Dataource参数，好么在使用
                 query,update,batch方法时，不需要传递Connection参数。
 * Created by ustcck on 2016/10/10.
 */
public class QueryRunnerTest {
    @Test
    public void test_1() throws SQLException {
        String sql = "select * from account";

        QueryRunner queryRunner = new QueryRunner();
        List<Account> as = queryRunner.query(JdbcUtils.getConnection(), sql, new BeanListHandler<Account>(Account.class));


        System.out.println(as);
    }

    @Test
    public void test_2() throws SQLException {
        String sql = "select * from account";

        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

        List<Account> list = queryRunner.query(sql, new BeanListHandler<Account>(Account.class));

        System.out.println(list);

    }

}
