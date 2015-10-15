package uo.ri.bussness.impl.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import alb.util.jdbc.Jdbc;

public class ListMechanics {

	private static String SQL = "select id, nombre, apellidos from TMecanicos";

	private List<Map<String, Object>> result = new LinkedList<>();
	{
		result = new LinkedList<>();
	}

	public List<Map<String, Object>> getResult() {
		return result;
	}

	public void execute() {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Map<String, Object> map;

		try {
			c = Jdbc.getConnection();

			pst = c.prepareStatement(SQL);

			rs = pst.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("id", rs.getLong(1));
				map.put("nombre", rs.getString(2));
				map.put("apellidos", rs.getString(3));
				result.add(map);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(rs, pst, c);
		}
	}

}
