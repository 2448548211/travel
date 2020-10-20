package com.xlibaba.travel.dao;

import java.util.List;

/**
 * @author ChenWang
 * @interfaceName ICategoryDAO
 * @date 2020/10/20 23:13
 * @since JDK 1.8
 */
public interface ICategoryDAO {
    List<String> selectAll();
}
