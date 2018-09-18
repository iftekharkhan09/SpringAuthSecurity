package com.design.pattern.singleton;

public class ClientApp {
	public static void main(String[] args) {
		Singleton singleton = Singleton.myInstance;
		singleton.showData();
	}
}
