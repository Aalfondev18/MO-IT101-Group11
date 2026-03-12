


import java.io.*;
import java.util.*;

public class MotorPHPayrollSystem {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("===== Payroll System Login =====");

        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        if(!(password.equals("12345") && (username.equals("employee") || username.equals("payroll_staff")))){
            System.out.println("Incorrect username and/or password.");
            return;
        }

        if(username.equals("employee")){
            employeeMenu();
        } else {
            payrollMenu();
        }
    }

    static void employeeMenu(){

        System.out.println("\n1. Enter Employee Number");
        System.out.println("2. Exit");

        int choice = sc.nextInt();
        sc.nextLine();

        if(choice == 1){

            System.out.print("Enter employee number: ");
            String empNum = sc.nextLine();

            boolean found = false;

            try{
                BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
                String line;

                while((line = br.readLine()) != null){

                    String[] data = line.split(",");

                    if(data[0].equals(empNum)){

                        found = true;

                        System.out.println("\nEmployee #: " + data[0]);
                        System.out.println("Employee Name: " + data[1]);
                        System.out.println("Birthday: " + data[2]);

                        System.out.println("\nCutoff Date: June 1 to June 15");
                        System.out.println("Total Hours Worked: " + data[3]);
                        System.out.println("Gross Salary: " + data[4]);
                        System.out.println("Net Salary: " + data[5]);

                        System.out.println("\nCutoff Date: June 16 to June 30");
                        System.out.println("Total Hours Worked: " + data[6]);
                        System.out.println("Gross Salary: " + data[7]);

                        System.out.println("SSS: " + data[8]);
                        System.out.println("PhilHealth: " + data[9]);
                        System.out.println("Pag-IBIG: " + data[10]);
                        System.out.println("Tax: " + data[11]);

                    