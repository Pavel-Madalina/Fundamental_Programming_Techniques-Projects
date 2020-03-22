package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionClass {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/warehouse?useSSL=false&allowPublicKeyRetrieval=true";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "parola";
	private static ConnectionClass singleInstance = new ConnectionClass();

	private ConnectionClass() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex);
			System.exit(1);
		}
		return con;
	}

	public static void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException ex) {
			System.err.println("Exception during connection close: " + ex);
		}
	}

	public static void closeResultSet(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException ex) {
			System.err.println("Exception during resultSet close: " + ex);
		}
	}

	public static void closePreparedStatement(PreparedStatement statement) {
		try {
			statement.close();
		} catch (SQLException ex) {
			System.err.println("Exception during statement close: " + ex);
		}
	}
}
