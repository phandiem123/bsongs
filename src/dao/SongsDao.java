package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import constants.GlobalConstant;
import model.Categories;
import model.Songs;
import util.ConnectDBUtils;
import util.DBConnectionUtil;
import util.StringUtil;

public class SongsDao extends AbstractDao {
	public List<Songs> findAll() {
		List<Songs> list = new ArrayList<Songs>();
		conn = DBConnectionUtil.getConnection();
		String SQL = "SELECT s.*, c.name as catName FROM songs AS s"
				+ " INNER JOIN categories AS c"
				+ " ON s.cat_id = c.id"
				+ " ORDER BY s.id DESC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				Songs songs = new Songs(rs.getInt("id"),
						rs.getString("name"), 
						rs.getString("preview_text"),
						rs.getString("detail_text"), 
						rs.getTimestamp("date_create"), 
						rs.getString("picture"),
						rs.getInt("counter"), 
						new Categories(rs.getInt("cat_id"), rs.getString("catName")));
				list.add(songs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(rs, pst, conn);
		}
		return list;
	}
	public List<Songs> searchAllSongByIdCat(int idCat, String editboxSearch ) {
		List<Songs> list = new ArrayList<Songs>();
		conn = DBConnectionUtil.getConnection();
		String SQL = "SELECT s.*, c.name as catName "
				+ "FROM songs AS s INNER JOIN categories AS c "
				+ "ON s.cat_id = c.id WHERE s.name LIKE ?"
				+ "AND s.cat_id = ?";
		try {
			pst = conn.prepareStatement(SQL);
			pst.setString(1,"%" + editboxSearch + "%");
			pst.setInt(2, idCat);
			rs = pst.executeQuery();;
			while (rs.next()) {
				Songs songs = new Songs(rs.getInt("id"),
						rs.getString("name"), 
						rs.getString("preview_text"),
						rs.getString("detail_text"), 
						rs.getTimestamp("date_create"), 
						rs.getString("picture"),
						rs.getInt("counter"));
				list.add(songs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(rs, pst, conn);
		}
		return list;
	}
	public List<Songs> findAllSongLikeTextSearch(String editboxSearch) {
		List<Songs> list = new ArrayList<Songs>();
		conn = DBConnectionUtil.getConnection();
		String SQL = "SELECT * FROM songs WHERE name LIKE ?";
		try {
			pst = conn.prepareStatement(SQL);
			pst.setString(1,"%" + editboxSearch + "%");
			rs = pst.executeQuery();
			while (rs.next()) {
				Songs songs = new Songs(rs.getInt("id"), rs.getString("name"),
						rs.getString("preview_text"), rs.getString("detail_text"),
						rs.getTimestamp("date_create"),  rs.getString("picture"), rs.getInt("counter"));
				list.add(songs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(rs, pst, conn);
		}
		return list;
	}

	public int editSong(Songs songs) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String sql = "UPDATE songs SET name = ? , preview_text = ? , detail_text = ? , picture = ? , cat_id = ? WHERE id = ? ";
		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, songs.getName());
			pst.setString(2, songs.getDecription());
			pst.setString(3, songs.getDetail());
			pst.setString(4, songs.getPicture());
			pst.setInt(5, songs.getCat().getId());
			pst.setInt(6, songs.getId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(rs, pst, conn);
		}
		return result;
	}

	public int editCountSong(int idSong) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String sql = "UPDATE songs SET counter = counter+1  WHERE id = ? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idSong);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(rs, pst, conn);
		}
		return result;
	}

	public List<Songs> findByIdCat(int idCat, int page) {
		List<Songs> list = new ArrayList<Songs>();
		conn = DBConnectionUtil.getConnection();
		String SQL = "SELECT s.*, c.name as catName FROM songs AS s INNER JOIN categories AS c "
				+ "ON s.cat_id =c.id WHERE s.cat_id=? ORDER BY s.id DESC LIMIT ? OFFSET ?";
		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1, idCat);
			pst.setInt(2, GlobalConstant.pageSize);
			pst.setInt(3, (page - 1) * GlobalConstant.pageSize);
			rs = pst.executeQuery();
			while (rs.next()) {
				Songs songs = new Songs(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"),
						rs.getString("detail_text"), rs.getTimestamp("date_create"), rs.getString("picture"),
						rs.getInt("counter"), new Categories(rs.getInt("cat_id"), rs.getString("catName")));
				list.add(songs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// respone.sendirect("//")
		} finally {
			DBConnectionUtil.close(rs, pst, conn);
		}
		return list;
	}

	public List<Songs> getNewSong() {
		List<Songs> list = new ArrayList<Songs>();
		conn = DBConnectionUtil.getConnection();
		String SQL = "SELECT s.*, c.name as catName FROM songs AS s INNER JOIN categories AS c "
				+ "ON s.cat_id =c.id ORDER BY s.date_create DESC LIMIT 5 OFFSET 0";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				Songs songs = new Songs(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"),
						rs.getString("detail_text"), rs.getTimestamp("date_create"), rs.getString("picture"),
						rs.getInt("counter"), new Categories(rs.getInt("cat_id"), rs.getString("catName")));
				list.add(songs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// respone.sendirect("//")
		} finally {
			DBConnectionUtil.close(rs, pst, conn);
		}
		return list;
	}
	public List<Songs> getConnectSongs(int idSong, int idCat) {
		List<Songs> list = new ArrayList<Songs>();
		conn = DBConnectionUtil.getConnection();
		String SQL = "SELECT s.*, c.name as catName "
				+ "FROM songs AS s INNER JOIN categories AS c "
				+ "ON s.cat_id =c.id WHERE s.id!=? AND s.cat_id= ? "
				+ "ORDER BY s.date_create DESC LIMIT 3 OFFSET 0";
		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1,idSong);
			pst.setInt(2,idCat);
			rs = pst.executeQuery();
			while (rs.next()) {
				Songs songs = new Songs(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"),
						rs.getString("detail_text"), rs.getTimestamp("date_create"), rs.getString("picture"),
						rs.getInt("counter"), new Categories(rs.getInt("cat_id"), rs.getString("catName")));
				list.add(songs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// respone.sendirect("//")
		} finally {
			DBConnectionUtil.close(rs, pst, conn);
		}
		return list;
	}

	public List<Songs> getNew100Song() {
		List<Songs> list = new ArrayList<Songs>();
		conn = DBConnectionUtil.getConnection();
		String SQL = "SELECT s.*, c.name as catName FROM songs AS s INNER JOIN categories AS c "
				+ "ON s.cat_id =c.id ORDER BY s.date_create DESC LIMIT 100 OFFSET 0";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				Songs songs = new Songs(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"),
						rs.getString("detail_text"), rs.getTimestamp("date_create"), rs.getString("picture"),
						rs.getInt("counter"), new Categories(rs.getInt("cat_id"), rs.getString("catName")));
				list.add(songs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// respone.sendirect("//")
		} finally {
			DBConnectionUtil.close(rs, pst, conn);
		}
		return list;
	}

	public Songs findByIdSong(int id) {
		Songs songs = null;
		conn = DBConnectionUtil.getConnection();
		String SQL = "SELECT * FROM songs WHERE id =?";
		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				songs = new Songs(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"),
						rs.getString("detail_text"), rs.getTimestamp("date_create"), rs.getString("picture"),
						rs.getInt("counter"), new Categories(rs.getInt("cat_id"), null));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// respone.sendirect("//")
		} finally {
			DBConnectionUtil.close(rs, pst, conn);
		}
		return songs;
	}

	public int addSongs(Songs songs) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String SQL = "INSERT INTO songs(name, preview_text, detail_text,picture,cat_id) VALUE (?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(SQL);
			pst.setString(1, songs.getName());
			pst.setString(2, songs.getDecription());
			pst.setString(3, songs.getDetail());
			pst.setString(4, songs.getPicture());
			pst.setInt(5, songs.getCat().getId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	public int deleteById(int songId) {
		int results = 0;
		final String SQL = "DELETE FROM songs WHERE  id= ?";
		conn = ConnectDBUtils.getConnection();

		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1, songId);
			results = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtils.close(rs, pst, conn);
		}
		return results;
	}
	public int deleteByIdCat(int catId) {
		int results = 0;
		final String SQL = "DELETE FROM songs WHERE cat_id =2";
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

	public List<Songs> getAllSongsInPage(int page) {
		List<Songs> list = new ArrayList<Songs>();
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT s.*, c.name as catName FROM songs AS s INNER JOIN categories AS c ON s.cat_id =c.id "
				+ "ORDER BY s.date_create DESC LIMIT ? OFFSET ?";

		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1, GlobalConstant.pageSize);
			pst.setInt(2, (page - 1) * GlobalConstant.pageSize);
			rs = pst.executeQuery();
			while (rs.next()) {
				Songs songs = new Songs(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"),
						rs.getString("detail_text"), rs.getTimestamp("date_create"), rs.getString("picture"),
						rs.getInt("counter"), new Categories(rs.getInt("cat_id"), rs.getString("catName")));
				list.add(songs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtils.close(rs, pst, conn);
		}
		return list;
	}

	// dem so luong bai hat va so trang
	public int getCount() {
		int count = 0;
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT COUNT(id) FROM songs";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt(1);
				int countPage = count / GlobalConstant.pageSize; // dem so trang
				if (count % (GlobalConstant.pageSize) != 0) {
					countPage++;
				}
				return countPage;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(rs, st, conn);
		}
		return 0;
	}
	// get cout by Idcat
	public int getCountByIdCat(int idCat) {
		int count = 0;
		conn = DBConnectionUtil.getConnection();
		String SQL = "SELECT COUNT(id) FROM songs WHERE cat_id=?";
		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1, idCat);
			rs = pst.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
				int countPage = count / GlobalConstant.pageSize; // dem so trang
				if (count % (GlobalConstant.pageSize) != 0) {
					countPage++;
				}
				return countPage;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(rs, pst, conn);
		}
		return 0;
	}

	// lay gia tri tim kiem gan giong
	public int getCountSearch(String editbox_search) {
		final String SQL = "SELECT COUNT(*) FROM songs WHERE name LIKE ?";
		conn = ConnectDBUtils.getConnection();

		try {
			pst = conn.prepareStatement(SQL);
			pst.setString(1, "%" + editbox_search + "%");
			rs = pst.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtils.close(rs, pst, conn);
		}
		return 0;
	}

	public int getCountNewSong() {
		int count = 0;
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT COUNT(id) FROM songs ORDER BY date_create DESC LIMIT 100 OFFSET 0";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt(1);
				int countPage = count / 5;
				if (count % 5 != 0) {
					countPage++;
				}
				return countPage;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(rs, st, conn);
		}
		return 0;
	}

}
