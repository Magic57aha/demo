package com.example.firstspringboot.Service;

import com.example.firstspringboot.dto.PaginationDTO;
import com.example.firstspringboot.dto.QuestionDTO;
import com.example.firstspringboot.mapper.QuestionMapper;
import com.example.firstspringboot.mapper.UserMapper;
import com.example.firstspringboot.model.Question;
import com.example.firstspringboot.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author code羊
 * @date 2024/1/30 22 46
 * discription 通过question表中的creator获取user表中的头像地址，组合成新对象
 */
@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;
    public PaginationDTO list(Integer page, Integer size){
        // 分页展示对象
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.count();
        // 总页数
        Integer totalPage;
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }
        // 页码请求边界检查
        if (page < 1) page = 1;
        if (page > totalPage) page = totalPage;

        paginationDTO.setpagination(totalPage, page, size);
        // 页码查询参数
        Integer offset = size * (page-1);
        if(offset < 0) offset = 0;
        // 问题列表查询
        List<Question> questions = questionMapper.list(offset,size);
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        for (Question question : questions) {
            User user = userMapper.findByID(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOS);

        return paginationDTO;
    }

    public PaginationDTO list(Integer userId, Integer page, Integer size) {
        // 分页展示对象
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.countById(userId);
        // 总页数
        Integer totalPage;
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }
        // 页码请求边界检查
        if (page < 1) page = 1;
        if (page > totalPage) page = totalPage;

        paginationDTO.setpagination(totalPage, page, size);

        // 页码查询参数
        if(page < 1)page = 1;
        Integer offset = size * (page-1);
        if(offset < 0) offset = 0;

        // 问题列表查询
        List<Question> questions = questionMapper.listById(userId,offset,size);
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        for (Question question : questions) {
            User user = userMapper.findByID(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOS);

        return paginationDTO;
    }

    public QuestionDTO getById(Integer id) {
        Question question = questionMapper.getById(id);
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question, questionDTO);
        User user = userMapper.findByID(question.getCreator());
        questionDTO.setUser(user);
        return questionDTO;
    }

    public void createOrUpdate(Question question) {
        if(question.getId() == null){
            // 创建
            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(question.getGmtCreate());
            questionMapper.create(question);
        } else {
            question.setGmtModified(question.getGmtCreate());
            questionMapper.update(question);
        }
    }
}
