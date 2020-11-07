package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Decentralazition;
import util.DBConnectionUtil;

public class DecentralazitionDao extends AbstractDao {
	public List<Decentralazition> findAll() {
		List<Decentralazition> list = new ArrayList<Decentralazition>();
		conn = DBConnectionUtil.getConnection();
		String SQL = "SELECT * FROM decentralization d JOIN role r ON d.idRole=r.idRole ORDER BY d.id DESC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				Decentralazition decentralazition = new Decentralazition(rs.getInt("id"), rs.getInt("addEvery"),
						rs.getInt("editEvery"), rs.getInt("delEvery"), rs.getInt("addSelf"), rs.getInt("editSelf"),
						rs.getInt("delSelf"), rs.getInt("addAnother"), rs.getInt("editAnother"),
						rs.getInt("delAnother"), rs.getInt("idRole"), rs.getString("nameRole"));
				list.add(decentralazition);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(rs, pst, conn);
		}
		return list;
	}

	public int editDecentralazition(String nameCol, int statusObjRole,  int idRole) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String sql = "UPDATE decentralization SET " + nameCol + " = ?  WHERE idRole = ? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, statusObjRole);
			pst.setInt(2, idRole);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(rs, pst, conn);
		}
		return result;
	}
}
