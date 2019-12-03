package problem;

public class Parking {
	int[] space = new int[5]; // 주차공간 (5대)

	int carCnt ; // 현재 주차된 차량수

	public Parking(){
		
	}
	// 1. 주차타워 현황

	public void viewParking() {
		
		System.out.println("==================");
			for ( int j = 0; j <space.length;j++) {
				System.out.println("||" + (j+1) + "층:" + space[j] + "||");
			}
			System.out.println("=======================");
	
	}
	
	//2.주차 타워 입고
	public void inParking(int car) {
		// 현재 주차타워에 빈공간이 없는 경우
		if (carCnt == space.length) {
			System.out.println("■■■■■■■■■■■■■■■■■■■■");
			System.out.println("■공간이 부족합니다. 2번타워를 이용해주세요");
			
			return; // void는 return을 안쓰는 것이 아니라 return값을 전달하지 않겠다.->메서드 실행 종료
		}
		
		// 주차공간을 순회하면서 비어있는 입고 공간을 찾음
		for(int i = 0 ; i <= space.length; i++) { //space.length 배열의 길이
			// 비어있는 공간을 찾음(값이 0이면 비어있음)
			
			if(space[i]==car) {
				System.out.println("주차되어 있는 번호 입니다."); return;
			}
			
			else if(space[i]==0) {
				space[i] = car;
				
				carCnt +=1;
				// carCnt = carCnt +1;(차량입고)
				
				System.out.println("▤" + (i+1) + "층" + car + "입고완료!");
			    viewParking();
				
				break; // 입고 완료되면 다시 반복 안하도록 
				
				
			}
		
		}
	}
	
	//3.주차 타워 출고
	public void outParking(int car) {
		if(carCnt ==0) {
			System.out.println("주차중인 차량이 없습니다. 확인해주세요 ");
			return;
		}
		
		for(int i = 0 ; i < space.length; i++) {
			// 주차된 차량번호와 내가 입력한 차량번호가 같을때
		if(space[i] == car) {
			
			space[i] = 0; // 출고 => 공간0
			
			carCnt -=1; // 현재 주차차량 -1
			
			System.out.println("※" + (i+1)+"층:" + car + "출고완료 되었습니다.");
			viewParking();
			
		
		
			return;
			
			
		}
		//입력한 차량번호가 주차 타워에 없음
		System.out.println("■ 없는차량 번호 입니다." );
		
		
	}
}
}