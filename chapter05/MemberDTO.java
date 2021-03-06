package chapter05;
// DTO : Data Transfer Object
// DAO(CRUD) : 작업에 필요한 데이터를
//			    전송할때 편리하게 전송하기 위한 가방 역할
public class MemberDTO {
			// MenberDTO는 회원관련된 정보를 담을 수 있는 가방 
            // DTO의 정속 4가지 기능!!
			// 1. 가방의 포켓을 정의!(가방에 넣을수 있는 값을 정의)
	        // 2. 가방에 값을 담는 기능(생성자, 오버로딩)
			// 3. 값을 숨기는 기능 (보안)
	        // 4. 가방에 담겨있는 값을 보여주는 기능 
	
	// 1) 가방 포켓을 정의 (7칸)
	String id; 
	String pw;
	String name;
	String email;
	String phone;
	String adress;
	
	// 2) 가방에 담는 기능
	// 	- 디폴트 생성자
	public MemberDTO() {}
	//  - 오버로딩 생성자

	// 회원가입시 필요한 7개의 값을 담는 기능 /
	public MemberDTO(String id, String pw, String name, String email, String phone, String adress) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.adress = adress;
	}
	//회원수정시 필요한 6개의 값을 담는 기능 
	public MemberDTO(String pw, String name, String email, String phone, String adress) {
		super();
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.adress = adress;
	}
	// 회원(이름) 조회시 필요한 1개의 값을 담는 기능
	public MemberDTO(String name) {
		super();
		this.name = name;
	}
	// 로그인시 필요한 2개 값을 담는 기능 
	public MemberDTO(String id, String pw) { // 4. id : admin , pw : 1234가 담겨있다
		super();
		this.id = id; // -> this.변수명 => 전역변수
		this.pw = pw;
		
		// 전역변수 => Class에 속해 있는 변수
		// 지역변수 => Class외에 (블록문) 내에 있는 변수 
		
		
	}
	
	
	}
	
