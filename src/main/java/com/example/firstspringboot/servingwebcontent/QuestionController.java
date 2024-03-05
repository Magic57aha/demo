package com.example.firstspringboot.servingwebcontent;

import com.example.firstspringboot.Service.QuestionService;
import com.example.firstspringboot.dto.QuestionDTO;
import org.apache.ibatis.annotations.Param;
import org.h2.engine.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author code羊
 * @date 2024/2/5 16 45
 * discription
 */
@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Integer id,
                           Model model){
        QuestionDTO questionDTO = questionService.getById(id);
        model.addAttribute("question", questionDTO);
        return  "question";
    }
}
