package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Decentralazition {
	int id ;
	int addEvery;
	int editEvery;
	int delEvery;
	int addSelf;
	int editSelf;
	int delSelf;
	int addAnother;
	int editAnother;
	int delAnother;
	int idRole;
}
