package util;

import constants.GlobalConstant;

public class PageUtil {
	public static int getEndPage(int count) {
		int endPage ;
		endPage = (int) Math.ceil(count/GlobalConstant.pageSize);
		return endPage;
	}
	public static int getOffSet(int count, int currentPage) {
		int offSet ;
		offSet = (currentPage-1)*GlobalConstant.pageSize;
		return offSet;
	}
}
