package com.controller;

import com.controller.result.Code;
import com.controller.result.Result;
import com.domain.Goods;
import com.domain.PageInfo;
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
        boolean flag =goodsService.UNIQUE(goods);
        String msg = "";
        int code = Code.SYSTEM_UNKNOW_ERR;
        if (flag){
            msg = "货号已被占用，请重试";
            code = Code.SAVE_ERR;
        }else {
            boolean judge = goodsService.save(goods);
            if (!judge){
                msg = "新增货号失败";
                code = Code.SAVE_ERR;
            }else {
                msg = "新增货号成功";
                code = Code.SAVE_OK;
            }
        }
        return new Result(code,flag,msg);
    }

    @PutMapping
    public Result update(@RequestBody Goods goods) {
        boolean flag =goodsService.UNIQUE(goods);
        String msg = "";
        int code = Code.SYSTEM_UNKNOW_ERR;
        if (flag){
            msg = "货号已被占用，请重试";
            code = Code.UPDATE_ERR;
        }else {
            boolean judge = goodsService.update(goods);
            if (!judge){
                msg = "修改货号失败";
                code = Code.UPDATE_ERR;
            }else {
                msg = "修改货号成功";
                code = Code.UPDATE_OK;
            }
        }
        return new Result(code,flag,msg);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag =goodsService.delete(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @PatchMapping ("/{keyword}")
    public Result find(@PathVariable String keyword) {
        List<Goods> list =goodsService.find(keyword);
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
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Goods goods =goodsService.getById(id);
        Integer code = goods!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = goods!=null ? "":"getById查询失败！";
        return new Result(code,goods,msg);
    }

    @PostMapping("/page")
    public Result findByPage(@RequestBody PageInfo pageInfo) {
        PageInfo<Goods> pages =goodsService.findByPage(pageInfo.getCurrentPage());
        Integer code = pages!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = pages!=null ?"":"数据查询失败！";
        return new Result(code,pages,msg);
    }

    @PostMapping("/info")
    public Result search(@RequestBody PageInfo pageInfo){
        PageInfo<Goods> infos = goodsService.search(pageInfo.getInfo(),pageInfo.getCurrentPage());
        Integer code = infos!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = infos!=null ?"数据查询成功":"数据查询失败！";
        return new Result(code,infos,msg);
    }
}
