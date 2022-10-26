package org.zerock.persistence;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.zerock.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>, QuerydslPredicateExecutor<Board> {
//	public List<Board> findByTitle(String title);
//	public Collection<Board> findByWriter(String writer);
	public Collection<Board> findByWriterContaining(String writer);
	public Collection<Board> findByTitleContainingAndBnoGreaterThan(String keyword, Long num);
	
	public Collection<Board> findByBnoGreaterThanOrderByBnoDesc(Long bno);
	public Page<Board> findByBnoGreaterThan(Long bno, Pageable paging);
	
	@Query("SELECT b FROM Board b WHERE b.title LIKE %?1% AND b.bno > 0 ORDER BY b.bno DESC")
	public List<Board> findByTitle(String title);
	
	@Query("SELECT b FROM Board b WHERE b.content LIKE %:content% AND b.bno >0 ORDER BY b.bno DESC")
	public List<Board> findByContent(@Param("content") String content);
	
	//#entityName은 repository정의할때<엔티티,pk>의 그 엔티티
	@Query("SELECT b FROM #{#entityName} b WHERE b.writer LIKE %?1% AND b.bno > 0 ORDER BY b.bno DESC" )
	public List<Board> findByWriter(String writer);
	
	//원하는 컬럼만 가져오기
	@Query("SELECT b.bno, b.title, b.writer, b.regdate "
			+"FROM Board b WHERE b.title LIKE %?1% AND b.bno >0 ORDER BY b.bno DESC")
	public List<Object[]> findByTitle2(String title);
}
