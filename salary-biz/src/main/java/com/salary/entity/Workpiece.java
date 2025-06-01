package com.salary.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangnian
 * @since 2025-06-01
 */
@Getter
@Setter
@ToString
public class Workpiece implements Serializable {

        private static final long serialVersionUID = 1L;

    @TableId("workpiece_id")
    private Long workpieceId;

    private String name;

      /**
     * 计件价格
     */
      private BigDecimal price;

    private LocalDateTime createTime;
}
