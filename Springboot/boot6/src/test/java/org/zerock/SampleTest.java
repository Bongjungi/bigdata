package org.zerock;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.domain.WebBoard;
import org.zerock.persistence.WebBoardRepository;
import org.zerock.vo.PageMaker;
import org.zerock.vo.PageVO;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SampleTest {
	@Autowired
	WebBoardRepository webBoardRepository;
	
	@Test
	public void test(){
		
		
		PageVO vo = new PageVO();
		Pageable page = vo.makePageable(0, "bno");
		Page<WebBoard> result = this.webBoardRepository.findAll(this.webBoardRepository.makePredicate(null, null), page);
		PageMaker pm = new PageMaker(result); 
		System.out.println(pm.getCurrentpage().getPageSize());
	}
}
