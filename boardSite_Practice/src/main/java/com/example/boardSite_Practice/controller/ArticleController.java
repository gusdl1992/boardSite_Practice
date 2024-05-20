package com.example.boardSite_Practice.controller;

import com.example.boardSite_Practice.model.dto.ArticleForm;
import com.example.boardSite_Practice.model.entity.Article;
import com.example.boardSite_Practice.model.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Slf4j // 로깅 기능을 위한 어노테이션 추가 - 로그 기록
@Controller
public class ArticleController {

    // 스프링 부트가 객체 연결 Ioc , DI
    // IoC : IoC는 제어의 역전 또는 제어의 반전이며 이것은 메소드나 객체의 호출작업이 개발자에 의해 결정되는 것이 아닌 외부(스프링)에서 결정되는 것을 의미한다.
    // DI : DI는 의존성 주입을 의미하며 이는 의존적인 객체를 직접 생성하거나 제어하는 것이 아니라, 특정 객체에 필요한 객체를 외부에서 결정해서 연결시키는 것을 의미한다.
    @Autowired // 리포지토리 추가  - DI : 의존성 주입
    ArticleRepository articleRepository;

    // 글 쓰기 페이지 요청
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    
    // 글 쓰기 기능 메소드
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){ // DTO 로 받기
        // DTO 에 데이터가 잘 담겼는지 확인
        //System.out.println("form.toString() = " + form.toString());

        // 로그 처리
        log.info(form.toString());

        // 1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        // System.out.println("article.toString() = " + article.toString());

        // 로그 처리
        log.info(article.toString());

        // 2. 리파지터리로 엔티티를 DB에 저장
        // article 엔티티를 저장해 saved 객체에 반환
        Article saved = articleRepository.save(article);
        // System.out.println("saved.toString() = " + saved.toString());

        log.info(saved.toString());

        // H2 DB 접속 해서 DB 확인하는 방법
        // 1. http://localhost:8080/h2-console 접속
        // 2. run -> JDBC 검색 후 url="이후 복사 ＊단 user 부분 제외"
        // 3. JDBC URL : 붙여넣고 DB 시작
        
        return "";
    } // m e

    // 개별 조회 요청 받기
    @GetMapping("/articles/{id}") // 데이터 조회 요청 접수
    public String show(@PathVariable Long id , Model model){
        log.info("id = "+ id ); // id를 잘 받았는지 로그 찍기

        // 1. id를 조회해 데이터 가져오기
        // 특정 엔티티의 id 값 기준으로 데이터를 찾으면 Optional 타입으로 반환한다. (자바 8 부터 사용가능)
        // Optional<Article> articleEntity = articleRepository.findById(id);

        // 방법 2
        // orElse(null) => ID값으로 데이터를 찾을때 ID값이 없으면 null 을 반환 하라는 뜻
        Article articleEntity = articleRepository.findById(id).orElse(null);

        // 2. 모델에 데이터 등록하기
        model.addAttribute("article" , articleEntity);

        // 3.뷰 페이지 반환 하기
        return "articles/show";
    }

    // 여러 데이터 조회
    @GetMapping("articles")
    public String index(Model model){
        
        // 1. 모든 데이터 가져오기
        List<Article> articleList = articleRepository.findAll();
        
        // 2. 모델에 데이터 등록하기
        model.addAttribute("articleList" , articleList);
        // 3. 뷰 페이지 설정하기
        return "articles/index";
    }




}
