package com.controller;

import com.controller.result.Code;
import com.controller.result.Result;
import com.domain.Goods;
import com.domain.PageInfo;
import com.domain.User;
import com.domain.Warehouse;
import com.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehousreController {
    @Autowired
    private WarehouseService warehouseService;

    /**
     *
     * 查询所有仓库
     */
    @GetMapping
    public Result getAll() {
        List<Warehouse> list =warehouseService.getAll();
        Integer code = list!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = list!=null ?"仓库数据查询成功":"仓库数据查询失败！";
        return new Result(code,list,msg);
    }

    /**
     *
     * 通过仓库id查仓库名
     */
    @GetMapping("/{id}")
    public Result getnamebyid(@PathVariable Integer id) {
        String name =warehouseService.getnameByid(id);
        Integer code = name!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = name!=null ?"":"数据查询失败！";
        return new Result(code,name,msg);
    }

    /**
     *
     * 分页
     */
    @PostMapping("/page")
    public Result findByPage(@RequestBody PageInfo pageInfo) {
        PageInfo<Warehouse> pages =warehouseService.findByPage(pageInfo.getCurrentPage());
        Integer code = pages!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = pages!=null ?"仓库数据查询成功":"仓库数据查询失败！";
        return new Result(code,pages,msg);
    }

    /**
     *
     * 添加仓库
     */
    @PostMapping
    public Result save(@RequestBody Warehouse warehouse) {
        boolean flag =warehouseService.save(warehouse);
        Integer code = flag ? Code.SAVE_OK:Code.SAVE_ERR;
        String msg = flag ?"仓库数据添加成功":"仓库数据添加失败！";
        return new Result(code,flag,msg);
    }
}
