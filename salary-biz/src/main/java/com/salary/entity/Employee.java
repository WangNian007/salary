package com.salary.entity;

import com.baomidou.mybatisplus.annotation.TableId;
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
public class Employee implements Serializable {

        private static final long serialVersionUID = 1L;

    @TableId("employee_id")
    private Long employeeId;

      /**
     * 姓名
     */
      private String name;

      /**
     * 手机号码
     */
      private String phone;

      /**
     * 年龄
     */
      private Byte age;

      /**
     * 性别
     */
      private Integer gender;

      /**
     * 备注
     */
      private String remarks;

      /**
     * 入职日期
     */
      private LocalDate hireDate;

    private LocalDateTime createTime;
}
