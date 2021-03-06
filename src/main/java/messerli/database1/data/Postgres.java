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

	public static int main2(PostgresDAO pdao) {
		return pdao.createTaube(conn);
	}

	public static int main3(PostgresDAO pdao) {
		return pdao.update(conn);
	}

	public static List<String> main4(PostgresDAO pdao) {
		return pdao.list(conn);
	}

	public static List<String> main5(PostgresDAO pdao) {
		return pdao.percent(conn);
	}

	public static int main6(PostgresDAO pdao) {
		return pdao.createTaubeUndFlug(conn);
	}

	public static int main7(PostgresDAO pdao) {
		return pdao.bewertung(conn);
	}

}
