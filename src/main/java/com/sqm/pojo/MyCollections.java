package com.sqm.pojo;

import java.util.*;

/**
 * <p>
 *     集合注入
 * </p>
 *
 * @author sqm
 * @version 1.0
 */
public class MyCollections {
    //数组
    private String[] strings;
    //List
    private List<Student> students;
    //set
    private Set<String> mySet;
    //map
    private Map<String,Integer> myMap;
    //properties
    private Properties properties;

    //setter
    //toStrings;
    public void setStrings(String[] strings) {
        this.strings = strings;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, Integer> myMap) {
        this.myMap = myMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "MyCollections{" +
                "strings=" + Arrays.toString(strings) +
                ", students=" + students +
                ", mySet=" + mySet +
                ", myMap=" + myMap +
                ", properties=" + properties +
                '}';
    }
}
