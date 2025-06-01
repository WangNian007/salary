package com.salary.entity;

import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("employee_pay_sheet")
public class EmployeePaySheet implements Serializable {

        private static final long serialVersionUID = 1L;

    @TableId("employee_pay_sheet_id")
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
     * 基本工资
     */
      private BigDecimal baseSalary;

      /**
     * 奖金
     */
      private BigDecimal bonus;

      /**
     * 津贴
     */
      private BigDecimal allowance;

      /**
     * 加班费
     */
      private BigDecimal overtimePay;

      /**
     * 计工资
     */
      private BigDecimal workpiecePay;

      /**
     * 扣款
     */
      private BigDecimal deduction;

      /**
     * 个税
     */
      private BigDecimal tax;

      /**
     * 应发工资
     */
      private BigDecimal grossPay;

      /**
     * 实发工资
     */
      private BigDecimal netPay;

      /**
     * 备注
     */
      private String remark;

      /**
     * 创建时间
     */
      private LocalDateTime createTime;

      /**
     * 更新时间
     */
      private LocalDateTime updateTime;
}
