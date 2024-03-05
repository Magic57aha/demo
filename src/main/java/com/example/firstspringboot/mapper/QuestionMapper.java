package com.example.firstspringboot.mapper;

import com.example.firstspringboot.model.Question;
import org.apache.ibatis.annotations.*;

import java.util.Iterator;
import java.util.List;

/**
 * @author code羊
 * @date 2024/1/29 20 52
 * discription 表question方法映射
 */
@Mapper
public interface QuestionMapper {
    @Insert("insert into question (TITLE, DESCRIPTION,gmt_create, GMT_MODIFIED, CREATOR, COMMENT_COUNT, VIEW_COUNT, LIKE_COUNT, TAG) values ( #{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{commentCount},#{viewCount},#{likeCount},#{tag})")
    void create(Question question);

    @Select("select * from QUESTION limit #{offset}, #{size}")
    List<Question> list(@Param(value = "offset") Integer offset,@Param(value = "size") Integer size);

    @Select("select count(1) from  QUESTION")
    Integer count();
    @Select("select * from QUESTION where CREATOR = #{userId} limit #{offset},#{size}")
    List<Question> listById(@Param(value = "userId") Integer userId, @Param(value = "offset") Integer offset,@Param(value = "size") Integer size);

    @Select("select count(1) from  QUESTION where CREATOR = #{userId}")
    Integer countById(@Param(value = "userId") Integer userId);

    @Select("select * from QUESTION where id = #{id}")
    Question getById(@Param("id") Integer id);

    @Update("update question set title = #{title}, description = #{description}, gmt_modified = #{gmtModified}, tag = #{tag} where id = #{id}")
    void update(Question question);
}
