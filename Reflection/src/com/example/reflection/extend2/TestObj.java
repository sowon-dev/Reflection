package com.example.reflection.extend2;

public class TestObj extends ParentObj {
	// static 블록은 클래스가 메모리에 올라간 후 static 블록도 올라감
	static {
		System.out.println("테스트obj static 블록");
	}
	
	public static void main(String[] args) {
		// static블록 먼저 실행 된 후 doA() 메소드 실행됨
		// static은 클래스변수 즉 공유변수이기때문에 한번 실행된다.
		/* 실행순서
		 * 1. static변수
		 * 2. xxxxxx 프린트아웃
		 * 3. 기본생성자
		 */
		System.out.println("XXXXXXXXXXXXXXX");
		TestObj obj1 = new TestObj();
		TestObj obj2 = new TestObj();
	}
	
	public void doA(){
		System.out.println("테스트obj doA 호출");		
	}

	// 생성자가 있는 경우
	public TestObj() {
		super();
		System.out.println("테스트obj 빈 생성자 호출");		
	}
	
	// 사용자가 정의한 생성자
	public TestObj(String str) {
		System.out.println("테스트obj 문자열 생성자 호출"+str);		
	}
	
}
