package com.controller;

import com.controller.result.Code;
import com.controller.result.Result;
import com.domain.GoodsDetails;
import com.domain.OrdersDetails;
import com.domain.PageInfo;
import com.domain.WarehouseDetails;
import com.exception.SqlException;
import com.service.OrdersDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders_details")
public class OrdersDetailsController {
    @Autowired
    OrdersDetailsService ordersDetailsService;
    @Autowired
    WarehouseDetailsController warehouseDetailsController ;

    /**
     *
     * 通过货单id查询所有货单明细
     */
    @GetMapping("/{orders_id}")
    public Result getAll(@PathVariable Integer orders_id) {
        List<OrdersDetails> list =ordersDetailsService.getAll(orders_id);
        Integer code = list!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = list!=null ?"":"数据查询失败！";
        return new Result(code,list,msg);
    }
    /**
     *
     * 添加入库明细
     */
    @PostMapping("/in")
    public Result saveIn(@RequestBody OrdersDetails ordersDetails) {
        if (ordersDetails.getAmount() <0){
            throw new SqlException(Code.SQL_NUMLESSZERO_ERR,"数量不能小于0");
        }
        boolean flag ;
        Result result;
        WarehouseDetails warehouseDetails = new WarehouseDetails();
        warehouseDetails.setNum(ordersDetails.getAmount());
        warehouseDetails.setWarehouse_id(ordersDetailsService.getWarehouseId(ordersDetails));
        warehouseDetails.setGoods_details_id(ordersDetails.getGoods_details_id());
        result =warehouseDetailsController.saveIn(warehouseDetails);

        if (result.getData().equals(true))
            flag =ordersDetailsService.save(ordersDetails);
        else
            flag =false;

        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }
    /**
     *
     * 添加出库明细
     */
    @PostMapping("/out")
    public Result saveOut(@RequestBody OrdersDetails ordersDetails) {
        if (ordersDetails.getAmount() <0){
            throw new SqlException(Code.SQL_NUMLESSZERO_ERR,"数量不能小于0");
        }
        boolean flag ;
        Result result;
        WarehouseDetails warehouseDetails = new WarehouseDetails();
        warehouseDetails.setNum(ordersDetails.getAmount());
//        System.out.println(ordersDetails.getOrders_id());
        warehouseDetails.setWarehouse_id(ordersDetailsService.getWarehouseId(ordersDetails));
        warehouseDetails.setGoods_details_id(ordersDetails.getGoods_details_id());
        result =warehouseDetailsController.saveOut(warehouseDetails);

        if (result.getData().equals(true))
            flag =ordersDetailsService.save(ordersDetails);
        else
            flag =false;

        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    /**
     *
     * 删除货单明细
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag =ordersDetailsService.delete(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }
    /**
     *
     * 模糊查询
     */
    @PostMapping ("/find")
    public Result find(@RequestBody OrdersDetails ordersDetails) {
        List<OrdersDetails> list =ordersDetailsService.find(ordersDetails);
        Integer code = list!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = list!=null ?"":"数据查询失败！";
        return new Result(code,list,msg);
    }
    /**
     *
     * 修改入库明细
     */
    @PutMapping("/in")
    public Result updateIn(@RequestBody OrdersDetails ordersDetails) {
        if (ordersDetails.getAmount() <0){
            throw new SqlException(Code.SQL_NUMLESSZERO_ERR,"数量不能小于0");
        }
        boolean flag ;
        int pro =ordersDetailsService.getAmount(ordersDetails);
        int after =ordersDetails.getAmount();
        int D =after -pro;

        ordersDetails =ordersDetailsService.getById(ordersDetails.getId());//通过id找到全部信息，以调用写过的方法

        Result result;
        WarehouseDetails warehouseDetails = new WarehouseDetails();
        warehouseDetails.setNum(D);
        warehouseDetails.setWarehouse_id(ordersDetailsService.getWarehouseId(ordersDetails));
        warehouseDetails.setGoods_details_id(ordersDetails.getGoods_details_id());
        if (D <0){
            warehouseDetails.setNum(-D);
            result =warehouseDetailsController.saveOut(warehouseDetails);
        }
        else
            result =warehouseDetailsController.saveIn(warehouseDetails);

        if (result.getData().equals(true)){
            ordersDetails.setAmount(after);//ordersDetails.Amount信息已被覆盖，此处重新导入
            flag =ordersDetailsService.update(ordersDetails);
        }
        else
            flag =false;

        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    /**
     *
     * 修改出库明细
     */
    @PutMapping("/out")
    public Result updateOut(@RequestBody OrdersDetails ordersDetails) {
        if (ordersDetails.getAmount() <0){
            throw new SqlException(Code.SQL_NUMLESSZERO_ERR,"数量不能小于0");
        }
        boolean flag ;
        int pro =ordersDetailsService.getAmount(ordersDetails);
        int after =ordersDetails.getAmount();
        int D = pro-after;

        ordersDetails =ordersDetailsService.getById(ordersDetails.getId());//通过id找到全部信息，以调用写过的方法

        Result result;
        WarehouseDetails warehouseDetails = new WarehouseDetails();
        warehouseDetails.setNum(D);
        warehouseDetails.setWarehouse_id(ordersDetailsService.getWarehouseId(ordersDetails));
        warehouseDetails.setGoods_details_id(ordersDetails.getGoods_details_id());
        if (D <0){
            warehouseDetails.setNum(-D);
            result =warehouseDetailsController.saveOut(warehouseDetails);
        }
        else
            result =warehouseDetailsController.saveIn(warehouseDetails);

        if (result.getData().equals(true)){
            ordersDetails.setAmount(after);//ordersDetails.Amount信息已被覆盖，此处重新导入
            flag =ordersDetailsService.update(ordersDetails);
        }
        else
            flag =false;

        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    /**
     *
     * 通过id找到货单明细
     */
    @PatchMapping("/{id}")
    public Result getbyid(@PathVariable Integer id){
        OrdersDetails ordersDetails = ordersDetailsService.getById(id);
        String msg = "";
        Integer code = Code.SYSTEM_UNKNOW_ERR;
        if (ordersDetails != null){
            code = Code.GET_OK;
            msg = "查询数据成功";
        }else {
            code = Code.GET_ERR;
            msg = "查询数据失败";
        }
        return new Result(code,ordersDetails,msg);
    }
    /**
     *
     * 分页
     */
    @PostMapping("/page")
    public Result findByPage(@RequestBody PageInfo pageInfo) {
        PageInfo<OrdersDetails> pages =ordersDetailsService.findByPage(pageInfo.getOthers_id(),pageInfo.getCurrentPage());
        Integer code = pages!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = pages!=null ?"":"数据查询失败！";
        return new Result(code,pages,msg);
    }
    /**
     *
     * 查询全部的分页
     */
    @PostMapping("/info")
    public Result findAll(@RequestBody PageInfo pageInfo) {
        PageInfo<OrdersDetails> pages =ordersDetailsService.findAll(pageInfo.getInfo(),pageInfo.getCurrentPage());
        Integer code = pages!=null ? Code.GET_OK:Code.GET_ERR;
        String msg = pages!=null ?"":"数据查询失败！";
        return new Result(code,pages,msg);
    }
}
