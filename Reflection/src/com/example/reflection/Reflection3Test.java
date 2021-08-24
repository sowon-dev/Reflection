package com.example.reflection;

import java.lang.reflect.Method;

public class Reflection3Test {
	public static void main(String[] args) throws Exception {
		//키보드로 입력받았다고 가정 -> 즉 동적으로 로딩가능
		String className = "com.example.reflection.calculator3.Calculator"; //키보드로 입력받았다고 가정
		String methodName = "doB"; //키보드로 입력받았다고 가정
		
		Class clz = Class.forName(className);
		Object obj = clz.newInstance();

//		Method[] methods = clz.getDeclaredMethods(); //
		Method[] methods = clz.getMethods(); //숨어있던 java.lang.Object에서 상속받은 메서드까지 다 출력
		for(Method m : methods) {
			if(methodName.equals(m.getName())) {
				System.out.println("find: "+m);
				m.invoke(obj, null);
			}
		}
	}
}
