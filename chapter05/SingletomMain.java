package chapter05;

public class SingletomMain {

	public static void main(String[] args) {
		
		// SingletonTest st1 = new SingletonTest(); // 외부에서 못쓰게 만들기 접근 제한자를 private으로 변경
		// SingletonTest st2 = new SingletonTest();
		SingletonTest st1 = SingletonTest.getInstance(); // 객체 생성을 안했으나 한것 처럼 빌려쓰는 것
		SingletonTest st2 = SingletonTest.getInstance();
		
		System.out.println(st1==st2);
	}
}
