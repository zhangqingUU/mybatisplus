package cn.kgc.yxlx.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 张晴
 * @CreateTime: 2021-01-25
 * @Description:
 */
@Configuration
@ConditionalOnClass(value= PaginationInnerInterceptor.class)
public class MybatisPlusConfig {//分页拦截器，辅助test10
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }
}
