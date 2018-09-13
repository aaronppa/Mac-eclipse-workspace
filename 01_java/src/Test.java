
public class Test {
	public static void main(String[] args) {
		int no = 3;
		String title = "제목";
		String content = "내용";
		String writer = "글쓴이";
		String query = "insert into tb_board("
				+      "    no, title, writer, content"
				+      " ) values( "
				+      "    " + no + ", '" + title + "', '" + content + "', writer "
				+      ")";
	}
}
