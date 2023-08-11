package com.tonykeane.newsapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "article_log")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ArticleLog extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "log_id")
    private Integer logId;

    private String url;
    private String request;
    @Column(columnDefinition = "TEXT")
    private String response;
}
