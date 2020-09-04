package com.dyzwj.mybatis.mapper;

import com.dyzwj.mybatis.bean.Product;

import java.util.List;

/**
 * @author zhengwenjie
 * @version 1.0.0
 * @ClassName ProductMapper.java
 * @Description TODO
 * @createTime 2020年07月29日 16:06:00
 */
public interface ProductMapper {


    List<Product> selectProductList(Integer id,String name);

    int insertBatch(List<Product> productList);


}
