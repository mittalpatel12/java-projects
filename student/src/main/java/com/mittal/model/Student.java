package com.mittal.model;

public class Student {
    private int Id;
    private String Fname;
    private String Lname;
    private String Class1;
    private int Marks;

    public Student(int id, String fname, String lname, String class1, int marks) {
        Id = id;
        Fname = fname;
        Lname = lname;
        Class1 = class1;
        Marks = marks;
    }

    public int getId() {
        return Id;
    }

    public String getFname() {
        return Fname;
    }

    public String getLname() {
        return Lname;
    }

    public String getClass1() {
        return Class1;
    }

    public int getMarks() {
        return Marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", Fname='" + Fname + '\'' +
                ", Lname='" + Lname + '\'' +
                ", Class1='" + Class1 + '\'' +
                ", Marks=" + Marks +
                '}';
    }
}
