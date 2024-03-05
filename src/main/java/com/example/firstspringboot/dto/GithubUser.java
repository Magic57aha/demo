package com.example.firstspringboot.dto;

import lombok.Data;

@Data
public class GithubUser {
    private String login;
    private long id;
    private String bio;
    private String avatarUrl;
}
