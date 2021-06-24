package com.guorui.hak.dao;


import com.guorui.hak.entity.user.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {

    @Select("select * from user where account = #{account}")
    public User getUserByAccount(String account);

    @Select("select * from user where name = #{name}")
    public User getUserByName(String name);

    @Select("select name from user where uid = #{uid}")
    public String getNameById(int uid);

    @Select("select token from user where account = #{account}")
    public String getTokenByAccount(String account);

    @Insert("insert into user(account,name,phone,psw,token) values(#{account},#{name},#{phone},#{psw},#{token})")
    public void insertUser(@Param("account") String account,@Param("name")String name,@Param("phone") String phone,@Param("psw") String psw,@Param("token") String token);

}
