package BoardMapper;

import java.util.List;

import PracticeBoard.Board;

public interface BoardMapper {

	List<Board> selectBoard();
	Board selectBoardbyNo(int no);
	void insertBoard(Board board);
	int updateBoard(Board board);
	int deleteBoard(int no);
	int updateViewCnt(int no);
	
} // end class
