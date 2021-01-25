package cn.kgc.yxlx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.kgc.yxlx.mapper")
public class YxlxApplication {

    public static void main(String[] args) {
        SpringApplication.run(YxlxApplication.class, args);
    }

}
