package com.example.firstspringboot.model;

import lombok.Data;

/**
 * @author code羊
 * @date 2024/1/29 20 55
 * discription
 */
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
}
