package ex;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MembersAllService implements Service{

	public MembersAllService() {
	}

	@Override
	public ArrayList<MemberDto> execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDao dao = MemberDao.getinstance();
		return dao.membersAll(); //데이터베이스랑 직접 연동은 dao에서
	}
	
}
