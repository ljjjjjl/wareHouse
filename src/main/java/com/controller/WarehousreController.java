package com.controller;

import com.controller.result.Code;
import com.controller.result.Result;
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

    @GetMapping
    public Result getAll() {
        List<Warehouse> list =warehouseService.getAll();
        Integer code = list!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = list!=null ?"":"数据查询失败！";
        return new Result(code,list,msg);
    }
}
