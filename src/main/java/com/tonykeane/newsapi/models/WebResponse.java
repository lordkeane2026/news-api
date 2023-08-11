package com.tonykeane.newsapi.models;

import com.tonykeane.newsapi.entity.Auditable;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class WebResponse {
    private String status;
    private Integer totalResults;
    private List<ArticleResponse> articles;
}
