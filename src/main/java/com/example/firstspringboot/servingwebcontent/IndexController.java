package com.example.firstspringboot.servingwebcontent;

import com.example.firstspringboot.mapper.UserMapper;
import com.example.firstspringboot.model.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author code羊
 * @date 2024/1/28 20 52
 * discription 页面登录状态显示
 */
@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/")
    public String index(HttpServletRequest request){
        // 获取cookies
        Cookie[] cookies = request.getCookies();
        // 查询cookies中的token在数据库中是否存在，存在则写入Session（页面的显示状态是根据Session中的user.name是否存在判断的）
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("token")){
                String token = cookie.getValue();
                User user = userMapper.findByToken(token);
                if (user != null){
                    request.getSession().setAttribute("user",user);
                }
            }
        }
        return "index";
    }
}
