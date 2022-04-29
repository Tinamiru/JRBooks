package bookDB;

import java.sql.*;

public class DBConTest {
	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "JR95", pwd = "java";

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver Loading Success!!");

			con = DriverManager.getConnection(url, user, pwd);

			String sql = "select prod_id, PROD_COST from prod where prod_id='P101000001'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String prodId = rs.getString("Prod_id");
				int prodCost = rs.getInt("PROD_COST");
				System.out.println(prodId);
				System.out.println(prodCost);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 연동 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
