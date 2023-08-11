package com.tonykeane.newsapi.controllers;

import com.tonykeane.newsapi.models.WebResponse;
import com.tonykeane.newsapi.services.NewsService;
import com.tonykeane.newsapi.services.impl.NewsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class DashboardController {
    private static Logger LOGGER = LoggerFactory.getLogger(DashboardController.class);

    private final NewsService newsService;

    @GetMapping("/headline")
    public WebResponse getNewsHeadline(@RequestParam(name = "category", required = false, defaultValue = "") String category
            , @RequestParam(name = "q", required = false, defaultValue = "") String filter) {
        return newsService.getNewsHeadline(category,filter);
    }

}
