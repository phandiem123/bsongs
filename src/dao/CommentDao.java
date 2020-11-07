package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import constants.GlobalConstant;
import model.Categories;
import model.Comment;
import model.Songs;
import util.DBConnectionUtil;

public class CommentDao extends AbstractDao {
	public List<Comment> findAllCommentByIdSong(int idSong ) {
		List<Comment> list = new ArrayList<Comment>();
		conn = DBConnectionUtil.getConnection();
		String SQL = "SELECT * FROM comment WHERE idSong= ? ";
		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1, idSong);
			rs = pst.executeQuery();
			while (rs.next()) {
				Comment comment = new Comment(rs.getInt("id"),
						rs.getString("name"), 
						rs.getString("textComment"),
						rs.getTimestamp("dateCreat"), 
						rs.getInt("idSong"),
						rs.getString("textReply"));
				list.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(rs, pst, conn);
		}
		return list;
	}
	public int addComment(Comment comment,int idSong) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String SQL = "INSERT INTO comment(name , textComment , idSong , textReply) VALUES (?,?,?,0)";
		try {
			pst = conn.prepareStatement(SQL);
			pst.setString(1, comment.getName());
			pst.setString(2, comment.getTextComment());
			pst.setInt(3, idSong);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<Comment> findCommentByIdSong(int idSong) {
		List<Comment> list = new ArrayList<Comment>();
		conn = DBConnectionUtil.getConnection();
		String SQL = "SELECT * FROM comment WHERE idSong= ? ORDER BY dateCreat DESC LIMIT ? OFFSET ?";
		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1, idSong);
			pst.setInt(2, GlobalConstant.numberOfComment);
		//	pst.setInt(3, (page - 1) * GlobalConstant.pageSize);
			rs = pst.executeQuery();
			while (rs.next()) {
				Comment comment = new Comment(rs.getInt("id"),
						rs.getString("name"), 
						rs.getString("textComment"),
						rs.getTimestamp("dateCreat"), 
						rs.getInt("idSong"),
						rs.getString("textReply"));
				list.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// respone.sendirect("//")
		} finally {
			DBConnectionUtil.close(rs, pst, conn);
		}
		return list;
	}
}
