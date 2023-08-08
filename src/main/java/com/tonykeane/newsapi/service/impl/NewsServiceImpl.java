package com.tonykeane.newsapi.service.impl;

import com.tonykeane.newsapi.model.WebResponse;
import com.tonykeane.newsapi.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final RestTemplate restTemplate;
    private final String API_KEY = "59f18436d004476fad9c8fc75d33f07d";

    @Override
    public WebResponse getNewsHeadline() {
        return restTemplate.getForEntity("https://newsapi.org/v2/top-headlines?country=us&apiKey=" + API_KEY, WebResponse.class).getBody();
    }

    @Override
    public WebResponse getNewsEverything(String filter) {
        WebResponse response =  new WebResponse();
        String url = "";
        if(filter.isEmpty()){
            url = "https://newsapi.org/v2/everything?";
        }else{
            url = "https://newsapi.org/v2/everything?q=" + filter;
        }
        response = restTemplate.getForEntity(url + "&apiKey=" + API_KEY, WebResponse.class).getBody();
        return response;
    }
}
