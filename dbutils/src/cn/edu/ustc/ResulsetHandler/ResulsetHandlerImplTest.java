package cn.edu.ustc.ResulsetHandler;

import cn.edu.ustc.domain.Account;
import cn.edu.ustc.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * ResulsetHandlerImplTest,ResulsetHandler九个实现类
 * Created by ustcck on 2016/10/11.
 */
public class ResulsetHandlerImplTest {
    //ArrayHandler, 将结果集中第一条记录封装到Object[],数组中的每一个元素就是记录中的字段值。
    @Test
    public void test_1() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        Object[] objects = runner.query("select * from account", new ArrayHandler());

        System.out.println(Arrays.toString(objects));
    }

    //ArrayListHandler, 将结果集中每一条记录封装到Object[],数组中的每一个元素就是记录中的字段值。在将这些数组装入到List集合。
    @Test
    public void test_2() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        List<Object[]> lists = runner.query("select * from account", new ArrayListHandler());

        for (Object[] list : lists) {
            System.out.println(Arrays.toString(list));
        }
    }

    //BeanHandler（重点）, 将结果集中第一条记录封装到一个javaBean中。
    @Test
    public void test_3() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        Object query = runner.query("select * from account", new BeanHandler(Account.class));

        System.out.println(query);
    }

    //BeanListHandler(重点), 将结果集中每一条记录封装到javaBean中，在将javaBean封装到List集合.
    @Test
    public void test_4() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        List<Account> accounts = runner.query("select * from account", new BeanListHandler<Account>(Account.class));

        System.out.println(accounts);

    }

    //ColumnListHandler, 将结果集中指定列的值封装到List集合.
    @Test
    public void test_5() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        List<Object> lists = runner.query("select * from account", new ColumnListHandler("name"));

        System.out.println(lists);
    }

    //MapHandler, 将结果集中第一条记录封装到Map集合中，集合的 key就是字段名称，value就是字段值
    @Test
    public void test_6() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        Map<String, Object> map = runner.query("select * from account", new MapHandler());

        System.out.println(map);
    }

    //MapListHandler, 将结果集中每一条记录封装到Map集合中，集合的 key就是字段名称，value就是字段值，在将这些Map封装到List集合
    @Test
    public void test_7() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        List<Map<String, Object>> maps = runner.query("select * from account", new MapListHandler());

        System.out.println(maps);
    }

    //KeyedHandler,在使用指定的列的值做为一个Map集合的key,值为每一条记录的Map集合封装。
    @Test
    public void test_8() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        Map<Object, Map<String, Object>> query = runner.query("select * from account", new KeyedHandler("name"));

        System.out.println(query);
    }

    //ScalarHandler 进行单值查询 select count(*) from account;
    @Test
    public void test_9() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        Object query = runner.query("select count(*) from account", new ScalarHandler());

        System.out.println(query);
    }
}
