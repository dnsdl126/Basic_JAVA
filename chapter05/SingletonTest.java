package chapter05;


// 싱글톤 패턴
// : 객체 생성은 1회만 하고 생성된 인스턴스를 빌렷서 사용하는 방법
public class SingletonTest {
	// 2. 객체생성 1회 진행 => st 인스턴스 생성
	// 앞으로 객체생성을 하지 않고 st 인스턴스를 빌려서 사용하게 만듬
	 
	private static SingletonTest instance = new SingletonTest();
	String name = "";
	
	
	int Score;
	
	// 1. 생성자를 private으로 선언하여 외부에서 객체 생성 불가!
	private SingletonTest() {}
	
	//3.생성된 instance를 return으로 빌려서 사용할수 있게
	// static 메서드 생성
	public static SingletonTest getInstance() {
		if(instance == null) {
			instance = new SingletonTest();
			
		}
		return instance;
	}

}
