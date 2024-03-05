package com.example.firstspringboot.dto;

import com.example.firstspringboot.model.User;
import lombok.Data;

/**
 * @author code羊
 * @date 2024/1/30 22 46
 * discription
 */
@Data
public class QuestionDTO {
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
    private User user;
}
