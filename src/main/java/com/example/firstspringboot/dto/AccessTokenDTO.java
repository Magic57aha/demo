package com.example.firstspringboot.dto;

import lombok.Data;

// Data Transfer Object
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
