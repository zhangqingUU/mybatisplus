package cn.kgc.yxlx.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: 张晴
 * @CreateTime: 2021-01-25
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @TableId(type= IdType.AUTO)
    private long id;
    private String name;
    private int age;
    private String email;
    @JSONField(format="yyyy-MM-dd")//数据库导出页面时json格式化
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date borndate;
}
