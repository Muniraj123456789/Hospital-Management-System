package project;


import java.sql.*;
import java.util.Scanner;

public class lab {
	 String fecility;
	    int lab_cost;
	    
	    void new_feci()
	    {
	        Scanner input = new Scanner(System.in);
	        System.out.print("fecility(X_ray,MRI,CBC,etc...):-");
	        fecility = input.nextLine();
	        System.out.print("cost:-");
	        lab_cost = input.nextInt();
	        
	        //JDBC Code
	        Connection con;
	        try{  
	        	Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/munirajproject", "root", "Root");
				PreparedStatement st = con.prepareStatement("INSERT INTO lab VALUES(?,?)");
				st.setString(1, fecility);
				st.setInt(2, lab_cost);
				
				st.executeUpdate();
				con.close(); 
				}catch(Exception e){ 
					System.out.println(e);}  
				
	    }
	    void feci_list()
	    {
	        System.out.println(fecility + "\t\t" + lab_cost);
	    }
	}
	class fecility //Sorry Facility but do not change the name 
	{
	    String fec_name;
	    void add_feci()
	    {
	        Scanner input = new Scanner(System.in);
	        System.out.print("fecility:-");
	        fec_name = input.nextLine();
	        
	        //JDBC Code
	        try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con = DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/munirajproject","username","password");  
				//here lab is database name, username and password  
				Statement stmt=con.createStatement();  
				String sql = "INSERT INTO lab_facility VALUES(fec_name)";
				ResultSet rs = stmt.executeQuery(sql);  
				con.close();  
				}catch(Exception e){ System.out.println(e);}  
	    }
	    void show_feci()
	    {
	        System.out.println(fec_name);
	    }

}