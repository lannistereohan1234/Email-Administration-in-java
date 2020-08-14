package mails;
import java.util.Scanner;
import java.util.Random;

public class Email {
		Scanner s=new Scanner(System.in);
		
		private String fname;
		private String lname;
		private String dept;
		private String email;
		private String password;
		private int mailCapacity = 500;
		private String alter_email;
		
		public Email(String fname,String lname) {
			this.fname=fname;
			this.lname=lname;
			System.out.println("NEW EMPLOYEE "+ fname+ " "+lname);
			this.dept=this.setDept();
			this.email=this.generate_email();
			this.password=this.generate_password(8);
		}
		
		private String generate_email() {
			return this.fname.toLowerCase()+"."+this.lname.toLowerCase()+"@"+this.dept.toLowerCase()+".company.com";
		}
		
		private String generate_password(int length) {
			Random r=new Random();
			String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			String Small_chars = "abcdefghijklmnopqrstuvwxyz";
			String numbers = "0123456789";
			String symbols = "!@#$%&?";
			String values = Capital_chars + Small_chars + numbers + symbols;
			
			String password="";
			for(int i=0;i<length;i++) {
				password+=values.charAt(r.nextInt(values.length()));
			}
			return password;
		}
		
		private String setDept() {
			System.out.println(
					"DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None");
			boolean flag=false;
			do {
				System.out.println("Enter the code");
				int choice=s.nextInt();
				switch(choice) {
				case 1:	return "Sales";
				case 2: return "Development";
				case 3: return "Accounting";
				case 0: return "None";
				}
			}while(!flag);
			return null;
		}
		
		public void set_password() {
			boolean flag=false;
			do {
			System.out.print("ARE YOU SURE YOU WANT TO CHANGE YOUR PASSWORD? (Y/N) : ");
			char choice=s.next().charAt(0);
			if(choice=='Y' || choice=='y') {
				flag=true;
					System.out.println("enter current password");
					String temp=s.next();
					if(temp.equals(this.password)) {
						System.out.println("enter new password");
						this.password=s.next();
						System.out.println("password changed success");
					}else
						System.out.println("incorrect password");
			}else if(choice=='N' || choice=='n') {
				flag=true;
				System.out.println("password change cancelled");
			}else
				System.out.println("choose valid choice");
			}while(!flag);
		}
		
		public void set_mailCap() {
			System.out.println("Current capacity = " + this.mailCapacity + "mb");
			System.out.print("Enter new capacity: ");
			this.mailCapacity = s.nextInt();
			System.out.println("MAILBOX CAPACITY CHANGED SUCCESSFULLY!");
			
		}

		// Set the alternate email
		public void alternate_email() {
			System.out.print("Enter new alternate email: ");
			this.alter_email = s.next();
			System.out.println("ALTERNATE EMAIL SET SUCCESSFULLY!");
		}

		// Displaying the employee's information
		public void getInfo() {
			System.out.println("NAME: " + this.fname + " " + this.lname);
			System.out.println("DEPARTMENT: " + this.dept);
			System.out.println("EMAIL: " + this.email);
			System.out.println("PASSWORD: " + this.password);
			System.out.println("MAILBOX CAPACITY: " + this.mailCapacity + "mb");
			System.out.println("ALTER EMAIL: " + this.alter_email);
		}

}
