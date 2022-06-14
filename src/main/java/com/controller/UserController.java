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
    HttpServletRequest request;   //首先可以通过注解的方式  获取一个 request


    @PostMapping
    public Result save(@RequestBody User user) {
        boolean flag =userService.save(user);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

//    @PutMapping
//    public Result update(@RequestBody User user) {
//        boolean flag =userService.update(user);
//        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
//    }
    @PutMapping
    public Result change(@RequestBody User user) {
        boolean flag =userService.change(user);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }


    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag =userService.delete(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        User user =userService.getById(id);
        Integer code = user!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = user!=null ? "":"getById查询失败！";
        return new Result(code,user,msg);
    }

    @GetMapping
    public Result getAll() {
        List<User> list =userService.getAll();
        Integer code = list!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = list!=null ?"":"数据查询失败！";
        return new Result(code,list,msg);
    }

    @PostMapping({"/login"})
    public Result login(@RequestBody User user,HttpServletRequest request){
        User u =userService.login(user);
        Integer code = u!=null ? Code.LOGIN_OK:Code.LOGIN_ERR;
        String msg = u!=null ?"登录成功":"数据查询失败！";
        request.getSession().setAttribute("loginUser",u);
//        System.out.println(u);
        return new Result(code,u,msg);
    }

    @GetMapping("/logout")
    public Result logout() {
        Integer code = Code.SYSTEM_UNKNOW_ERR;
        String msg = null;
        User u = (User)request.getSession().getAttribute("loginUser");
        String username = u.getUser_name();
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

    @GetMapping("/page/{currentPage}")
    public Result findByPage(@PathVariable int currentPage) {
        PageInfo<User> list =userService.findByPage(currentPage);
        Integer code = list!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = list!=null ?"":"数据查询失败！";
        return new Result(code,list,msg);
    }
}
