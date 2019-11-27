package shop;

public class Member {

	// 회원가입
	
	public String memInert(String id, String pw, String name) { // 2. 1번이 보낸걸 받음
		System.out.println(id + "," + pw + "," + name+"로 회원가입 성공");
		String status = "success";
		return status;
		// success 를 status에 담아 돌려줌 
		
		
		
	}
	
	// 회원수정
	public void memUpdate() {
		
	}
	// 회원탈퇴
	public void memDelete(String id, String pw, String name) {
		
	}
}
