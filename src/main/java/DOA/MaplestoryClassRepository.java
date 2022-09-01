package DOA;

import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MaplestoryClassRepository {
    Connection conn = ConnectionUtil.getConnection();

    public String getClassNameFromID(int id) {
        try {
            PreparedStatement statement = conn.prepareStatement("Select * from msclasses where classID = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("className");
                return name;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "";
    }
}
