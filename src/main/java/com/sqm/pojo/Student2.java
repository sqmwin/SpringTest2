package com.sqm.pojo;

/**
 * <p>
 *     Student2Bean
 * </p>
 *
 * @author sqm
 * @version 1.0
 */
public class Student2 {


    private String studentName;
    private int studentAge;
    private School school;
    private String country;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "studentName='" + studentName + '\'' +
                ", studentAge=" + studentAge +
                ", school=" + school +
                ", country='" + country + '\'' +
                '}';
    }
}
