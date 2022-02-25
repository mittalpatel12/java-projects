package com.mittal.model;

import java.sql.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Dboperations {

    public static void main(String[] args) throws ClassNotFoundException {
        Connection c = null;
        Statement stmt = null;
        System.out.println("Successfull");

        LinkedList<String> listOfValues = new LinkedList<>();
        Student s;

        try {
            Class.forName("org.postgresql.Driver");

            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/student-db", "postgres", "");

            stmt = c.createStatement();

            String sql = "SELECT * FROM student"; /*where first_name = 'chintan'*/

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                /*System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("first_name"));*/
                int id = rs.getInt("id");
                String fname = rs.getString("first_name");
                String lname = rs.getString("last_name");
                String class1 = rs.getString("class");
                int marks = rs.getInt("marks");

                s = new Student(id, fname, lname, class1, marks);
                listOfValues.add(s.toString());

            }
        //insert data from command line to existing database
            System.out.println("Do you want to Insert Data... \n 1: yes\n 2: No");
            Scanner sc = new Scanner(System.in);
            boolean decision;
            System.out.println("boolean value");
            decision= sc.nextBoolean();
            while (decision) {
                System.out.println("Data");
                int cmdId = sc.nextInt();
                String cmdFname = sc.next();
                String cmdLname = sc.next();
                String cmdClass = sc.next();
                int cmdMarks = sc.nextInt();

                String insertQuery = "INSERT INTO student (id, first_name, last_name, class, marks) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement prStmt = c.prepareStatement(insertQuery);
                prStmt.setInt(1, cmdId);
                prStmt.setString(2, cmdFname);
                prStmt.setString(3, cmdLname);
                prStmt.setString(4, cmdClass);
                prStmt.setInt(5,cmdMarks);
                /*System.out.println(cmdId);
                System.out.println(cmdFname);
                System.out.println(cmdLname);
                System.out.println(cmdClass);
                System.out.println(cmdMarks);*/
                int rowsInserted = prStmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new user was inserted successfully!");
                }
                decision= sc.nextBoolean();
            };

            rs.close();
            stmt.close();
            c.close();
        } catch(Exception e) {

            System.out.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);

        }

        for (String listData : listOfValues)
            System.out.println(listData);

    }

}
