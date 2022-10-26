package org.zerock;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.domain.FreeBoard;
import org.zerock.domain.FreeBoardReply;
import org.zerock.persistence.FreeBoardReplyRepository;
import org.zerock.persistence.FreeBoardRepository;

import lombok.extern.java.Log;

@ExtendWith(SpringExtension.class)
@Log
@SpringBootTest
@Commit
public class FreeBoardTests {
	
	@Autowired
	FreeBoardRepository boardRepository;
	
	@Autowired
	FreeBoardReplyRepository boardReplyRepository;
	
//	@Test
//	public void insertDummy() {
//		
//		IntStream.range(1, 200).forEach(i -> {
//			FreeBoard board = new FreeBoard();
//			board.setTitle("Free Board ... "+i);
//			board.setContent("Free Content .... "+i);
//			board.setWriter("user"+i%10);
//			boardRepository.save(board);
//		});
//	}
//	@Transactional
//	@Test
//	public void insertReply2Way() {
//		
//		Optional<FreeBoard> result = boardRepository.findById(199L);
//		
//		result.ifPresent(board ->{
//			List<FreeBoardReply> replies = board.getReplies();
//			FreeBoardReply reply = new FreeBoardReply();
//			reply.setReply("REPLY...........");
//			reply.setReplyer("replyer00");
//			reply.setBoard(board);
//			
//			replies.add(reply);
//			
//			board.setReplies(replies);
//			
//			boardRepository.save(board);
//		});
//	}
//	@Test
//	public void insertReply1Way() {
//		
//		FreeBoard board = new FreeBoard();
//		board.setBno(199L);
//		
//		FreeBoardReply reply = new FreeBoardReply();
//		reply.setReply("reply........");
//		reply.setReplyer("replyer00");
//		reply.setBoard(board);
//		boardReplyRepository.save(reply);
//	}
	@Test
	public void testList1() {
		Pageable page = PageRequest.of(0, 10, Sort.Direction.DESC, "bno");
		this.boardRepository.findByBnoGreaterThan(0L, page).forEach(board ->{
			log.info(board.getBno()+": "+board.getTitle()); 
			//board.getReplies().size()를 포함하고 싶다면 @Query를 써야 됨.
		});
	}
}
