package com.example.firstspringboot.mapper;
import com.example.firstspringboot.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author code羊
 * @date 2024/1/20 14 40
 * discription
 */
@Mapper
public interface UserMapper {
    @Insert("insert into USERTABLE (name,account_Id,token,gmt_create,gmt_modified) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);
}
