package com.controller;

import com.controller.result.Code;
import com.controller.result.Result;
import com.domain.Goods;
import com.domain.Orders;
import com.domain.PageInfo;
import com.domain.User;
import com.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    OrdersService ordersService;

    @Autowired
    HttpServletRequest request;

    @PostMapping
    public Result save(@RequestBody Orders orders) {
        Integer code = Code.SYSTEM_UNKNOW_ERR;
        String msg = null;
        User u = (User)request.getSession().getAttribute("loginUser");
        if(u!=null) {
            orders.setUser_id(u.getId());
            boolean flag = ordersService.save(orders);
            if (flag){
                code = Code.SAVE_OK;
                msg = "新增成功";
            }else{
                msg="新增失败";
                code = Code.SAVE_ERR;
            }
        }else{
            msg="请登录账户进行操作";
            code = Code.SAVE_ERR;
        }
        return new Result(code,u,msg);
    }

    @PutMapping
    public Result update(@RequestBody Orders orders) {
        boolean flag =ordersService.update(orders);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }


    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag =ordersService.delete(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @PostMapping ("/find")
    public Result find(@RequestBody Orders orders) {
        List<Orders> list =ordersService.find(orders);
        Integer code = list!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = list!=null ?"":"数据查询失败！";
        System.out.println(list);
        return new Result(code,list,msg);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Orders orders = ordersService.getById(id);
//        System.out.println(id);
        Integer code = orders!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = orders!=null ?"":"数据查询失败！";
        System.out.println(orders);
        return new Result(code,orders,msg);
    }

    @GetMapping("/in")
    public Result getAllIn() {
        List<Orders> list =ordersService.getAllIn();
        Integer code = list!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = list!=null ?"":"数据查询失败！";
        return new Result(code,list,msg);
    }
    @GetMapping("/out")
    public Result getAllOut() {
        List<Orders> list =ordersService.getAllOut();
        Integer code = list!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = list!=null ?"":"数据查询失败！";
        return new Result(code,list,msg);
    }

    @PostMapping("/page/in")
    public Result findByPageIn(@RequestBody PageInfo pageInfo) {
        PageInfo<Orders> pages =ordersService.findByPageIn(pageInfo.getCurrentPage());
        Integer code = pages!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = pages!=null ?"":"数据查询失败！";
        return new Result(code,pages,msg);
    }

    @PostMapping("/page/out")
    public Result findByPageOut(@RequestBody PageInfo pageInfo) {
        PageInfo<Orders> pages =ordersService.findByPageOut(pageInfo.getCurrentPage());
        Integer code = pages!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = pages!=null ?"":"数据查询失败！";
        return new Result(code,pages,msg);
    }
}
