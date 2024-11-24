package cn.edu.ncut.cs.springboot.springbootmybatisplus.service.impl;

import cn.edu.ncut.cs.springboot.springbootmybatisplus.entity.Order;
import cn.edu.ncut.cs.springboot.springbootmybatisplus.mapper.OrderMapper;
import cn.edu.ncut.cs.springboot.springbootmybatisplus.service.IOrderService;
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
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
