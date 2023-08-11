package com.tonykeane.newsapi.services.impl;

import com.tonykeane.newsapi.entity.ArticleLog;
import com.tonykeane.newsapi.models.WebResponse;
import com.tonykeane.newsapi.repository.ArticleLogRepository;
import com.tonykeane.newsapi.services.NewsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@RequiredArgsConstructor
@Slf4j
public class NewsServiceImpl implements NewsService {
    private static Logger LOGGER = LoggerFactory.getLogger(NewsServiceImpl.class);

    private final RestTemplate restTemplate;
    private final String API_KEY = "59f18436d004476fad9c8fc75d33f07d";

    private final ArticleLogRepository articleLogRepository;
    private static String URL = "https://newsapi.org/v2/top-headlines?country=id";

    @Override
    public WebResponse getNewsHeadline(String category, String filter) {
        String urlFilter = "";
        String urlFinal = "";
        if (!category.isEmpty()) {
            urlFilter += "&category=" + category;
        }

        if (!filter.isEmpty()) {
            urlFilter += "&q=" + filter;
        }
//        LOGGER.info("Request News category : " + category + " filter : " + filter);
        urlFinal = URL + urlFilter + "&apiKey=" + API_KEY;

        WebResponse response = restTemplate.getForEntity( urlFinal, WebResponse.class).getBody();

        ArticleLog log = ArticleLog.builder()
                .url(urlFinal)
                .request(urlFilter)
                .response(response.toString())
                .build();

        articleLogRepository.save(log);
//        LOGGER.info("Response News : " + response);

        return response;
    }

}
