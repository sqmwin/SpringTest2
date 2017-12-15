package com.sqm.pojo;

/**
 * <p>
 *     SchoolBean
 * </p>
 *
 * @author sqm
 * @version 1.0
 */
public class School {
    private String name;

    public School() {
    }

    public School(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                '}';
    }
}
