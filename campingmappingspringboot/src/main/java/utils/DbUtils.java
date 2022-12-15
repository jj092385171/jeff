package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DbUtils {
	private static HikariDataSource ds;
	private static final ThreadLocal<Connection> THREAD_LOCAL = new ThreadLocal<>();
	static {
		HikariConfig config = new HikariConfig("/datasource.properties");
//		config.setAutoCommit(true);
//		config.setConnectionTimeout(30000);
//		config.setIdleTimeout(600000);
//		config.setMaximumPoolSize(15);
//		config.setMaxLifetime(28740000);
//		config.setMinimumIdle(5);
//		config.setPoolName("CampingMappingtoHikari");
//		config.addDataSourceProperty("cachePrepStmts", "true");
//		config.addDataSourceProperty("prepStmtCacheSize", "300");
//		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		ds = new HikariDataSource(config);
	}

	public static Connection getConnection() {
		Connection connection = THREAD_LOCAL.get();
		if (connection == null) {
			try {
				connection = ds.getConnection();
				THREAD_LOCAL.set(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return connection;
	}

	public static void begin() {
		Connection connection = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void commit() {
		Connection connection = null;
		try {
			connection = getConnection();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(connection, null, null);
		}
	}

	public static void rollbacl() {
		Connection connection = null;
		try {
			connection = getConnection();
			connection.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(connection, null, null);
		}
	}

	public static void closeAll(Connection connection, Statement statement, ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
				THREAD_LOCAL.remove();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}