package cn.kgc.yxlx;


import cn.kgc.yxlx.mapper.UserMapper;
import cn.kgc.yxlx.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class YxlxApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    public void test1() {
        //1、查询
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void test2() {
        //2、增加
        User user = new User(100, "张三", 19, "123@qq.com", null);

        int result = userMapper.insert(user);
        if (result > 0) {
            System.out.println("添加成功！");
            test1();
        } else {
            System.out.println("添加失败！");
        }
    }

    @Test
    public void test4() {
        //4、删除
        int result = userMapper.deleteById(7L);
        if (result > 0) {
            System.out.println("删除成功！");
            test1();
        } else {
            System.out.println("删除失败！");
        }
    }

    @Test
    public void test5() {
        //5、根据单个条件做查询
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name", "小明");

        List list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test6() {
        //6、根据多个条件做查询
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name", "小明");
        queryWrapper.eq("id", 8L);

        List list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test7() {
        //6、比较查询
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.gt("age", 18);

        List list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test8() {
        //7、模糊查询
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("name", "明");

        List list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test9() {
        //9、排序
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.orderByDesc("age");

        List list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test10() {
        //10、分页，补充说明：这个分页有bug，没有添加分页控制类MybatisPlusConfig，https://mp.baomidou.com/guide/page.html
        Page<User> userPage=new Page<>(1,3);
        userPage = userMapper.selectPage(userPage, null);
        List<User> records = userPage.getRecords();
        records.forEach(System.out::println);
    }

    @Test
    public void test11() {
        //11、自己编写的测试总条数的方法，注意mapper.xml文件中的resultType和
        System.out.println("总条数："+userMapper.getCount2());
    }

    @Test
    public void test13() {
        //12、修改
        User user = new User(6L, "喜洋洋", 20, "321@qq.com", null);

        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("id",6L);

        //4、删除
        int result = userMapper.update(user,queryWrapper);
        if (result > 0) {
            System.out.println("修改成功！");
            test1();
        } else {
            System.out.println("修改失败！");
        }
    }

    @Test
    public void test14() {
        //14、子查询
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.inSql("id","select id from user where age>18");

        List list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

}
