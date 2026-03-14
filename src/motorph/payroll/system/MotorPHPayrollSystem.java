import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MotorPHPayrollSystem {

    public static void main(String[] args) {

        // Scanner used for user input
        Scanner input = new Scanner(System.in);

        String username;
        String password;

        // Ask user to enter username
        System.out.print("Enter username: ");
        username = input.nextLine();

        // Ask user to enter password
        System.out.print("Enter password: ");
        password = input.nextLine();

        // Check if login credentials are correct
        if((username.equals("employee") || username.equals("payroll_staff")) && password.equals("12345")){

            // If user logs in as employee
            if(username.equals("employee")){

                // Show employee menu
                System.out.println("1. Enter Employee Number");
                System.out.println("2. Exit");

                int choice = input.nextInt();

                // If user chooses option 1
                if(choice == 1){

                    // Ask for employee number
                    System.out.print("Enter employee number: ");
                    int empNumber = input.nextInt();

                    try{

                        // Open the CSV file
                        File file = new File("employees.csv");

                        // Scanner used to read the file
                        Scanner fileReader = new Scanner(file);

                        // Variable to check if employee exists
                        boolean found = false;

                        // Loop through each line of the CSV file
                        while(fileReader.hasNextLine()){

                            // Read one line
                            String line = fileReader.nextLine();

                            // Split the line using comma
                            String data[] = line.split(",");

                            // Skip invalid rows
                            if(data.length < 12){
                                continue;
                            }

                            // Convert employee number from CSV to integer
                            int fileEmpNum = Integer.parseInt(data[0]);

                            // Check if employee number matches input
                            if(empNumber == fileEmpNum){

                                found = true;

                                // Display employee information
                                System.out.println("\nEmployee #: " + data[0]);
                                System.out.println("Employee Name: " + data[1]);
                                System.out.println("Birthday: " + data[2]);

                                // First cutoff payroll
                                System.out.println("\nCutoff Date: June 1 to June 15");
                                System.out.println("Total Hours Worked: " + data[3]);
                                System.out.println("Gross Salary: " + data[4]);
                                System.out.println("Net Salary: " + data[5]);

                                // Second cutoff payroll
                                System.out.println("\nCutoff Date: June 16 to June 30");
                                System.out.println("Total Hours Worked: " + data[6]);
                                System.out.println("Gross Salary: " + data[7]);

                                // Government deductions
                                System.out.println("SSS: " + data[8]);
                                System.out.println("PhilHealth: " + data[9]);
                                System.out.println("PagIBIG: " + data[10]);
                                System.out.println("Tax: " + data[11]);

                                // Calculate total deductions
                                double deductions =
                                        Double.parseDouble(data[8]) +
                                        Double.parseDouble(data[9]) +
                                        Double.parseDouble(data[10]) +
                                        Double.parseDouble(data[11]);

                                System.out.println("Total Deductions: " + deductions);

                                // Calculate net salary
                                double netSalary = Double.parseDouble(data[7]) - deductions;

                                System.out.println("Net Salary: " + netSalary);
                            }
                        }

                        // If employee number was not found
                        if(!found){
                            System.out.println("Employee number does not exist.");
                        }

                        // Close file reader
                        fileReader.close();

                    }catch(FileNotFoundException e){

                        // Error message if CSV file is missing
                        System.out.println("employees.csv file not found.");
                    }

                }else{

                    // If user selects exit
                    System.out.println("Program terminated.");
                }
            }

        }else{

            // If login credentials are incorrect
            System.out.println("Incorrect username and/or password.");
        }

        // Close scanner
        input.close();
    }
}