package cn.kgc.yxlx.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: 张晴
 * @CreateTime: 2021-01-25
 * @Description:
 */
@Component
public class DBHanlder implements MetaObjectHandler {//自动更新创建时间更新时间
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("borndate",new Date(),metaObject);
        //省略多个*
        //this.setFieldValByName("birthday",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("borndate",new Date(),metaObject);
    }
}
