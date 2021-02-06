package com.huiyu.ChatBox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@SpringBootApplication
@RestController
public class ChatBoxApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatBoxApplication.class, args);
	}

//	@RequestMapping("/user")
//	public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
//		return Collections.singletonMap("name", principal.getAttribute("login"));
//	}

}
