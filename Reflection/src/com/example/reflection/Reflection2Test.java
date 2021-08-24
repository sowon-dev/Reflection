package com.example.reflection;

import java.lang.reflect.Constructor;
import java.util.Scanner;

/*
 * Reflection기술
 * Java에서 실행되는 클래스나 객체를 컴파일 시점에 결정하는 것이 아닌, runtime에 동적으로 결정하고 실행할 수 있는 기술
 * */
public class Reflection2Test {
	// 예외처리 생략-
	public static void main(String[] args) throws Exception {
		
		// 메모리에 클래스 로딩하기 -> 동적로딩 vs 정적로딩(import로 거는 방식: import된다고 로딩되는거 아니고 객체만들때 생김)
		Scanner sc = new Scanner(System.in);
		System.out.println("로딩하고 싶은 클래스 이름은? ");
		String className = sc.nextLine();
		Class clz = Class.forName(className);
		System.out.println("@ 메모리상에 클래스가 올라감: "+clz);
		Thread.sleep(3000);
		Class clz2 = Class.forName(className);
		
//		String className = "com.example.reflection.TestObj";
		
		// return 데이터타입이 Class임
		Class clz3 = Class.forName(className);
		System.out.println("@ 메모리상에 클래스가 올라감: "+clz3);
		// 생성자가 없거나 @NoArgsConstructor생성자만 있는 경우 -> Class에서 바로 객체 생성 가능
		// TestObj 기본 생성자가 없이 사용자가 정의한 생성자만 있는 경우 Exception in thread "main" java.lang.InstantiationException 발생
//		Object obj = clz.newInstance();
//		System.out.println(obj);

		// 위 상황에서 해결방법은 어떤게 있을까?
		// 기본생성자가 없이 사용자정의생성자만 있는 경우 -> Constructor 사용
		Constructor con = clz.getDeclaredConstructor(String.class);
		Object obj2 = con.newInstance("");
		System.out.println(obj2);
		
		// 부모클래스 생성자로 클래스 만들기
//		Constructor con2 = clz.getConstructor(null);
//		Object obj3 = con.newInstance(con2);
//		System.out.println(obj3);
		
	}
}
