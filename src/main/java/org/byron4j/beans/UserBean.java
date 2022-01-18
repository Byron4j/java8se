package org.byron4j.beans;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
@Builder
public class UserBean {
    @TableField
    private Long id;
    @TableField
    private String name;
    @TableField
    private Integer age;

    @NotBlank(message = "email不能为空")
    @TableField
    private String email;
    @TableField(exist = false)
    private List<String> hobbies;

    public UserBean(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
