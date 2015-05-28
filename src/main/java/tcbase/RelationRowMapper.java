package tcbase;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RelationRowMapper implements RowMapper<Relation>{
	public Relation mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Relation(rs.getInt("id"), rs.getString("type"),
                rs.getString("sentence"), rs.getString("link"), rs.getString("arg1type"),
                rs.getString("arg1name"),rs.getString("arg2type"), rs.getString("arg2name"));
	}

}
