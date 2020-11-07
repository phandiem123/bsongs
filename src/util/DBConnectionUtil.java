package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionUtil {
//	private static String url = "jdbc:mysql://node236055-bsong-diem.j.layershift.co.uk/bsong?useUnicode=true&characterEncoding=UTF-8";
	private static String url = "jdbc:mysql://localhost:3306/bsong?useUnicode=true&characterEncoding=UTF-8";
	private static String user = "root";
	private static String password = "";
//	private static String password = "DTFtzh88316";
	private static Connection conn = null;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println("Không thể nạp driver");
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(ResultSet rs) {
		if (rs !=null ) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void close(Statement st) {
		if (st !=null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void close(Connection conn) {
		if (conn!= null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void close(ResultSet rs , Statement st, Connection conn) {
		close(rs);
		close(st);
		close(conn);
	}
	public static void main(String[] args) {
		System.out.println(DBConnectionUtil.getConnection());
	}
}
