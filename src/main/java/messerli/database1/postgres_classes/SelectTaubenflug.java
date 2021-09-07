package messerli.database1.postgres_classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jdk.jfr.Timestamp;
import messerli.database1.data.PostgresDAO;

public class SelectTaubenflug implements PostgresDAO {

    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private final String idTaube;
    private final String idFlug;
    private java.sql.Timestamp endzeit;
    private boolean preis;
    private int rang;
    private double distance;
    private String zuechter;

    public SelectTaubenflug(String idTaube, String idFlug) {
        this.idTaube = idTaube;
        this.idFlug = idFlug;
    }

    public SelectTaubenflug(String idTaube, String idFlug, String endzeit, String preis, String rang, String distance,
            String zuechter) {
        this(idTaube, idFlug);
        this.endzeit = java.sql.Timestamp.valueOf(endzeit);
        this.preis = Boolean.valueOf(preis);
        this.rang = Integer.parseInt(rang);
        this.distance = Double.parseDouble(distance);
        this.zuechter = zuechter;

    }

    @Override
    public List<String> select(Connection conn) {
        List<String> list = new ArrayList<>();

        try {

            String SQL = "select taube.taubenid, taubenflug.rang ,taubenflug.endzeit - flug.auflasszeit as flugzeit from taube, flug, taubenflug where  taube.taubenid = taubenflug.taubenid and flug.flugid = taubenflug.flugid and taube.taubenid = ? and flug.flugid = ?";

            // String SQL "select taube.taubenid, flug.flugid, taubenflug.endzeit -
            // flug.auflasszeit as flugzeit from taube, flug, taubenflug where
            // taube.taubenid = taubenflug.taubenid and flug.flugid = taubenflug.flugid and
            // taube.taubenid = ? and flug.flugid = ?";

            ps = conn.prepareStatement(SQL);

            ps.setString(1, idTaube);
            ps.setString(2, idFlug);

            // stmt = conn.createStatement();
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<String> update(Connection conn) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<String> drop(Connection conn) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<String> create(Connection conn) {
        List<String> list = new ArrayList<>();
        try {
            String SQL = "insert into taubenflug (taubenid, flugid, endzeit, preis, rang, distance, zuechter) values (?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, this.idTaube);
            ps.setString(2, this.idFlug);
            ps.setTimestamp(3, this.endzeit);
            ps.setBoolean(4, this.preis);
            ps.setInt(5, this.rang);
            ps.setDouble(6, this.distance);
            ps.setString(7, this.zuechter);

            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;

    }

}
