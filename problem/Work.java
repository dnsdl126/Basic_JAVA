package problem;

public class Work {
	// 1~100까지 짝수, 홀수 각각 더해서 출력 하세요
	// 시작값 : 1
	// 종료값: 100
	// 짝수 누적갑 : even
	// 홀수 누적값 : odd
		 
	public static void main(String[] args) {
		
		int even = 0;
		int odd = 0;
		
		for(int i =1; i <=100 ; i++) {
			if( i % 2 == 0 ) {//짝수
				even = even + i;
			}else {//홀수
				odd =odd +  i;
			}
			
		}
		System.out.println("1~100까지 짝수 총합" + even);
		System.out.println("1~100까지 홀수 총합" + odd);
			
		 

		
			
		

}
}