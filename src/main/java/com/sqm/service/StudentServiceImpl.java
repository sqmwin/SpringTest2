package com.sqm.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;

/**
 * <p>
 * 执行业务类之学生
 * </p>
 *
 * @author sqm
 * @version 1.0
 */
public class StudentServiceImpl implements IService,BeanNameAware,BeanFactoryAware,DisposableBean{
    public void some() {
        System.out.println(this.getClass().getSimpleName() + " do some()");
    }

    public void other() {
        System.out.println(this.getClass().getSimpleName() + " do other()");
    }

    private void setUp() {
        System.out.println("init-method初始化完毕");
    }

    private void tearDown() {
        System.out.println("destroy-method销毁");
    }

    public void setBeanName(String name) {
        System.out.println("实现了BeanNameAware接口 " + name);
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("实现了BeanFactoryAware接口 " + beanFactory);
    }

    public void destroy() throws Exception {
        System.out.println("实现了DispoableBean接口");
    }
}
