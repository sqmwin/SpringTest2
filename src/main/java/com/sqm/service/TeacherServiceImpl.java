package com.sqm.service;

/**
 * <p>
 * 执行业务类之老师
 * </p>
 *
 * @author sqm
 * @version 1.0
 */
public class TeacherServiceImpl implements IService {
    public void some() {
        System.out.println(this.getClass().getSimpleName() + " do some()");
    }

    public void other() {
        System.out.println(this.getClass().getSimpleName() + " do other()");
    }
}
