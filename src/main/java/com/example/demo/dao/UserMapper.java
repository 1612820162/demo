package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;


@Mapper
public interface UserMapper {

    User getOneByUP(String userName, String password);
    List<User> getAll();
    List<User> getBySex(String sex);
    User getOne(String id);
    int insert(User user);
    int update(User user);
    int delete(String userName);
    int deleteAll();

}
