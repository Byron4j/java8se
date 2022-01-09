package org.byron4j.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.byron4j.beans.UserBean;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<UserBean> {
}
