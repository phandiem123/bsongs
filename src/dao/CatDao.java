package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Categories;
import util.ConnectDBUtils;
import util.DBConnectionUtil;

public class CatDao extends AbstractDao {
	public List<Categories> findAll() {
		List<Categories> list = new ArrayList<Categories>();
		conn = DBConnectionUtil.getConnection();
		String SQL = "SELECT id,name FROM categories ORDER BY id DESC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				Categories cat = new Categories(rs.getInt("id"), rs.getString("name"));
				list.add(cat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// respone.sendirect("//")
		} finally {
			DBConnectionUtil.close(rs, pst, conn);
		}
		return list;
	}
	public List<Categories> searchAllCatByTextSearch(String textSearch) {
		List<Categories> list = new ArrayList<Categories>();
		conn = DBConnectionUtil.getConnection();
		String SQL = "SELECT * FROM categories WHERE name LIKE ? ORDER BY id DESC";
		try {
			pst = conn.prepareStatement(SQL);
			pst.setString(1, textSearch);
			rs = pst.executeQuery();
			while (rs.next()) {
				Categories cat = new Categories(rs.getInt("id"), rs.getString("name"));
				list.add(cat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// respone.sendirect("//")
		} finally {
			DBConnectionUtil.close(rs, pst, conn);
		}
		return list;
	}

	public int addCat(Categories cat) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String SQL = "INSERT INTO categories(name) VALUE (?)";
		try {
			pst = conn.prepareStatement(SQL);
			pst.setString(1, cat.getName());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public Categories findById(int catId) {
		Categories itemCat = new Categories();
		final String SQL = "SELECT * FROM categories WHERE id=?";
		conn = ConnectDBUtils.getConnection();

		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1, catId);
			rs = pst.executeQuery();
			if (rs.next()) {
				itemCat = new Categories(rs.getInt("id"), rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtils.close(rs, st, conn);
		}
		return itemCat;

	}

	public int editCat(Categories objCat) {
		final String sql = "UPDATE  categories SET name= ? WHERE id=?";
		conn = DBConnectionUtil.getConnection();
		int result = 0;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objCat.getName());
			pst.setInt(2, objCat.getId());

			result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(rs, pst, conn);
		}

		return result;
	}
	public int deleteById(int catId) {
		int results =0;
		final String SQL = "DELETE FROM categories WHERE  id= ?" ;
		conn = ConnectDBUtils.getConnection();

		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1, catId);
			results = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtils.close(rs, pst, conn);
		}
		return results;

	}
}
