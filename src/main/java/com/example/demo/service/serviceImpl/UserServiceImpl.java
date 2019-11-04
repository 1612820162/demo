package com.example.demo.service.serviceImpl;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.entity.ret.RetResponse;
import com.example.demo.entity.ret.RetResult;
import com.example.demo.service.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * @author idmin
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    /**
     * 根据用户名查询用户信息（用来登录验证）
     */
    @Override
    public String login(String userName, String password) {

        User user=userMapper.getOneByUP(userName, password);
        Gson gson=new GsonBuilder().create();
        String str = gson.toJson(user);
        if (user!=null){
            return "登录成功!用户信息为："+str;
        }else {
            return "登录失败";
        }
    }

    /**
     * 根据id查询用户信息
     */
    @Override
    public RetResult<User> getOne(String id) {

        User user = userMapper.getOne(id);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        if (user == null) {
            return RetResponse.makeRsp(201, "暂无数据");
        } else {
            return RetResponse.makeRsp(200, "查找成功", userList);
        }
    }

    /**
     * 查询表中所有用户数据
     */
    @Override
    public RetResult<User> getAll()  {

        List<User> userList=userMapper.getAll();
        if (userList.size()>0){
            return RetResponse.makeRsp(200, "查找成功", userList);
        }else {
            return RetResponse.makeRsp(201,"暂无数据");
        }
    }

    /**
     * 根据性别查询用户信息
     */
    @Override
    public RetResult<User> getBySex(String sex) {

        List<User> userList = new ArrayList<>();
        if ("man".equals(sex)) {
            userList = userMapper.getBySex("男");
        }
        if ("woman".equals(sex)) {
            userList = userMapper.getBySex("女");
        }
        if (userList.size() > 0) {
            return RetResponse.makeRsp(200, "查找成功", userList);
        } else {
            return RetResponse.makeRsp(201, "暂无数据");
        }
    }

    /**
     * 插入一条用户信息
     */
    @Override
    public RetResult<User> insert(User user) {

        String uuid= UUID.randomUUID().toString().replaceAll("-","");
        user.setId(uuid);
        int isOK=userMapper.insert(user);
        if (isOK == 1){
            return RetResponse.makeRsp(200,"插入成功");
        }else {
            return RetResponse.makeRsp(500,"插入失败");
        }
    }

    /**
     * 更新用户信息
     */
    @Override
    public RetResult<User> update(User user) {

        int isOK=userMapper.update(user);
        if (isOK==1){
            return RetResponse.makeRsp(200,"修改成功");
        }else {
            return RetResponse.makeRsp(500,"修改失败");
        }
    }

    /**
     * 根据用户名删除用户信息
     */
    @Override
    public RetResult<User> delete(String userName) {

        int isOK=userMapper.delete(userName);
        if (isOK>=1){
            return RetResponse.makeRsp(200,"删除成功");
        }else {
            return RetResponse.makeRsp(500,"删除失败");
        }
    }

    /**
     * 删除表中所有用户信息
     */
    @Override
    public RetResult<User> deleteAll() {

        int isOK=userMapper.deleteAll();
        if (isOK!=0){
            return RetResponse.makeRsp(200,"删除成功");
        }else {
            return RetResponse.makeRsp(500, "删除失败");
        }
    }
}
