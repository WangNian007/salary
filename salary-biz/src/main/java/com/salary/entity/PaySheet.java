package com.salary.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
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
@TableName("pay_sheet")
public class PaySheet implements Serializable {

        private static final long serialVersionUID = 1L;

    @TableId("pay_sheet_id")
    private Long paySheetId;

      /**
     * 工资月份
     */
      private LocalDate salaryMonth;

      /**
     * 备注
     */
      private String remarks;

    private LocalDateTime createTime;
}
