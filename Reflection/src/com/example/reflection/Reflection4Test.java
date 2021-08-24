package com.example.reflection;

import java.lang.reflect.Field;

public class Reflection4Test {
	public static void main(String[] args) throws Exception {
		Class clz = Class.forName("com.example.reflection.private4.MemberVO");
		Object obj = clz.newInstance();
		System.out.println(obj);
		
		// getter, setter없으면서 private 접근제한자에 접근할 수 있을까? -> getDeclaredField()로 가능
		Field idField = clz.getDeclaredField("id");
		idField.setAccessible(true); // private 접근제한자를 동적으로 잠깐 풀수있음
		idField.set(obj, "user001");
		
		System.out.println(obj);
	}
}
