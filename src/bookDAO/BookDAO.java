package bookDAO;

import bookVO.BookList;
import bookVO.BookVO;
import java.util.List;

public class BookDAO {

	BookList bookList = new BookList();

	public void insertBook(BookVO bookVO) {
		bookList.getBookVOList().add(bookVO);
	}

	public void deleteBook(BookVO bookVO) {
		for (int i = 0; i < bookList.getBookVOList().size(); i++) {
			if (bookList.getBookVOList().get(i).getBookName().equals(bookVO.getBookName())
					&& bookList.getBookVOList().get(i).getWriter().equals(bookVO.getWriter())) {
				bookList.getBookVOList().remove(i);
			} else {
				System.out.println("제목과 글쓴이가 일치하지 않습니다.");
			}
			break;
		}
	}

	public List<BookVO> bookList() {
		return bookList.getBookVOList();
	}
}