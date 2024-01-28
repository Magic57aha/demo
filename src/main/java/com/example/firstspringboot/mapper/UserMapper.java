package com.example.firstspringboot.mapper;
import com.example.firstspringboot.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author code羊
 * @date 2024/1/20 14 40
 * discription 数据库方法映射
 */
@Mapper
public interface UserMapper {
    @Insert("insert into USERTABLE (name,account_Id,token,gmt_create,gmt_modified) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);
    @Select("select * from USERTABLE where token = #{token}")
    User findByToken(@Param("token") String token);
}
