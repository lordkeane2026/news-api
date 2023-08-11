package com.tonykeane.newsapi.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegistrationRequest {
    private String username;
    private String password;
}
