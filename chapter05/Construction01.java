package chapter05;

public class Construction01 {
	// default 생성자
	// : Class에 생성자가 존재하지 않으면
	//  JAVA에서 Default 생성자를 생성
	// Default 생성자는 객체생성만 함 
	// 1. 매개변수에 갯수가 다르면 됨
	// 2. 매개변수에 갯수가 같은면 타입이 다르면 됨
	// 3. 매개변수에 순서가 다르면 됨
	public Construction01() {} // Defalt
	public Construction01(String a) {}
	public Construction01(int a) {}
	public Construction01(int a, int b, String c) {}
	public Construction01(int a, int c, String b) {}
}
