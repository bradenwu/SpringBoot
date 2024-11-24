package cn.edu.ncut.cs.springboot.springbootmybatisplus.service.impl;

import cn.edu.ncut.cs.springboot.springbootmybatisplus.entity.OrderItem;
import cn.edu.ncut.cs.springboot.springbootmybatisplus.mapper.OrderItemMapper;
import cn.edu.ncut.cs.springboot.springbootmybatisplus.service.IOrderItemService;
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
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements IOrderItemService {

}
