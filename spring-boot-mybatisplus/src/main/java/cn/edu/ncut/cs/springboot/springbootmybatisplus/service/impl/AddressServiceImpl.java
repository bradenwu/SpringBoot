package cn.edu.ncut.cs.springboot.springbootmybatisplus.service.impl;

import cn.edu.ncut.cs.springboot.springbootmybatisplus.entity.Address;
import cn.edu.ncut.cs.springboot.springbootmybatisplus.mapper.AddressMapper;
import cn.edu.ncut.cs.springboot.springbootmybatisplus.service.IAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wuzhigang
 * @since 2024-11-24
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {

}
