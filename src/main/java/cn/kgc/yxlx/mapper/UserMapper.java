package cn.kgc.yxlx.mapper;

import cn.kgc.yxlx.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Author: 张晴
 * @CreateTime: 2021-01-25
 * @Description:
 */
public interface UserMapper extends BaseMapper<User> {
    int getCount2();
}
