package com.dyzwj.mybatis;


import com.dyzwj.mybatis.bean.Product;
import com.dyzwj.mybatis.mapper.ProductMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengwenjie
 * @version 1.0.0
 * @ClassName Main.java
 * @Description TODO
 * @createTime 2020年07月29日 16:09:00
 */
public class Main {

    public static void main(String[] args) throws IOException {

        String name = "mybatis.xml";
        //加载配置文件
        InputStream inputStream = Resources.getResourceAsStream(name);
        //通过配置文件创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        //开启驼峰命名
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
        try {
            ProductMapper productMapper = session.getMapper(ProductMapper.class);
            List<Product> productList = productMapper.selectProductList(1,"");
            productList.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        ProductMapper instance = (ProductMapper) Proxy.newProxyInstance(Main.class.getClassLoader(), new Class[]{ProductMapper.class}, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                Parameter[] parameters = method.getParameters();
//                for (Parameter parameter : parameters) {
//                    System.out.println(parameter.getName());
//                }
//                return null;
//            }
//
//        });
//        instance.selectProductList(1,"zwj");
//
//
        Class<Main> clazz = Main.class;
        try {
            Method method = clazz.getMethod("method1", String.class, String.class);
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println(parameter.getName());
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }


    public void method1(String name,String email){
        System.out.println(name+":"+email);

    }

    public static Map<String,Object> buildArgsNameMap(Method method, Object[] args){

        Map<String,Object> result = new HashMap<>();
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            result.put(parameters[i].getName(),args[i]);
        }
        return result;
    }


}
