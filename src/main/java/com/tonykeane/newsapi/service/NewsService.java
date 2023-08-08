package com.tonykeane.newsapi.service;

import com.tonykeane.newsapi.model.WebResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public interface NewsService {
    public WebResponse getNewsHeadline();

    public WebResponse getNewsEverything(String filter);
}
