package chapter05;

public class Staticmain {
	public static void main(String[] args) {
		
		// Class가 갖더라도 객체 생성을 하게 되면
		// 결과물은 다른것으로 인식!
		// t1, t2는 StaticTest로 만들 결과물 이지만
		// 서로 다름, 각각의 인스턴스!!
		
		StaticTest t1 = new StaticTest();
		t1.name = "사과";
		t1.point = 5000; // static 변수는 공용이기 때문에  t2.join()의 값도 바뀐다
		//t1.point = 5000을 넣고 t2에는 값을 넣지 않았는데
		//5000으로 바뀌는 이유는 point변수는 static으로 선언되어
		//해당 class로 객체 생성된 모든 인스턴스에서 공용으로 사용하는
		//변수임! 반드시 클래스명.point()로 사용할것을 권장한다
		// t1.point = 5000; // 비권장 
		StaticTest t2 = new StaticTest();
		t2.name = "오렌지";
				
		t1.join();
		System.out.println("==================");
		t2.join();
		System.out.println("==================");
		t1.search(); // 비권장
		StaticTest.search(); // 권장
	}

}
