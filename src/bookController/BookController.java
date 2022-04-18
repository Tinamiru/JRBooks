package bookController;

import bookVO.BookVO;

import java.util.List;
import java.util.Scanner;
import bookService.BookService;

public class BookController {
	BookService bookService = new BookService();
	Scanner sc = new Scanner(System.in);

	public void mainView() {
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("1.책 등록\t\t2.책 삭제\t\t3.책 목록\t\t4.종료");
		System.out.println("------------------------------------------------------------------------------");
		int input = Integer.parseInt(sc.nextLine());
		switch (input) {
		case 1:
			insertView();
		case 2:
			deleteView();
		case 3:
			listView();
		case 4:
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("도서 등록 서비스를 종료합니다.");
			System.out.println("------------------------------------------------------------------------------");
			break;
		}
	}

	public void insertView() {
		BookVO bookVO = new BookVO();
		System.out.println("책 등록 메뉴입니다.");
		System.out.println("------------------------------------------------------------------------------");
		System.out.print("책 제목을 입력하세요.");
		String bookName = sc.nextLine();

		System.out.print("글쓴이를 입력하세요.");
		String bookWriter = sc.nextLine();
	
		System.out.print("출판일을 입력하세요.");
		String date = sc.nextLine();
		
		bookVO.setBookName(bookName);
		bookVO.setWriter(bookWriter);
		bookVO.setDate(date);
		bookService.insertBook(bookVO);
		
		System.out.println("등록한 책 정보");
		System.out.println("제목 : " + bookVO.getBookName());
		System.out.println("글쓴이 : " + bookVO.getWriter());
		System.out.println("출판일 : " + bookVO.getDate());
		mainView();
	}

	private void deleteView() {
		BookVO bookVO = new BookVO();
		System.out.println("삭제할 책 제목을 입력하세요.");
		String bookName = sc.next();
		System.out.println("글쓴이를 입력하세요.");
		String bookWriter = sc.next();
		bookVO.setBookName(bookName);
		bookVO.setWriter(bookWriter);
		bookService.deleteBook(bookVO);
		System.out.println("책이 삭제되었습니다.");
		mainView();
	}

	private void listView() {
		System.out.println("책 리스트 입니다.");
		List<BookVO> bookList = bookService.bookList();
		for (BookVO bookVO : bookList) {
			System.out.println("제목 : " + bookVO.getBookName());
			System.out.println("글쓴이 : " + bookVO.getWriter());
			System.out.println("출판일 : " + bookVO.getDate());
			System.out.println("------------------------------------------------------------------------------");
		}
		mainView();
	}

}