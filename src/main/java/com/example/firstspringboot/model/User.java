package com.example.firstspringboot.model;

import lombok.Data;

/**
 * @author code羊
 * @date 2024/1/20 15 45
 * discription
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String token;
    private String accountId;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;}
