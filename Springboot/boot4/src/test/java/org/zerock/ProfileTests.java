package org.zerock;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.domain.Member;
import org.zerock.domain.Profile;
import org.zerock.persistence.MemberRepository;
import org.zerock.persistence.ProfileRepository;

import lombok.extern.java.Log;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Log
@Commit
public class ProfileTests {
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	ProfileRepository profileRepository;
	
//	@Test
//	public void testInsertMembers() {
//		IntStream.range(1,101).forEach(i ->{
//			Member member = new Member();
//			member.setUid("user"+i);
//			member.setUpw("pw"+i);
//			member.setUname("사용자"+i);
//			
//			this.memberRepository.save(member);
//		});
//	}
//	@Test
//	public void testInsertProfile() {
//		
//		Member member = new Member();
//		member.setUid("user1");
//		
//		for(int i=1;i<5;i++) {
//			Profile profile1 = new Profile();
//			profile1.setFname("face"+i+".jpg");
//			if(i==1) {
//				profile1.setCurrent(true);
//			}
//			profile1.setMember(member);
//			
//			this.profileRepository.save(profile1);
//		}
//	}
//	@Test
//	public void testFetchJoin1() {
//		List<Object[]> result = this.memberRepository.getMemberWithProfileCount("user1");
//		
//		result.forEach(arr -> System.out.println(Arrays.toString(arr)));
//	}
}
