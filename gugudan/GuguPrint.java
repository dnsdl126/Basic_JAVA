package gugudan;

public class GuguPrint {
	
	public void gugudan(int dansu) {
		 // dansu가 input 값
		int result; // 변수 선언, 초기화 x 
		System.out.println("구구단 " + dansu + "단 출력");// 먼저 출력 for 문안에 있으면 계속 반복 되기 때문
		for(int i = 1 ; i <=9 ; i ++) {
			 result = dansu *i;  
			
			System.out.println(dansu + "X" + i + "=" + result);
			
			
		}
		
	}

	
}
