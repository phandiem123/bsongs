package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categories {
	int id;
	String name;
	public Categories(int id) {
		super();
		this.id = id;
	}
	
}
