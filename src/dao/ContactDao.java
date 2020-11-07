package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Categories;
import model.Contacts;
import model.User;
import util.ConnectDBUtils;
import util.DBConnectionUtil;

public class ContactDao extends AbstractDao {
	public List<Contacts> findAll() {
		List<Contacts> list = new ArrayList<Contacts>();
		conn = DBConnectionUtil.getConnection();
		String SQL = "SELECT id,name, email ,website, message FROM contacts ORDER BY id DESC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				Contacts contacts = new Contacts(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
						rs.getString("website"), rs.getString("message"));
				list.add(contacts);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// respone.sendirect("//")
		} finally {
			DBConnectionUtil.close(rs, pst, conn);
		}
		return list;
	}
	public int addContact(Contacts contacts) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String SQL = "INSERT INTO contacts(name,email,website, message) VALUE (?,?,?,?)";
		try {
			pst = conn.prepareStatement(SQL);
			pst.setString(1, contacts.getName());
			pst.setString(2, contacts.getEmail());
			pst.setString(3, contacts.getWebsite());
			pst.setString(4, contacts.getMessage());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	public Contacts findById(int contactId) {
		Contacts itemContact = new Contacts();
		final String SQL = "SELECT * FROM contacts WHERE id=?";
		conn = ConnectDBUtils.getConnection();

		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1, contactId);
			rs = pst.executeQuery();
			if (rs.next()) {
				itemContact = new Contacts(rs.getInt("id"), rs.getString("name"),rs.getString("email"),rs.getString("website"),rs.getString("message"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtils.close(rs, st, conn);
		}
		return itemContact;

	}
	public int editContact(Contacts objContact) {
		final String sql = "UPDATE  contacts SET name= ?, email=?, website=?, message=? WHERE id=?";
		conn = DBConnectionUtil.getConnection();
		int result = 0;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objContact.getName());
			pst.setString(2, objContact.getEmail());
			pst.setString(3, objContact.getWebsite());
			pst.setString(4, objContact.getMessage());
			pst.setInt(5, objContact.getId());

			result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(rs, pst, conn);
		}

		return result;
	}
	public int deleteById(int contactId) {
		int results =0;
		final String SQL = "DELETE FROM contacts WHERE  id= ?" ;
		conn = ConnectDBUtils.getConnection();

		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1, contactId);
			results = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtils.close(rs, pst, conn);
		}
		return results;

	}
}
