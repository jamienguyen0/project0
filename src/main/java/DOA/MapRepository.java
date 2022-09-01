package DOA;

import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapRepository {
    Connection conn = ConnectionUtil.getConnection();

    public String getMapNameFromID(int id) {
        try {
            PreparedStatement statement = conn.prepareStatement("Select * from maps where mapID = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("mapName");
                return name;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void addMap(int id, String mapName) {
        try {
            PreparedStatement statement = conn.prepareStatement("insert into maps(mapID, mapName) values(?,?)");
            statement.setInt(1, id);
            statement.setString(2, mapName);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
