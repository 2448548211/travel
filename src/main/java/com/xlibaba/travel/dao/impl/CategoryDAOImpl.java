package com.xlibaba.travel.dao.impl;

import com.xlibaba.travel.dao.ICategoryDAO;
import com.xlibaba.travel.entity.Category;
import com.xlibaba.travel.util.myutils.DBUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChenWang
 * @className CategoryDAOImpl
 * @date 2020/10/20 23:14
 * @since JDK 1.8
 */
public class CategoryDAOImpl implements ICategoryDAO {
    @Override
    public List<String> selectAll() {
        List<String> list = new ArrayList<>();
        String sql = "SELECT cid,cname FROM tab_category WHERE is_del = 1 ORDER BY cid";
        List<Category> categories = DBUtil.getDbUtil().excuteQuery(sql,Category.class);
        categories.forEach(item-> list.add(item.getCname()));
        return list;
    }
}
