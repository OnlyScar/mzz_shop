package com.mzz.shop.service.impl;

import org.hibernate.Session;

import com.mzz.shop.model.Category;
import com.mzz.shop.service.CategoryService;

import mzz.shop.test.HibernateSessionFactory;

public class CategoryServiceImpl implements CategoryService {

	
	
	@Override
	public void save(Category category) {
		//通过刚刚生成的sessionFactory获取session
        Session session = HibernateSessionFactory.getSession();
        try {
            //手动事务
            session.getTransaction().begin();
            //执行业务逻辑
            session.save(category);
            //手动提交
            session.getTransaction().commit();
        } catch(Exception e) {
            session.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            HibernateSessionFactory.closeSession();
        }       

	}

}
