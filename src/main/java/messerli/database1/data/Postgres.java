package messerli.database1.data;

import java.sql.*;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Postgres {
	private final String url = "jdbc:postgresql://localhost/taube";
	private final String user = "postgres";
	private final String password = "norah357";
	private static Connection conn = null;
	// private static Statement stmt = null;

	public Connection connect() {
		// Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);

			if (conn != null) {
				System.out.println("Connected to the PostgreSQL server is sucessful");
			} else {
				System.out.println("Failed to make connection!");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return conn;
	}

	public static List<String> main1(PostgresDAO pdao) {
		return pdao.select(conn);

	}

	public static List<String> main2(PostgresDAO pdao) {
		return pdao.create(conn);
	}

}
