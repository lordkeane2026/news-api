package com.tonykeane.newsapi.controllers;

import com.tonykeane.newsapi.entity.ArticleLog;
import com.tonykeane.newsapi.services.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequiredArgsConstructor
public class AdminController {
    private final LogService logService;

    @GetMapping("/")
    public String helloAdminController(){
        return "Admin Access Level";
    }

    @GetMapping("/get-log")
    @ResponseBody
    public ResponseEntity<List<ArticleLog>> getArticleLogList(){
        return ResponseEntity.ok(logService.getArticleLog());
    }
}
