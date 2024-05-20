package com.example.boardSite_Practice.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter@ToString@Builder
public class Article {
    
    @Id // 엔티티의 대표값 
    @GeneratedValue // 자동 생성 기능 추가 ( 숫자가 자동으로 매겨짐 )
    private Long id;
    @Column // title 필드 선언. DB 테이블의 title 열과 연결
    private String title;
    @Column // content 필드 선언. DB 테이블의 content 열과 연결
    private String content;
    
}
