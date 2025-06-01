package com.salary.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("workpiece_deail")
public class WorkpieceDeail implements Serializable {

        private static final long serialVersionUID = 1L;

    private Long id;

      /**
     * 工资表ID
     */
      private Long employeePaySheetId;

      /**
     * 工资月份ID
     */
      private Long paySheetId;

      /**
     * 员工ID（关联 employee_info）
     */
      private Long employeeId;

      /**
     * 工件ID
     */
      private Long workpieceId;

      /**
     * 数量
     */
      private Integer quantity;

      /**
     * 价格
     */
      private BigDecimal price;

      /**
     * 创建时间
     */
      private LocalDateTime createTime;
}
