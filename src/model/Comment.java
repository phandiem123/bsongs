package model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
	int id;
	String name;
	String textComment;
	Timestamp dateCreat;
	int idSong;	
	String textReply;
	public Comment(int id, String name, String textComment, Timestamp dateCreat, int idSong) {
		super();
		this.id = id;
		this.name = name;
		this.textComment = textComment;
		this.dateCreat = dateCreat;
		this.idSong = idSong;
	}
	
}
