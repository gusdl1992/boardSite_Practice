package com.example.boardSite_Practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 컨트롤러 어노테이션 선언
public class FirstController {

    @GetMapping("/hi") // get 매핑
    public String niceToMeetYou(Model model){ // Model 객체 받아오기
        // Model 에서 변수를 등록 할 때는 model.addAttribute() 메서드 사용
        // 형식 : model.addAttribute("변수명" , "변수값");
        model.addAttribute("username" , "홍팍");
        return "greetings";
    }

    @GetMapping("bye") // get 매핑
    public String seeYouNext(Model model){
        model.addAttribute("nickname" , "홍길동");
        return "goodbye";
    }

}
