package cn.edu.ncut.cs.springboot.redisdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
    private static final long serialVersionUID = -5095285519170350640L;
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer amount;
}

