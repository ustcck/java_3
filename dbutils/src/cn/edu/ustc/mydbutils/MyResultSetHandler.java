package cn.edu.ustc.mydbutils;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface MyResultSetHandler<T> {

	public T handle(ResultSet rs) throws SQLException ;
}
