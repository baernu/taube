package messerli.database1.postgres_classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import messerli.database1.data.PostgresDAO;

public class SelectTaubenflug implements PostgresDAO {

    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private String idTaube;
    private String idFlug;
    private java.sql.Timestamp endzeit;
    private boolean preis;
    private int rang;
    private double distance;
    private String zuechter;
    private int saison;

    public SelectTaubenflug(String besitzer, int saison) {
        this.zuechter = besitzer;
        this.saison = saison;
    }

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

            String SQL = "select taube.taubenid, taubenflug.rang ,taubenflug.endzeit - flug.auflasszeit as flugzeit, taubenflug.preis from taube, flug, taubenflug where  taube.taubenid = taubenflug.taubenid and flug.flugid = taubenflug.flugid and taube.taubenid = ? and flug.flugid = ?";

            ps = conn.prepareStatement(SQL);

            ps.setString(1, idTaube);
            ps.setString(2, idFlug);

            // stmt = conn.createStatement();
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add("Taubenid: " + rs.getString(1) + "    Rang: " + rs.getString(2) + "    Flugzeit: "
                        + rs.getString(3) + "    Preis: " + rs.getBoolean(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int update(Connection conn) {
        int i = -1;

        try {
            String SQL = "update taubenflug set endzeit = ?, preis = ?, rang = ?, distance = ?, zuechter = ?  where taubenflug.taubenid = ? and taubenflug.flugid = ?";
            ps = conn.prepareStatement(SQL);

            ps.setTimestamp(1, this.endzeit);
            ps.setBoolean(2, this.preis);
            ps.setInt(3, this.rang);
            ps.setDouble(4, this.distance);
            ps.setString(5, this.zuechter);
            ps.setString(6, this.idTaube);
            ps.setString(7, this.idFlug);

            i = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return i;
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

    @Override
    public List<String> list(Connection conn) {
        List<String> list = new ArrayList<>();

        try {

            // String SQL = "select taubenflug.taubenid, count(taubenflug.preis = ?) from
            // taubenflug, flug where taubenflug.zuechter = ? and flug.saison = ? group by
            // taubenflug.taubenid order by count(taubenflug.preis) desc,
            // taubenflug.taubenid;";
            String SQL = "select taubenflug.taubenid, coalesce (sum(case when taubenflug.preis then ? else ? end),?) from  taubenflug, flug where taubenflug.zuechter = ? and flug.saison = ? group by taubenflug.taubenid order by count(taubenflug.preis) desc, taubenflug.taubenid;";
            ps = conn.prepareStatement(SQL);

            ps.setInt(1, 1);
            ps.setInt(2, 0);
            ps.setInt(3, 0);
            ps.setString(4, this.zuechter);
            ps.setInt(5, this.saison);

            rs = ps.executeQuery();

            while (rs.next()) {
                list.add("    Taubenid: " + rs.getString(1) + "    Preise: " + rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
