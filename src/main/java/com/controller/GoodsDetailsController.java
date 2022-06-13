package com.controller;

import com.controller.result.Code;
import com.controller.result.Result;

import com.domain.Goods;
import com.domain.GoodsDetails;
import com.service.GoodsDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods_details")
public class GoodsDetailsController {
    @Autowired
    private GoodsDetailsService goodsDetailsService;

    @PostMapping
    public Result save(@RequestBody GoodsDetails goodsDetails) {
        boolean flag =goodsDetailsService.save(goodsDetails);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @PutMapping
    public Result update(@RequestBody GoodsDetails goodsDetails) {
        boolean flag =goodsDetailsService.update(goodsDetails);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag =goodsDetailsService.delete(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @PostMapping ("/find")
    public Result find(@RequestBody GoodsDetails goodsDetails) {
        List<GoodsDetails> list =goodsDetailsService.find(goodsDetails);
        Integer code = list!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = list!=null ?"":"数据查询失败！";
        return new Result(code,list,msg);
    }

    @GetMapping("/{goods_id}")
    public Result getAll(@PathVariable Integer goods_id) {
        List<GoodsDetails> list =goodsDetailsService.getAll(goods_id);
        Integer code = list!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = list!=null ?"":"数据查询失败！";
        return new Result(code,list,msg);
    }
}
