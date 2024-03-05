package com.example.firstspringboot.mapper;
import com.example.firstspringboot.model.User;
import org.apache.ibatis.annotations.*;

/**
 * @author code羊
 * @date 2024/1/20 14 40
 * discription 数据库方法映射
 */
@Mapper
public interface UserMapper {
    @Insert("insert into USERTABLE (name,account_Id,token,gmt_create,gmt_modified,avatar_url) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);
    @Select("select * from USERTABLE where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from USERTABLE where id = #{id}")
    User findByID(@Param("id") Integer id);
    @Select("select * from USERTABLE where account_id = #{accountId}")
    User findByAccountId(@Param("accountId") String accountId);
    @Update("update usertable set name = #{name}, token = #{token}, gmt_modified = #{gmtModified}, avatar_url = #{avatarUrl} where id =#{id}")
    void update(User user);
}
