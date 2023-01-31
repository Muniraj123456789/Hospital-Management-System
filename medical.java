package project;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class medical {

	String med_name, med_comp, exp_date;
	int med_cost, count;

	void new_medi() {
		Scanner input = new Scanner(System.in);
		System.out.print("name:-");
		med_name = input.nextLine();
		System.out.print("comp:-");
		med_comp = input.nextLine();
		System.out.print("exp_date:-");
		exp_date = input.nextLine();
		System.out.print("cost:-");
		med_cost = input.nextInt();
		System.out.print("no of unit:-");
		count = input.nextInt();

		// connecting to the database
		Connection con;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/munirajproject", "root", "Root");
			PreparedStatement st = con.prepareStatement("INSERT INTO medical VALUES(?,?,?,?,?)");
			st.setString(1, med_name);
			st.setString(2, med_comp);
			st.setString(3, exp_date);
			st.setInt(4, med_cost);
			st.setInt(5, count);
			st.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	void find_medi() {
		System.out.println(med_name + "  \t" + med_comp + "    \t" + exp_date + "     \t" + med_cost);
	}

}