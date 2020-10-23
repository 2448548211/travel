package com.xlibaba.travel.service;

import com.xlibaba.travel.service.page.HeaderPage;

/**
 * @author ChenWang
 * @interfaceName IHeaderService
 * @date 2020/10/20 23:01
 * @since JDK 1.8
 */
public interface IHeaderService {
    /**
     * 获取标头页面数据
     * @param username  用户名
     * @return  标头页面数据
     * @author ChenWang
     * @date 2020/10/23 14:39
     */
    HeaderPage getHeaderPage(String username);
}
