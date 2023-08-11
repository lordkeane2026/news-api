package com.tonykeane.newsapi.repository;

import com.tonykeane.newsapi.entity.ArticleLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleLogRepository extends JpaRepository<ArticleLog ,Integer> {

}
