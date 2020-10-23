package com.xlibaba.travel.service;

import com.xlibaba.travel.service.page.IndexPage;
import com.xlibaba.travel.service.page.IndexTopPage;

/**
 * @author ChenWang
 * @interfaceName IIndexService
 * @date 2020/10/21 10:14
 * @since JDK 1.8
 */
public interface IIndexService {
    /**
     * 获取首页数据
     * @return  IndexPage   首页数据
     * @author ChenWang
     * @date 2020/10/23 14:38
     */
    IndexPage getIndexPage();
    /**
     * 获取首页精选导航数据
     * @return   IndexTopPage   首页精选导航数据
     * @author ChenWang
     * @date 2020/10/23 14:38
     */
    IndexTopPage getIndexTopPage();
}
