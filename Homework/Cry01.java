package Homework;

import java.util.Scanner;

public class Cry01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 입력 하세요");
			
		int num  = sc.nextInt();
		
		Cryprint cc = new Cryprint();
		
		cc.num(num);
		
	}
}
