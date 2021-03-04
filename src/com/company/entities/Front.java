package com.company.entities;

import java.sql.Date;

public class Front {
    private int id;
    private String f_name;
    private int age;
    private Date started_working;
    private int level;
    private int salary;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getF_name() {
        return f_name;
    }
    public void setF_name(String f_name) {
        this.f_name = f_name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Date getStarted_working() {
        return started_working;
    }
    public void setStarted_working(Date started_working) {
        this.started_working = started_working;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Front(String f_name, int age, Date started_working, int level, int salary) {
        setF_name(f_name);
        setAge(age);
        setStarted_working(started_working);
        setLevel(level);
        setSalary(salary);
    }

    public Front(int id, String f_name, int age, Date started_working, int level, int salary) {
        setId(id);
        setF_name(f_name);
        setAge(age);
        setStarted_working(started_working);
        setLevel(level);
        setSalary(salary);
    }

    @Override
    public String toString() {
        return "Front{" +
                "id=" + id +
                ", f_name='" + f_name + '\'' +
                ", age=" + age +
                ", started_working=" + started_working +
                ", level=" + level +
                ", salary=" + salary +
                '}' + '\n';
    }
}
