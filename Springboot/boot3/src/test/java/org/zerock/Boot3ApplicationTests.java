package org.zerock;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.domain.Board;
import org.zerock.domain.QBoard;
import org.zerock.persistence.BoardRepository;

import com.querydsl.core.BooleanBuilder;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class Boot3ApplicationTests {
	
	@Autowired
	private BoardRepository boardRepository;
	
//	@Test
//	void testInsert200() {
//		for(int i=1;i<=200;i++) {
//			Board board = new Board();
//			board.setTitle("제목.."+i);
//			board.setContent("내용..."+i+"채우기");;
//			board.setWriter("user0"+(i%10));
//			this.boardRepository.save(board);
//		}
//	}
//	@Test
//	public void testByTitle() {
//		this.boardRepository.findByTitle("제목..177").forEach(board -> System.out.println(board));
//	}
//	@Test
//	public void testByWriter() {
//		Collection<Board> results = this.boardRepository.findByWriter("user00");
//		results.forEach(board -> System.out.println(board));
//		
//	}
//	@Test
//	public void testByWriterContaining() {
//		Collection<Board> results = this.boardRepository.findByWriterContaining("05");
//		results.forEach(board -> System.out.println(board));
//	}
//	@Test
//	public void testByTitleContainingAndBnoGreaterThan() {
//		Collection<Board> results = this.boardRepository.findByTitleContainingAndBnoGreaterThan("5", 50L);
//		results.forEach(board -> System.out.println(board));
//	}
//	@Test
//	public void testByBnoOrderBy() {
//		Collection<Board> results = this.boardRepository.findByBnoGreaterThanOrderByBnoDesc(90L);
//		results.forEach(board -> System.out.println(board));
//	}
//	@Test
//	public void testBnoPagingSort() {
//		Pageable paging = PageRequest.of(0,10,Sort.Direction.ASC,"bno");
//		Page<Board> result = this.boardRepository.findByBnoGreaterThan(0L, paging);
//		
//		System.out.println("page-size"+result.getSize());
//		System.out.println("total-pages"+result.getTotalPages());
//		System.out.println("total-count"+result.getTotalElements());
//		System.out.println("next"+result.nextPageable());
//		
//		List<Board> list = result.getContent();
//		
//		list.forEach(board -> System.out.println(board));
//		
//	}
//	@Test
//	public void testByTitle2() {
//		this.boardRepository.findByTitle("17").forEach(board -> System.out.println(board));
//		
//	}
//	@Test
//	public void testByContent2() {
//		this.boardRepository.findByContent("17").forEach(board -> System.out.println(board));
//	}
//	@Test
//	public void testByWriter2() {
//		this.boardRepository.findByWriter("04").forEach(board -> System.out.println(board));
//	}
//	@Test
//	public void testByTitle() {
//		this.boardRepository.findByTitle2("17").forEach(arr->System.out.println(Arrays.toString(arr)));
//	}
	@Test
	public void testPredicate() {
		String type="t";
		String keyword="17";
		
		BooleanBuilder builder = new BooleanBuilder();
		
		QBoard board = QBoard.board;
		
		if(type.equals("t")) {
			builder.and(board.title.like("%"+keyword+"%"));
		}
		
		//bno >0
		builder.and(board.bno.gt(0L));
		
		Pageable pageable = PageRequest.of(0, 10);
		
		Page<Board> result = this.boardRepository.findAll(builder, pageable);
		
		System.out.println("page-size"+result.getSize());
		System.out.println("total-pages"+result.getTotalPages());
		System.out.println("total-count"+result.getTotalElements());
		System.out.println("next"+result.nextPageable());
		
		List<Board> list = result.getContent();
		
		list.forEach(b->System.out.println(b));
	}
	
}
