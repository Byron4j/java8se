package org.byron4j.beans;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class UserBean {
    @TableField
    private Long id;
    @TableField
    private String name;
    @TableField
    private Integer age;
    @TableField
    private String email;
    @TableField(exist = false)
    private List<String> hobbies;
}
