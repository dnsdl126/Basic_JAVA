package chapter05;

public class AllLocal {
	
	static int num = 5; // 전역변수( 클래스(중괄호) 안에 포함된 모든곳에서 사용 가능 )
	
	public static void main (String [] args) {
		System.out.println(num); // 5
		int num = 10; // 지역변수 자기가 소속된 곳 안에서만 사용할수 있다
		System.out.println(num);// 전역,지역 2가지가 있을경우 지역을 우선으로 한다.
	}// 전역변수 지역변수는 같은 변수명을 쓸수있다. -> 지역변수 를 우선으로 하기 때문에
}
