package com.softserve.edu;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

class Rst<T> {
	private T local;

	// @SuppressWarnings("unchecked")
	public void info() throws Exception {
//		Class<T> clazz = (Class<T>) ((( ParameterizedType) this.getClass()
//				.getGenericSuperclass()).getActualTypeArguments()[0]);
//		System.out.println("clazz Name: " + clazz.getName());
//		for (TypeVariable typeParam : Rst.class.getTypeParameters()) {
//			System.out.println(typeParam.getName());
//			for (Type bound : typeParam.getBounds()) {
//				System.out.println(bound);
//			}
//		}
		Type type = this.getClass().getGenericSuperclass();
		System.out.println("type = " + ((T)type).getClass().getName());
		//String className = ((ParameterizedType) type).getActualTypeArguments()[0].getTypeName();
        //Class<?> clazz = Class.forName(className);
        //System.out.println("clazz Name: " + clazz.getName());
		//System.out.println("clazz Name: " + local.getClass().getName());
	}
}

public class ApplClazz {

	public static void main(String[] args) throws Exception {
		Rst<String> res = new Rst<>();
		res.info();
	}
}
