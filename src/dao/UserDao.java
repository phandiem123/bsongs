package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Categories;
import model.Songs;
import model.User;
import util.ConnectDBUtils;
import util.DBConnectionUtil;

public class UserDao extends AbstractDao {
	public List<User> findAll() {
		List<User> list = new ArrayList<User>();
		conn = DBConnectionUtil.getConnection();
		String SQL = "SELECT id,username,password, fullname FROM users ORDER BY id DESC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				User user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
						rs.getString("fullname"), rs.getInt("ididRole"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// respone.sendirect("//")
		} finally {
			DBConnectionUtil.close(rs, pst, conn);
		}
		return list;
	}

	public int addUser(User user) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String SQL = "INSERT INTO users(username,password,fullname) VALUE (?,?,?)";
		try {
			pst = conn.prepareStatement(SQL);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getFullname());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public User findById(int idUser) {
		User itemUser = new User();
		final String SQL = "SELECT * FROM users WHERE id=?";
		conn = ConnectDBUtils.getConnection();

		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1, idUser);
			rs = pst.executeQuery();
			if (rs.next()) {
				itemUser = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
						rs.getString("fullname"), rs.getInt("idRole"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtils.close(rs, st, conn);
		}
		return itemUser;

	}
	public List<User> findByIdRole(int idRole) {
		List<User> list =  new ArrayList<User>();
		final String SQL = "SELECT * FROM users WHERE idRole=?";
		conn = ConnectDBUtils.getConnection();

		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1, idRole);
			rs = pst.executeQuery();
			if (rs.next()) {
				User user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
						rs.getString("fullname"), rs.getInt("idRole"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtils.close(rs, st, conn);
		}
		return list;

	}

	public int editUser(User objUser) {
		final String sql = "UPDATE  users SET username= ?, password=?, fullname=? WHERE id=?";
		conn = DBConnectionUtil.getConnection();
		int result = 0;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objUser.getUsername());
			pst.setString(2, objUser.getPassword());
			pst.setString(3, objUser.getFullname());
			pst.setInt(4, objUser.getId());

			result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(rs, pst, conn);
		}

		return result;
	}

	public int deleteById(int idUser) {
		int results = 0;
		final String SQL = "DELETE FROM users WHERE  id= ?";
		conn = ConnectDBUtils.getConnection();

		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1, idUser);
			results = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtils.close(rs, pst, conn);
		}
		return results;

	}

	public User findByUsernameAndPassword(String username, String password) {
		User itemUser = null;
		final String SQL = "SELECT * FROM users WHERE username=? AND password =?";
		conn = ConnectDBUtils.getConnection();

		try {
			pst = conn.prepareStatement(SQL);
			pst.setString(1, username);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if (rs.next()) {
				itemUser = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
						rs.getString("fullname"), rs.getInt("idRole"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtils.close(rs, st, conn);
		}
		return itemUser;
	}
	public int editUser(int idUser,User user) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String sql = "UPDATE users SET idRole = ? WHERE id =? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, user.getIdRole());
			pst.setInt(2, user.getId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(rs, pst, conn);
		}
		return result;
	}
}
