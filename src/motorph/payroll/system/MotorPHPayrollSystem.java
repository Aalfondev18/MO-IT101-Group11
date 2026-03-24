import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MotorPHPayrollSystem {

    public static void main(String[] args) {
        // Start the program by handling login
        handleLogin();
    }

    // Handles user login and directs to correct menu
    public static void handleLogin() {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        // Validate credentials before allowing access
        if((username.equals("employee") || username.equals("payroll_staff")) && password.equals("12345")){

            if(username.equals("employee")){
                employeeMenu(input);
            } else {
                System.out.println("Payroll staff menu not yet implemented.");
            }

        } else {
            System.out.println("Incorrect username and/or password.");
        }
    }

    // Displays employee options and collects input
    public static void employeeMenu(Scanner input){

        System.out.println("\n1. Enter Employee Number");
        System.out.println("2. Exit");

        int choice = input.nextInt();

        if(choice == 1){

            System.out.print("Enter employee number: ");
            int empNumber = input.nextInt();

            // Search for employee and display payroll
            findEmployee(empNumber);

        } else {
            System.out.println("Program terminated.");
        }
    }

    // Reads the CSV file and finds the matching employee
    public static void findEmployee(int empNumber){

        try{

            File file = new File("employees.csv");
            Scanner fileReader = new Scanner(file);

            boolean found = false;

            // Loop through all records to find matching employee number
            while(fileReader.hasNextLine()){

                String line = fileReader.nextLine();
                String data[] = line.split(",");

                // Skip invalid or incomplete rows to avoid errors
                if(data.length < 12){
                    continue;
                }

                int fileEmpNum = Integer.parseInt(data[0]);

                if(empNumber == fileEmpNum){

                    found = true;

                    displayEmployee(data);
                }
            }

            if(!found){
                System.out.println("Employee number does not exist.");
            }

            fileReader.close();

        } catch(FileNotFoundException e){
            System.out.println("employees.csv file not found.");
        }
    }

    // Displays employee details and payroll breakdown
    public static void displayEmployee(String[] data){

        System.out.println("\nEmployee #: " + data[0]);
        System.out.println("Employee Name: " + data[1]);
        System.out.println("Birthday: " + data[2]);

        // First cutoff payroll (no deductions shown)
        System.out.println("\nCutoff Date: June 1 to June 15");
        System.out.println("Total Hours Worked: " + data[3]);
        System.out.println("Gross Salary: " + data[4]);
        System.out.println("Net Salary: " + data[5]);

        // Second cutoff payroll (includes deductions)
        System.out.println("\nCutoff Date: June 16 to June 30");
        System.out.println("Total Hours Worked: " + data[6]);
        System.out.println("Gross Salary: " + data[7]);

        // Display deductions
        System.out.println("SSS: " + data[8]);
        System.out.println("PhilHealth: " + data[9]);
        System.out.println("PagIBIG: " + data[10]);
        System.out.println("Tax: " + data[11]);

        // Calculate deductions separately for clarity
        double deductions = calculateDeductions(data);

        System.out.println("Total Deductions: " + deductions);

        // Compute final net salary
        double netSalary = Double.parseDouble(data[7]) - deductions;

        System.out.println("Net Salary: " + netSalary);
    }

    // Handles deduction computation to keep logic reusable and clean
    public static double calculateDeductions(String[] data){

        return Double.parseDouble(data[8])
                + Double.parseDouble(data[9])
                + Double.parseDouble(data[10])
                + Double.parseDouble(data[11]);
    }
}