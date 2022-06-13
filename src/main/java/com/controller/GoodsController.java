package com.controller;

import com.controller.result.Code;
import com.controller.result.Result;
import com.domain.Goods;
import com.domain.User;
import com.service.GoodsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @PostMapping
    public Result save(@RequestBody Goods goods) {
        boolean flag =goodsService.save(goods);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @PutMapping
    public Result update(@RequestBody Goods goods) {
        boolean flag =goodsService.update(goods);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag =goodsService.delete(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @PostMapping ("/find")
    public Result find(@RequestBody Goods goods) {
        List<Goods> list =goodsService.find(goods);
        Integer code = list!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = list!=null ?"":"数据查询失败！";
        return new Result(code,list,msg);
    }
    @GetMapping
    public Result getAll() {
        List<Goods> list =goodsService.getAll();
        Integer code = list!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = list!=null ?"":"数据查询失败！";
        return new Result(code,list,msg);
    }
}
