package com.tonykeane.newsapi.controller;

import com.tonykeane.newsapi.model.WebResponse;
import com.tonykeane.newsapi.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class NewsController {

    private final NewsService newsService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/headline")
    public WebResponse getNewsHeadline() {
        return newsService.getNewsHeadline();
    }

    @GetMapping("/everything")
    public WebResponse getNewsEverything(@RequestParam(name = "q",required = false) String filter) {
        return newsService.getNewsEverything(filter);
    }
}
