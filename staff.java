package project;

import java.sql.*;
import java.util.Scanner;

public class staff {
    String sid, sname, desg, sex;
    int salary;

    void new_staff(){
        Scanner input = new Scanner(System.in);
        System.out.print("id:-");
        sid = input.nextLine();
        System.out.print("name:-");
        sname = input.nextLine();
        System.out.print("desigination(doctor,attender,vadboy,security,driver,narse):-");
        desg = input.nextLine();
        System.out.print("sex(Male,Female,transgender):-");
        sex = input.nextLine();
        System.out.print("salary:-");
        salary = input.nextInt();

        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");

            
            String url = "jdbc:mysql://localhost:3306/munirajproject";
            Connection con = DriverManager.getConnection(url,"root","Root");
            Statement stmt = con.createStatement();           
            String query = "INSERT INTO staff(sid, sname, desg, sex, salary) VALUES('"+sid+"','"+sname+"','"+desg+"','"+sex+"','"+salary+"')";
            int res = stmt.executeUpdate(query);

            if(res == 1){
                System.out.println("Staff record added successfully");
            }
            else{
                System.out.println("Error in adding staff record");
            }

           
            con.close();

        }
        catch(Exception e){
            System.out.println("Error in connecting to the database");
            e.printStackTrace();
        }
    }

    void staff_info(){
        System.out.println(sid + "\t" + sname + "\t" + sex + "\t" + salary);
    }

}