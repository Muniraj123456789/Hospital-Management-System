package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class patient {
	String pid, pname, disease, sex, admit_status;
	int age;

	void new_patient() {
		Scanner input = new Scanner(System.in);
		System.out.print("id:-");
		pid = input.nextLine();
		System.out.print("name:-");
		pname = input.nextLine();
		System.out.print("disease:-");
		disease = input.nextLine();
		System.out.print("sex(Male,Female,transgender):-");
		sex = input.nextLine();
		System.out.print("admit_status(normal,serious):-");
		admit_status = input.nextLine();
		System.out.print("age:-");
		age = input.nextInt();

		Connection con;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/munirajproject", "root", "Root");
			PreparedStatement st = con.prepareStatement("INSERT INTO patient VALUES(?,?,?,?,?,?)");
			st.setString(1, pid);
			st.setString(2, pname);
			st.setString(3, disease);
			st.setString(4, sex);
			st.setString(5, admit_status);
			st.setInt(6, age);
			st.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	void patient_info() {
		System.out.println(pid + "\t" + pname + " \t" + disease + "     \t" + sex + "      \t" + admit_status + "\t" + age);
	}

}