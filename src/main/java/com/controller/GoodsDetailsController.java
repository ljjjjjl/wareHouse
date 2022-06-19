package com.controller;

import com.controller.result.Code;
import com.controller.result.Result;

import com.domain.Goods;
import com.domain.GoodsDetails;
import com.domain.PageInfo;
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
        boolean flag =goodsDetailsService.UNIQUE(goodsDetails);
        String msg = "";
        int code = Code.SYSTEM_UNKNOW_ERR;
        if (!flag){
            boolean judge = goodsDetailsService.save(goodsDetails);
            if (!judge){
                msg = "新增货单明细失败";
                code = Code.SAVE_ERR;
            }else {
                msg = "新增货单明细成功";
                code = Code.SAVE_OK;
            }
        }else{
            msg = "货单明细已存在，请重试";
            code = Code.SAVE_ERR;
        }
        return new Result(code,flag,msg);
    }

    @PutMapping
    public Result update(@RequestBody GoodsDetails goodsDetails) {
        boolean flag =goodsDetailsService.UNIQUE(goodsDetails);
        System.out.println(goodsDetails);
        String msg = "";
        int code = Code.SYSTEM_UNKNOW_ERR;
        if (!flag){
            boolean judge = goodsDetailsService.update(goodsDetails);
            if (!judge){
                msg = "修改货单明细失败";
                code = Code.UPDATE_ERR;
            }else {
                msg = "修改货单明细成功";
                code = Code.UPDATE_OK;
            }
        }else{
            msg = "货单明细已存在，请重试";
            code = Code.UPDATE_ERR;
        }
        return new Result(code,flag,msg);
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

    @GetMapping
    public Result getAllGoodsdetail() {
        List<GoodsDetails> list =goodsDetailsService.getAllGoodsdetail();
        Integer code = list!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = list!=null ?"":"数据查询失败！";
        return new Result(code,list,msg);
    }

    @PatchMapping("/{id}")
    public Result getbyid(@PathVariable Integer id) {
        GoodsDetails list =goodsDetailsService.getbyid(id);
        Integer code = list!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = list!=null ?"":"数据查询失败！";
        return new Result(code,list,msg);
    }



    @PostMapping("/page")
    public Result findByPage(@RequestBody PageInfo pageInfo) {
        PageInfo<GoodsDetails> pages =goodsDetailsService.findByPage(pageInfo.getOthers_id(),pageInfo.getCurrentPage());
        Integer code = pages!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = pages!=null ?"":"数据查询失败！";
        return new Result(code,pages,msg);
    }

    @PostMapping("/info")
    public Result search(@RequestBody PageInfo pageInfo){
        PageInfo<GoodsDetails> infos = goodsDetailsService.search(pageInfo.getCurrentPage());
        Integer code = infos!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = infos!=null ?"数据查询成功":"数据查询失败！";
        return new Result(code,infos,msg);
    }
}
