package cn.edu.ncut.cs.springboot.springbootmybatisplus.controller;

import cn.edu.ncut.cs.springboot.springbootmybatisplus.entity.Address;
import cn.edu.ncut.cs.springboot.springbootmybatisplus.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wuzhigang
 * @since 2024-11-24
 */
@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private IAddressService addressService;

    @PutMapping("/saveOrUpdate")
    public boolean saveOrUpdate(@RequestBody Address address){
        return addressService.saveOrUpdate(address);
    }
    @GetMapping("/list")
    public List<Address> remove(){
        return addressService.list();
    }
}
