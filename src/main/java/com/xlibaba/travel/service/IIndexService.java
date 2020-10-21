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
    IndexPage getIndexPage();
    IndexTopPage getIndexTopPage();
}
