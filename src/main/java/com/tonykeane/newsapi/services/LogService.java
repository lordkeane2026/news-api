package com.tonykeane.newsapi.services;

import com.tonykeane.newsapi.entity.ArticleLog;
import com.tonykeane.newsapi.models.ArticleResponse;
import com.tonykeane.newsapi.repository.ArticleLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LogService {

    private final ArticleLogRepository articleLogRepository;

    public List<ArticleLog> getArticleLog() {
        return articleLogRepository.findAll();
    }

}
