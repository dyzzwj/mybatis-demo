package com.dyzwj.mybatis;

import com.dyzwj.mybatis.bean.Product;
import com.dyzwj.mybatis.bean.User;
import com.dyzwj.mybatis.mapper.ProductMapper;
import com.dyzwj.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengwenjie
 * @version 1.0.0
 * @ClassName TestBatchInsert.java
 * @Description TODO
 * @createTime 2020年08月17日 18:54:00
 */
public class TestBatchInsert {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
        SqlSession session = sessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> userList = new ArrayList<>();
        for (int i = 20; i < 30; i++) {
            User user = new User();
            user.setName("zwj" + i);
            user.setAddress("macheng" + i);
            userList.add(user);
        }


        BigDecimal bigDecimal = new BigDecimal(1);
        bigDecimal.com


//        User user = new User();
//        user.setAddress("macheng");
//        user.setName("zwj");
//        int i = userMapper.insertUser(user);
//        System.out.println(i);

        int batchInsert = userMapper.batchInsert(userList);
        System.out.println(batchInsert);
        userList.forEach(System.out::println);
//        List<User> users = userMapper.selectUser();
//        users.forEach(System.out::println);

//        ProductMapper productMapper = session.getMapper(ProductMapper.class);
//        List<Product> products = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//
//            Product product = new Product();
//            product.setProductName("name:" + i);
//            product.setCategoryId(i);
//            product.setFalseSales( 1 % 2 == 0 ? 0 : 1);
//            product.setPrice(String.valueOf(10 + i));
//            product.setProductContent("content: " + 1);
//            product.setSort(1);
//            product.setState((byte) 0);
//            product.setType((byte) 1);
//        }
//
//        int batch = productMapper.insertBatch(products);
//        System.out.println(batch);


//        List<Product> productList = productMapper.selectProductList(1,"");
//        productList.forEach(System.out::println);



    }
}
