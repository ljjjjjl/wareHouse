package com.controller;

import com.controller.result.Code;
import com.controller.result.Result;
import com.domain.PageInfo;
import com.domain.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    HttpServletRequest request;

    /**
     *
     * 添加用户
     */
    @PostMapping
    public Result save(@RequestBody User user) {
        boolean flag =userService.save(user);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag,flag ? "新增用户成功":"新增用户失败");
    }

    /**
     *
     * 更新用户
     */
    @PutMapping
    public Result update(@RequestBody User user) {
        boolean flag =userService.update(user);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    /**
     *
     * 修改密码
     */
    @DeleteMapping
    public Result change(@RequestBody User user) {
        boolean flag =userService.change(user);

        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    /**
     *
     * 删除用户
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag =userService.delete(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }
    /**
     *
     * 通过id查找用户
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        User user =userService.getById(id);
        Integer code = user!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = user!=null ? "":"getById查询失败！";
        return new Result(code,user,msg);
    }
    /**
     *
     * 查询所有用户
     */
    @GetMapping
    public Result getAll() {
        List<User> list =userService.getAll();
        Integer code = list!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = list!=null ?"":"数据查询失败！";
        return new Result(code,list,msg);
    }


    /**
     *
     * 登录
     */
    @PostMapping({"/login"})
    public Result login(@RequestBody User user){
        User u =userService.login(user);
        Integer code = u!=null ? Code.LOGIN_OK:Code.LOGIN_ERR;
        String msg = u!=null ?"登录成功":"登录失败！";
        request.getSession().setAttribute("loginUser",u);
//        System.out.println(u);
        return new Result(code,u,msg);
    }

    /**
     *
     * 注销
     */
    @GetMapping("/logout")
    public Result logout() {
        Integer code = Code.SYSTEM_UNKNOW_ERR;
        String msg = null;
        User u = (User)request.getSession().getAttribute("loginUser");
        String username = u.getUser_name();
//        System.out.println(u);
        try {
            HttpSession session = request.getSession();
            //销毁Session
            session.invalidate();
            code = Code.LOGOUT_OK;
            msg = ",注销成功";
        }catch (Exception e){
            e.printStackTrace();
            code = Code.LOGOUT_ERR;
            msg = ",注销登录失败";
        }
        return new Result(code,username,msg);
    }

    /**
     *
     * 获取当前用户
     */
    @GetMapping("/username")
    public Result usernameshow(){
        Integer code = Code.SYSTEM_UNKNOW_ERR;
        String msg = null;
        User u = (User)request.getSession().getAttribute("loginUser");
        try {
            code = Code.GET_OK;
            msg = "获取用户名成功";
        }catch (Exception e){
            e.printStackTrace();
            code = Code.GET_ERR;
            msg = "获取用户名失败";
        }
        return new Result(code,u,msg);
    }

    /**
     *
     * 分页
     */
    @PostMapping("/page")
    public Result findByPage(@RequestBody PageInfo pageInfo) {
        PageInfo<User> pages =userService.findByPage(pageInfo.getCurrentPage());
        Integer code = pages!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = pages!=null ?"":"数据查询失败！";
        return new Result(code,pages,msg);
    }

    /**
     *
     * 查询的分页
     */
    @PostMapping("/info")
    public Result search(@RequestBody PageInfo pageInfo){
        PageInfo<User> infos = userService.search(pageInfo.getInfo(),pageInfo.getCurrentPage());
        Integer code = infos!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = infos!=null ?"数据查询成功":"数据查询失败！";
        return new Result(code,infos,msg);
    }
}
