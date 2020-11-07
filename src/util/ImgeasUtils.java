package util;

import java.util.ArrayList;

public class ImgeasUtils {
	public static String ChangeImgeasToNameCol(int idNameCol) {
		String nameCol=null;
		switch (idNameCol) {
		case 1: nameCol = "addEvery";break;
		case 2: nameCol = "editEvery";break;
		case 3: nameCol = "delEvery";break;
		case 4: nameCol = "addSelf";break;
		case 5: nameCol = "editSelf";break;
		case 6: nameCol = "delSelf";break;
		case 7: nameCol = "addAnother";break;
		case 8: nameCol = "editAnother";break;
		case 9: nameCol = "delAnother";break;
		default:
			break;
		}
		return nameCol;
	}
}
