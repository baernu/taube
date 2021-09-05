package messerli.database1.data;

import java.sql.*;
import java.util.ArrayList;
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
	private static ResultSet rs = null;

	private String idtaube;
	private String idflug;

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

	public static List<String> main1() {

		List<String> list = new ArrayList<>();

		try {
			String SQL = null;

			/*
			 * String SQL = "select taube.taubenid, flug.flugid, taubenflug.endzeit -
			 * flug.auflasszeit as flugzeit from taube, flug, taubenflug where
			 * taube.taubenid = ? and flug.flugid = ? and taube.taubenid = ? and flug.flugid
			 * = ? ";
			 */
			PreparedStatement ps = conn.prepareStatement(SQL);

			/*
			 * ps.setString(1, taubenflug.taubenid); ps.setString(2, taubenflug.flugid);
			 * ps.setString(3, this.idtaube); ps.setString(4, this.idflug);
			 */
			// stmt = conn.createStatement();
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(rs.getString(1)); // + " " + rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public void setIdtaube(String idtaube) {
		this.idtaube = idtaube;
	}

	public void setIdflug(String idflug) {
		this.idflug = idflug;
	}

}
