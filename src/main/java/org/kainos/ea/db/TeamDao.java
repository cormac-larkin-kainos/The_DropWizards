package org.kainos.ea.db;

import org.kainos.ea.cli.Team;

import java.sql.*;

public class TeamDao {

    public Team getTeamById(int id) throws SQLException {

        Connection c = DatabaseConnector.getConnection();

        String selectQuery ="SELECT team_id, team_type FROM Team WHERE team_id=?";

        PreparedStatement st = c.prepareStatement(selectQuery);

        st.setInt(1,id);

       ResultSet rs =  st.executeQuery();


        if(rs.next()){
            return new Team(
                    rs.getInt("team_id"),
                    rs.getString("team_type")
            );
        }

        return null;

    }
}
