package chapter05;

public class SmartCar {
	// 변수에 private을 선언하면
	// 캡슐화가 되어 해당 Class에서만 사용가능
	// 외부에서는 접근 불가능!
	
	private int speed; // 전역변수 선언, 자동차 속도
	private boolean breakCar;
	
	// 엑셀을 밟았을때 동작하는 메서드
	public void drive() {
		System.out.println(speed);
	}

	public int getSpeed() {
		return speed; // 해당지역에 speed가 선언된게 없으므로
		              // 전역변수 값이다 (60)
	}

	public void setSpeed(int speed) {
		this.speed = speed; // private int speed 를 뜻함
	}

	public boolean isBreakCar() {
		return breakCar;
	}

	public void setBreakCar(boolean breakCar) {
		this.breakCar = breakCar;
	}
	// 화면 상단 Source 에 가면 쉽게 사용할수 있다.
	
}
