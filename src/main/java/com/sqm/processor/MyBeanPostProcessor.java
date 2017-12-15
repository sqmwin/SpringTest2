package com.sqm.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>
 * bean后处理类
 * </p>
 *
 * @author sqm
 * @version 1.0
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean后处理器执行postProcessBeforeInitialization()");
        //即使不用这种方法增强,也要返回原bean,传递bean对象,不能是默认的null
        return bean;
    }

    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        System.out.println("bean后处理器执行postProcessAfterInitialization()");
        //如果要调用的bean名字为studentService则加强bean
        if ("studentService".equals(beanName)) {
            //通过动态代理加强
            Object proxy = Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    //加强some方法
                    if ("some".equals(method.getName())) {
                        System.out.println("目标方法执行开始时间:" + System.currentTimeMillis());
                        Object result = method.invoke(bean, args);
                        System.out.println("目标方法执行结束时间:" + System.currentTimeMillis());
                        return result;
                    } else {
                        //其他方法不加强
                        return method.invoke(bean, args);
                    }
                }
            });
            //若为studentService则启用动态代理且返回加强后的对象proxy
            return proxy;
        }
        //其他bean返回原本bean对象
        return bean;
    }
}
