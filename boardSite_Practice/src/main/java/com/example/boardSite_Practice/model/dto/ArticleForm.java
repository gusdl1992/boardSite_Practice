package com.example.boardSite_Practice.model.dto;

import com.example.boardSite_Practice.model.entity.Article;
import lombok.*;

@AllArgsConstructor //  올 생성자
@NoArgsConstructor // 기본 생성자
@ToString // 투스트링
@Getter@Setter@Builder // 겟터 셋터 빌더
public class ArticleForm {
    
    private String title; // 제목 필드
    private String content; // 내용 필드

    
    // DTO -> 엔티티 화
    public Article toEntity() {
        return new Article(null,title,content);
    }
}
