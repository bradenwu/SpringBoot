package cn.edu.ncut.cs.springboot.springbootmybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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
@TableName("order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String orderNo;

    private Long orderItemId;

    private Long productId;

    private Long addressId;

    private BigDecimal totalPrice;

    private Integer totalCount;

    private LocalDateTime orderTime;
}
