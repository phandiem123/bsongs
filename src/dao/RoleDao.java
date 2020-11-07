package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Role;
import model.User;
import util.ConnectDBUtils;
import util.DBConnectionUtil;

public class RoleDao  extends AbstractDao{
	public List<Role> findAll() {
		List<Role> list = new ArrayList<Role>();
		conn = DBConnectionUtil.getConnection();
		String SQL = "SELECT * FROM role ";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				Role decentralazition = new Role(rs.getInt("idRole"), rs.getString("nameRole"));
				list.add(decentralazition);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// respone.sendirect("//")
		} finally {
			DBConnectionUtil.close(rs, pst, conn);
		}
		return list;
	}
	public Role findById(int idRole) {
		Role itemRole = new Role();
		final String SQL = "SELECT * FROM role WHERE idRole=?";
		conn = ConnectDBUtils.getConnection();

		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1, idRole);
			rs = pst.executeQuery();
			if (rs.next()) {
				itemRole = new Role(rs.getInt("idRole"), rs.getString("nameRole"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtils.close(rs, st, conn);
		}
		return itemRole;

	}
}
