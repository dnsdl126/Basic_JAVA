package problem;

public class Totalsum {
	// 1~100까지 더해서 출력하시오
	// 시작값 : 1
	// 종료값: 100
	// 덧셈을 계속 누적 : total
	public static void main(String[] args) {
		
		int total = 0; // 덧셈결과 누적 
		
		for(int i = 1; i <= 100; i++) {
			
			//1 + total(0) = total
			//2 + total(1) = total
			//3 + total(2) = total
			
			total = total + i;
		}
		System.out.print("1~100까지 총합은" + total);
		}
}
