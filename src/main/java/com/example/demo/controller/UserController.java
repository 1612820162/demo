package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.entity.ret.RetResult;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     */
    @RequestMapping("login")
    public String login(@RequestParam("userName")String userName, @RequestParam("password")String password){
        return userService.login(userName, password);
    }

    /**
     * 根据id查找
     */
    @RequestMapping("/getone/{id}")
    public RetResult<User> getOne(@PathVariable("id") String id){
        return userService.getOne(id);
    }

    /**
     * 查找表中所有的用户（List(User)方式）
     */
    @GetMapping(value = "/getall")
    public RetResult<User> getAll(){
        return userService.getAll();
    }

    /**
     * 根据性别查找（Count）
     */
    @GetMapping(value = "/getbysex/{sex}")
    public RetResult<User> getBySex(@PathVariable("sex") String sex){
        return userService.getBySex(sex);
    }

    /**
     * 插入一条用户信息
     */
    @PostMapping(value = "/insert")
    public RetResult<User> insert(@RequestBody User user){
        return userService.insert(user);
    }

    /**
     * 更新一条用户信息
     */
    @PutMapping(value = "/update")
    public RetResult<User> update(@RequestBody User user){
        return userService.update(user);
    }

    /**
     * 根据用户名删除一条用户信息
     */
    @DeleteMapping(value = "/delete/{userName}")
    public RetResult<User> delete(@PathVariable("userName") String userName){
        return userService.delete(userName);
    }

    /**
     * 删除所有用户信息
     */
    @DeleteMapping(value = "/deleteall")
    public RetResult<User> deleteAll(){
        return userService.deleteAll();
    }

}
