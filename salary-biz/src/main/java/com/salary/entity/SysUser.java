package com.salary.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
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
@TableName("sys_user")
public class SysUser implements Serializable {

        private static final long serialVersionUID = 1L;

      /**
     * 主键ID
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

      /**
     * 用户名（用于登录）
     */
      private String username;

      /**
     * 密码（加密存储）
     */
      private String password;

      /**
     * 真实姓名
     */
      private String realName;

      /**
     * 邮箱
     */
      private String email;

      /**
     * 手机号
     */
      private String phone;

      /**
     * 头像URL
     */
      private String avatar;

      /**
     * 账号状态（0：禁用，1：启用）
     */
      private Byte status;

      /**
     * 是否为管理员（1 是，0 否）
     */
      private Byte isAdmin;

      /**
     * 上次登录时间
     */
      private LocalDateTime lastLoginTime;

      /**
     * 创建时间
     */
      private LocalDateTime createTime;

      /**
     * 更新时间
     */
      private LocalDateTime updateTime;
}
