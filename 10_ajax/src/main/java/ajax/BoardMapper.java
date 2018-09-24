package ajax;

import java.util.List;


public interface BoardMapper {
	List<Board> selectBoard();
	Board selectBoardDetail(int no);
	List<Comment> selectComments(int no);
}