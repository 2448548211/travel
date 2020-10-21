package com.xlibaba.travel.dao.impl;

import com.xlibaba.travel.dao.IRouteImgDao;
import com.xlibaba.travel.entity.RouteImg;
import com.xlibaba.travel.util.myutils.DaoGeneraUtils;

import java.util.List;

/**
 * @program: travel
 * @author: hzx
 * @since: JDK 1.8
 * @create: 2020-10-21 13:56
 **/
public class RouteImgDaoImpl implements IRouteImgDao {

    DaoGeneraUtils<RouteImg> daoUtil = new DaoGeneraUtils<>(RouteImg.class);

    @Override
    public List<RouteImg> selectRouteImgById(int id) {
        String sql = "SELECT * FROM tab_Route_Img WHERE is_del=0 AND rid="+id;
        return daoUtil.selectSql(sql);
    }
}
