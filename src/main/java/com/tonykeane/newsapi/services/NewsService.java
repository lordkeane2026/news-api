package com.tonykeane.newsapi.services;

import com.tonykeane.newsapi.models.WebResponse;
import org.springframework.stereotype.Service;

@Service
public interface NewsService {
    WebResponse getNewsHeadline(String category, String filter);

}
