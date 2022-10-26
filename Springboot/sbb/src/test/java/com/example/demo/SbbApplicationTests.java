package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.answer.Answer;
import com.example.demo.answer.AnswerRepository;
import com.example.demo.question.Question;
import com.example.demo.question.QuestionRepository;
import com.example.demo.question.QuestionService;

@SpringBootTest
class SbbApplicationTests {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private QuestionService questionService;
	
//데이터 저장	
//	@Test 
//	void testJpa() {
//		Question q1 = new Question();
//		q1.setSubject("sbb가 무엇인가?");
//		q1.setContent("sbb에 대해 알고 싶다.");
//		q1.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q1); //첫번째 질문 저장
//		
//		Question q2 = new Question();
//		q2.setSubject("스프링부트 모델 질문?");
//		q2.setContent("id는 자동 생성?");
//		q2.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q2);
//	}
/**-----------------------------**/	
//데이터 조회(findAll)	
//	@Test
//	void testJpa() {
//		List<Question> all = this.questionRepository.findAll();
//		assertEquals(2, all.size());
//		
//		Question q = all.get(0);
//		assertEquals("sbb가 무엇인가?", q.getSubject());
//	}
/**-----------------------------**/
//데이터 조회(findbyid)
//	@Test
//	void testJpa() {
//		Optional<Question> oq = this.questionRepository.findById(1);
//		if(oq.isPresent()) {
//			Question q = oq.get();
//			assertEquals("sbb가 무엇인가?", q.getSubject());
//		}
//		
//	}
/**-----------------------------**/
//데이터 조회(findBySubject)
//	@Test
//	void testJpa() {
//		Question q = this.questionRepository.findBySubject("sbb가 무엇인가?");
//		assertEyquals(1, q.getId());
//	}
/**-----------------------------**/
//데이터 조회(findBySubjectAndContent)
//	@Test
//	void testJpa() {
//		Question q = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가?", "sbb에 대해 알고 싶다.");
//		assertEquals(1, q.getId());
//	}
//문자열 포함 데이터 조회(findBySubjectLike)
//	@Test
//	void testJpa() {
//		List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
//		Question q = qList.get(0);
//		assertEquals("sbb가 무엇인가?", q.getSubject());
//	}
	
/**--------------------------------------------------**/
//데이터수정
//	@Test
//	void testJpa() {
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		q.setSubject("수정된 제목");
//		this.questionRepository.save(q);
//	}
/**--------------------------------------------------**/
//데이터삭제
//	@Test
//	void testJpa() {
//		assertEquals(2, this.questionRepository.count());
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		this.questionRepository.delete(q);
//		assertEquals(1, this.questionRepository.count());
//	}
	
/**--------------------------------------------------**/
	
//답변 작성
//	@Test
//	void testJpa() {
//		Optional<Question> oq = this.questionRepository.findById(2);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		
//		Answer a = new Answer();
//		a.setContent("네 자동으로 생성됩니다.");
//		a.setQuestion(q);
//		a.setCreateDate(LocalDateTime.now());
//		this.answerRepository.save(a);
//		
//	}
/**------------------------------------------------**/
//답변 조회
//	@Test
//	void testJpa() {
//		Optional<Answer> oa =  this.answerRepository.findById(1);
//		assertTrue(oa.isPresent());
//		Answer a = oa.get();
//		assertEquals(2, a.getQuestion().getId());
//	}
/**-----------------------------------------------**/
//질문과 답변 서로 찾기
//	@Transactional
//	@Test
//	void testJpa() {
//		Optional<Question> oq = this.questionRepository.findById(2);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		
//		List<Answer> answerList = q.getAnswerList();
//		
//		assertEquals(1, answerList.size());
//		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
//	}
	
/**-------------------------------**/
//테스트 데이터 삽입
	@Test
	void testJpa() {
		for(int i=1;i<=300;i++) {
			String subject = String.format("테스트 데이터입니다:[%03d]", i);
			String content = "내용 없음";
			this.questionService.create(subject, content, null);
		}
	}
}
