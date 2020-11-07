package model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Songs {
	int id;
	String name;
	String decription;
	String detail;
	Timestamp creat_at;
	String picture;
	int counter;
	Categories cat;
	

	public Songs(String name, String decription, String detail, String picture, Categories cat) {
		super();
		this.name = name;
		this.decription = decription;
		this.detail = detail;
		this.picture = picture;
		this.cat = cat;
	}
	public Songs(String name, String decription, String detail, String picture) {
		super();
		this.name = name;
		this.decription = decription;
		this.detail = detail;
		this.picture = picture;
		this.cat = cat;
	}
	public Songs(int id, String name, String decription, String detail, String picture, Categories cat) {
		super();
		this.id = id;
		this.name = name;
		this.decription = decription;
		this.detail = detail;
		this.picture = picture;
		this.cat = cat;
	}
	public Songs(int id, String name, String decription, String detail, Timestamp creat_at, String picture,
			int counter) {
		super();
		this.id = id;
		this.name = name;
		this.decription = decription;
		this.detail = detail;
		this.creat_at = creat_at;
		this.picture = picture;
		this.counter = counter;
	}
	
}
