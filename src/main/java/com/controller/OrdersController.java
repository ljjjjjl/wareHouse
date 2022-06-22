package com.controller;

import com.controller.result.Code;
import com.controller.result.Result;
import com.domain.*;
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

    /**
     *
     * 添加货单
     */
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

    /**
     *
     * 更新货单
     */
    @PutMapping
    public Result update(@RequestBody Orders orders) {
        boolean flag =ordersService.update(orders);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    /**
     *
     * 删除货单
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag =ordersService.delete(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    /**
     *
     * 模糊查询
     */
    @PostMapping ("/find")
    public Result find(@RequestBody Orders orders) {
        List<Orders> list =ordersService.find(orders);
        Integer code = list!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = list!=null ?"":"数据查询失败！";
        System.out.println(list);
        return new Result(code,list,msg);
    }

    /**
     *
     * 通过id查找货单
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Orders orders = ordersService.getById(id);
//        System.out.println(id);
        Integer code = orders!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = orders!=null ?"":"数据查询失败！";
//        System.out.println(orders);
        return new Result(code,orders,msg);
    }

    /**
     *
     * 查询所有入货单
     */
    @GetMapping("/in")
    public Result getAllIn() {
        List<Orders> list =ordersService.getAllIn();
        Integer code = list!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = list!=null ?"":"数据查询失败！";
        return new Result(code,list,msg);
    }
    /**
     *
     * 查询所有入货单
     */
    @GetMapping("/out")
    public Result getAllOut() {
        List<Orders> list =ordersService.getAllOut();
        Integer code = list!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = list!=null ?"":"数据查询失败！";
        return new Result(code,list,msg);
    }

    /**
     *
     * 分页（入库）
     */
    @PostMapping("/page/in")
    public Result findByPageIn(@RequestBody PageInfo pageInfo) {
        PageInfo<Orders> pages =ordersService.findByPageIn(pageInfo.getCurrentPage());
        Integer code = pages!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = pages!=null ?"":"数据查询失败！";
        return new Result(code,pages,msg);
    }

    /**
     *
     * 分页（出库）
     */
    @PostMapping("/page/out")
    public Result findByPageOut(@RequestBody PageInfo pageInfo) {
        PageInfo<Orders> pages =ordersService.findByPageOut(pageInfo.getCurrentPage());
        Integer code = pages!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = pages!=null ?"":"数据查询失败！";
        return new Result(code,pages,msg);
    }

    /**
     *
     * 查询的分页（入库）
     */
    @PostMapping("/info/in")
    public Result searchIn(@RequestBody PageInfo pageInfo){
        PageInfo<Orders> infos = ordersService.searchIn(pageInfo);
        Integer code = infos!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = infos!=null ?"数据查询成功":"数据查询失败！";
        return new Result(code,infos,msg);
    }
    /**
     *
     * 查询的分页（出库）
     */
    @PostMapping("/info/out")
    public Result searchOut(@RequestBody PageInfo pageInfo){
        PageInfo<Orders> infos = ordersService.searchOut(pageInfo);
        Integer code = infos!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = infos!=null ?"数据查询成功":"数据查询失败！";
        return new Result(code,infos,msg);
    }
}
