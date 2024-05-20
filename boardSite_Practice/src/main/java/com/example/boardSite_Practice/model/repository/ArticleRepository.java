package com.example.boardSite_Practice.model.repository;

import com.example.boardSite_Practice.model.entity.Article;
// CrudRepository 패키지 임포트
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // 리포지토리 어노테이션 추가
public interface ArticleRepository extends CrudRepository<Article , Long> {
    // JPA 에서 제공하는 CrudRepository 인터페이스 상속 - 제네릭 < 엔티티 클래스 타입 , 대표값 타입 >
    // extends JpaRepository<엔티티,대표값> 으로도 사용 가능

    // 오버라이딩 으로 메서드 재정의
    @Override
    List<Article> findAll();
}
