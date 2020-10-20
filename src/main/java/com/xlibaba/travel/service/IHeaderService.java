package com.xlibaba.travel.service;

import com.xlibaba.travel.service.page.HeaderPage;

/**
 * @author ChenWang
 * @interfaceName IHeaderService
 * @date 2020/10/20 23:01
 * @since JDK 1.8
 */
public interface IHeaderService {
    HeaderPage getHeaderPage(String username);
}
