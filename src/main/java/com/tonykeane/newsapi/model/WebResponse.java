package com.tonykeane.newsapi.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebResponse {
    private String status;
    private Integer totalResults;
    private List<ArticleResponse> articles;
}
