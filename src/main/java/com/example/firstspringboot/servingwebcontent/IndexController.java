package com.example.firstspringboot.servingwebcontent;

import com.example.firstspringboot.Service.QuestionService;
import com.example.firstspringboot.dto.PaginationDTO;
import com.example.firstspringboot.dto.QuestionDTO;
import com.example.firstspringboot.mapper.UserMapper;
import com.example.firstspringboot.model.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author code羊
 * @date 2024/1/28 20 52
 * discription 页面登录状态显示
 */
@Controller
public class IndexController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "2") Integer size){

        // 从数据库中获取问题信息
        PaginationDTO paginationDTO = questionService.list(page, size);
        model.addAttribute("pagination",paginationDTO);

        return "index";
    }
}
