package com.example.boardSite_Practice.model.dto;

import com.example.boardSite_Practice.model.entity.Article;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter@Builder@ToString
public class ArticleFormEdit {

    private Long id;    // 고유 ID
    private String title; // 제목 필드
    private String content; // 내용 필드

    // DTO -> 엔티티 화
    public Article toEntity() {
        return new Article(id,title,content);
    }

}
