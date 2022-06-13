package com.controller;

import com.controller.result.Code;
import com.controller.result.Result;
import com.domain.User;
import com.domain.WarehouseDetails;
import com.exception.SqlException;
import com.service.WarehouseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse_details")
public class WarehouseDetailsController {
    @Autowired
    WarehouseDetailsService warehouseDetailsService;

    @GetMapping("/{warehouse_id}")
    public Result getAll(@PathVariable Integer warehouse_id) {
        List<WarehouseDetails> list =warehouseDetailsService.getAll(warehouse_id);
        Integer code = list!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = list!=null ?"":"数据查询失败！";
        return new Result(code,list,msg);
    }

    /**
     * 入库：
     * 先查询仓库明细表，是否有该仓库的该货品
     * 	true，返回仓库明细表_id,修改数量
     * 	flase，添加一条记录到仓库明细表
     * 添加一条记录到货单明细表(实现于OrderDetailsController)
     */
    @PostMapping("/in")
    public Result saveIn(@RequestBody WarehouseDetails warehouseDetails) {
        int num;
        boolean flag =warehouseDetailsService.unique(warehouseDetails);
        if (flag){
            warehouseDetails.setId(warehouseDetailsService.uniqueId(warehouseDetails));

            num =warehouseDetails.getNum() + warehouseDetailsService.selectNum(warehouseDetails);
            warehouseDetails.setNum(num);
            flag =warehouseDetailsService.updateNum(warehouseDetails);

        }else {
            flag =warehouseDetailsService.save(warehouseDetails);
        }

        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

//    @PutMapping("/in")
//    public Result updateIn(@RequestBody WarehouseDetails warehouseDetails) {
//        int num;
//        boolean flag;
//        warehouseDetails.setId(warehouseDetailsService.uniqueId(warehouseDetails));
//        num =warehouseDetailsService.selectNum(warehouseDetails) -warehouseDetails.getNum();
//
//        if (flag){
//
//
//            num =warehouseDetails.getNum() + warehouseDetailsService.selectNum(warehouseDetails);
//            warehouseDetails.setNum(num);
//            flag =warehouseDetailsService.updateNum(warehouseDetails);
//
//        }else {
//            flag =warehouseDetailsService.save(warehouseDetails);
//        }
//
//        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
//    }
    /**
     * 出库：
     * 先查询仓库明细表，找到该仓库的该货品的if(库存数量>出库单数量)
     * 	true，修改数量（库存数量-出库单数量)
     * 		添加一条记录到货单明细表    (实现于OrderDetailsController)
     * 	flase，抛出异常提示用户该仓库库存不足
     */
    @PostMapping("/out")
    public Result saveOut(@RequestBody WarehouseDetails warehouseDetails) {
        int num;
        boolean flag ;
        warehouseDetails.setId(warehouseDetailsService.uniqueId(warehouseDetails));
        num =warehouseDetailsService.selectNum(warehouseDetails) -warehouseDetails.getNum();
        warehouseDetails.setNum(num);
        if (num >=0){
            flag =warehouseDetailsService.updateNum(warehouseDetails);

        }else {

            throw new SqlException(Code.SQL_LESSTHANZERO_ERR,"库存不足");
        }

        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

//    @PutMapping("/out")
//    public Result updateOut(@RequestBody WarehouseDetails warehouseDetails) {
//        int num;
//        boolean flag;
//        warehouseDetails.setId(warehouseDetailsService.uniqueId(warehouseDetails));
//        num =warehouseDetailsService.selectNum(warehouseDetails) -warehouseDetails.getNum();
//
//        if (flag){
//
//
//            num =warehouseDetails.getNum() + warehouseDetailsService.selectNum(warehouseDetails);
//            warehouseDetails.setNum(num);
//            flag =warehouseDetailsService.updateNum(warehouseDetails);
//
//        }else {
//            flag =warehouseDetailsService.save(warehouseDetails);
//        }
//
//        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
//    }
}
