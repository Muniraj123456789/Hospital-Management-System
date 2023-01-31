package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class doctor {
	
	String did,dname, specilist, appoint, doc_qual;
	    int droom;
	    void new_doctor()
	    {
	        Scanner input = new Scanner(System.in);
	        System.out.print("id(25,35,45,55,65,85):-");
	        did = input.nextLine();
	        System.out.print("name(muniraj(Heart),Elavarasan(Chi),Suresh(eye),ramu(sur),naven(Psy),vijay(Neu):-");
	        dname = input.nextLine();
	        System.out.print("specilization(Heart,child,eye,Surgery,Psychiatrists,Neurologists):-");
	        specilist = input.nextLine();
	        System.out.print("work time(24/7):-");
	        appoint = input.nextLine();
	        System.out.print("qualification:-");
	        doc_qual = input.nextLine();
	        System.out.print("room no(heart(12),child(56),eye(1),Surgery(3),Psychiatrists(8),Neurologists(7)):-");
	        droom = input.nextInt();
	    
	        
	        
	 Connection con ;
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/munirajproject", "root", "Root");
				
				PreparedStatement stmt= con.prepareStatement("INSERT INTO doctor VALUES(?,?,?,?,?,?)");
				stmt.setString(1,did);
				stmt.setString(2, dname);
				stmt.setString(3,specilist);
				stmt.setString(4, appoint);
				stmt.setString(5, doc_qual);
				stmt.setInt(6, droom);
				stmt.executeUpdate();
				con.close();
		 }
		 catch(Exception e) {
				System.out.println(e);
		 
		 }
	
	
	    }
	    void doctor_info()
	    {
	        System.out.println(did + "\t" + dname + "  \t" + specilist + "     \t" + appoint + "    \t" + doc_qual + "       \t" + droom);
	    }

}