package org.zerock;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.domain.Board;
import org.zerock.persistence.BoardRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BoardRepositoryTests {
	
	@Autowired
	private BoardRepository boardRepo;
	
//	@Test
//	public void inspect() {
//		//실제 객체의 클래스 이름
//		Class<?> clz = boardRepo.getClass();
//		System.out.println("1");
//		System.out.println(clz.getName());
//		
//		//클래스가 구현하고 있는 인터페이스 목록
//		Class<?>[] interfaces = clz.getInterfaces();
//		System.out.println("2");
//		Stream.of(interfaces).forEach(inter -> System.out.println(inter.getName()));
//		
//		//클래스의 부모 클래스
//		Class<?> superClasses = clz.getSuperclass();
//		System.out.println("3");
//		System.out.println(superClasses.getName());
//	}
//	@Test
//	public void testinsert() {
//		Board board = new Board();
//		board.setTitle("게시물의 제목");
//		board.setContent("게시물 내용 넣기");
//		board.setWriter("user00");
//		
//		boardRepo.save(board);
//	}
//	@Test
//	public void testRead() {
//		Optional<Board> ob = boardRepo.findById(1L);
//		if(ob.isPresent()) {
//			Board b = ob.get();
//			System.out.println(b);
//		}
//	}
//	@Test
//	public void testUpdate() {
//		System.out.println("Read first");
//		Optional<Board> ob = this.boardRepo.findById(1L);
//		assertTrue(ob.isPresent());
//		Board board = ob.get();
//		System.out.println("Update Title");
//		board.setTitle("수정된 제목입니다.");
//		System.out.println("Call Save()");
//		this.boardRepo.save(board);
//	}
	@Test
	public void testDelete() {
		System.out.println("DELETE Entity");
		this.boardRepo.deleteById(1L);
	}
}
