package com.controller;

import com.controller.result.Code;
import com.controller.result.Result;
import com.domain.OrdersDetails;
import com.service.OrdersDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders_details")
public class OrdersDetailsController {
    @Autowired
    OrdersDetailsService ordersDetailsService;

//    @PostMapping
//    public Result save(@RequestBody Orders orders) {
//        boolean flag =ordersService.save(orders);
//        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
//    }
//
//    @PutMapping
//    public Result update(@RequestBody Orders orders) {
//        boolean flag =ordersService.update(orders);
//        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
//    }
//
//
//    @DeleteMapping("/{id}")
//    public Result delete(@PathVariable Integer id) {
//        boolean flag =ordersService.delete(id);
//        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
//    }
//
//    @PostMapping ("/find")
//    public Result find(@RequestBody Orders orders) {
//        List<Orders> list =ordersService.find(orders);
//        Integer code = list!=null ? Code.GET_OK:Code.GET_ERR;
//        String msg = list!=null ?"":"数据查询失败！";
//        System.out.println(list);
//        return new Result(code,list,msg);
//    }
//
//    @GetMapping("/{id}")
//    public Result getById(@PathVariable Integer id) {
//        Orders orders = ordersService.getById(id);
//        Integer code = orders!=null ? Code.GET_OK:Code.GET_ERR;
//        String msg = orders!=null ?"":"数据查询失败！";
//        System.out.println(orders);
//        return new Result(code,orders,msg);
//    }
//
//    @GetMapping("/in")
//    public Result getAllIn() {
//        List<Orders> list =ordersService.getAllIn();
//        Integer code = list!=null ? Code.GET_OK:Code.GET_ERR;
//        String msg = list!=null ?"":"数据查询失败！";
//        return new Result(code,list,msg);
//    }
    @GetMapping("/{orders_id}")
    public Result getAll(@PathVariable Integer orders_id) {
        List<OrdersDetails> list =ordersDetailsService.getAll(orders_id);
        Integer code = list!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = list!=null ?"":"数据查询失败！";
        return new Result(code,list,msg);
    }
}
