package org.zerock.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name="tbl_boards")
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bno;
	
	private String title;
	
	private String writer;
	
	private String content;
	
	@CreationTimestamp
	private Timestamp regdate;	//LocalDateTime
	@UpdateTimestamp
	private Timestamp updatedate;	//LocalDateTime
	//QBoard.java가 생성되지 않아 수정 후 저장2

}
