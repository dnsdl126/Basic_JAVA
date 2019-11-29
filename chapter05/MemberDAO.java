package chapter05;

public class MemberDAO {

	// 데이터 베이스
	// 아래값은 전역 변수

	String id = "admin";
	String pw = "1234";

	// 로그인시 회원 유무 판별기능
	int result = 0;

	public int logingCheck(MemberDTO mDto) {

		{
			if (id.equals(mDto.id) && pw.equals(mDto.pw)) {//equls : 같니?
				result = 1;

			}
			return result;// 돌아갈때 값을 가지고 가라
		}

	}
}
