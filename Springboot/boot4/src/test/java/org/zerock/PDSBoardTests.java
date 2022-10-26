package org.zerock;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.domain.PDSBoard;
import org.zerock.domain.PDSFile;
import org.zerock.persistence.PDSBoardRepository;

import lombok.extern.java.Log;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Log
@Commit //아래의 Transactional 기본값이 rollback임
public class PDSBoardTests {
	
	@Autowired
	PDSBoardRepository pdsBoardRepository;
	
//	@Test
//	public void testInsertPDS() {
//		PDSBoard pds = new PDSBoard();
//		pds.setPname("DOCUMENT 1-2");
//		
//		PDSFile file1 = new PDSFile();
//		file1.setPdsfile("file1.doc");
//		
//		PDSFile file2 = new PDSFile();
//		file2.setPdsfile("file2.doc");
//		List<PDSFile> list = new ArrayList<>();
//		list.add(file1);
//		list.add(file2);
//		pds.setFiles(list);
//		
//		log.info("try to save pds");
//		
//		this.pdsBoardRepository.save(pds);
//	}
	@Transactional //update,delete쓸때 필요
	@Test
	public void testUpdateFileName1() {
		int count = this.pdsBoardRepository.updatePDSFile(1L, "updatedFile1.doc");
		log.info("update count: "+count);
	}
//	@Transactional
//	@Test
//	public void testUpdateFileName2() {
//		Optional<PDSBoard> result = this.pdsBoardRepository.findById(2L);
//		result.ifPresent(pds -> {
//			log.info("update시도");
//			PDSFile target = new PDSFile();
//			target.setFno(2L);
//			target.setPdsfile("updatedFile2.doc");
//			int idx = pds.getFiles().indexOf(target);
//			if(idx>-1) {
//				List<PDSFile> list = pds.getFiles();
//				list.remove(idx);
//				list.add(target);
//				pds.setFiles(list);
//			}
//			this.pdsBoardRepository.save(pds);
//		});
//	}
//	@Test
//	public void insertDummies() {
//		
//		List<PDSBoard> list = new ArrayList<>();
//		IntStream.range(1, 100).forEach(i -> {
//			
//			PDSBoard pds = new PDSBoard();
//			pds.setPname("자료 "+i);
//			PDSFile file1 = new PDSFile();
//			file1.setPdsfile("file1.doc");
//
//			PDSFile file2 = new PDSFile();
//			file2.setPdsfile("file2.doc");
//			List<PDSFile> templist = new ArrayList<>();
//			templist.add(file1);
//			templist.add(file2);
//			pds.setFiles(templist);
//			log.info("try to dave pds");
//			
//			list.add(pds);
//		});
//		this.pdsBoardRepository.saveAll(list);
//	}
}
