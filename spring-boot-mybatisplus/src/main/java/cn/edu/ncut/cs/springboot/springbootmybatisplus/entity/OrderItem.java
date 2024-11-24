package cn.edu.ncut.cs.springboot.springbootmybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author wuzhigang
 * @since 2024-11-24
 */
@Getter
@Setter
@TableName("order_item")
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long productId;

    private Integer count;
}
