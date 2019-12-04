package chapter08;

public class DmbCellPhoneMain {
	
	public static void main (String [] args) {
		// CellPhone 클래스를 상속받고 있는
		// 자식 DmbCellPhone 클래스를 객체 생성
		
		DmbCellPhone dmb = new DmbCellPhone("어머나폰", "화이트", 5);
		//자식 기능이 담기 자식 클래스
		
		// dmb.이라는 클래스에서 model 가지고 와라 
		// Dmbcellphon에는 model은 없지만
		//cellPhone에서 상속 받고 있는 상태여서 에러가 생기지 않음
		
		
		System.out.println("모델:" + dmb.model); 
		System.out.println("색상" + dmb.color);
		//자기 자신의 필드
		System.out.println("채널:" + dmb.channel);
		
		
		//Cellphone 부모클래스 로부터 상속받은 메서드
		dmb.powerOn();
		dmb.bell();
		dmb.sendVoice("여보세요");
		dmb.receiveVoice("안녕하세요. 체리에요");
		dmb.sendVoice("강아지가 말도 하네요");
		dmb.hang();
		
		// 자기자신의 메서드
		dmb.turnOnDmb();
		dmb.ChangeChannelDmb(12);
		dmb.turnOffDmb();
		
	}

}
