package com.example.memo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MemoApplication {

	// 프레임워크 개발
	public static void main(String[] args) {
		SpringApplication.run(MemoApplication.class, args);
	}
	// 전체 동작 과정을 프레임워크에게 넘기면 프레임워크는 사전에 만들어진 로직에 따라 동작한다.
	// 개발자는 프레임워크의 부분 부분을 개발하게 된다.
}
