import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MotorPHPayrollSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String username;
        String password;

        System.out.print("Enter username: ");
        username = input.nextLine();

        System.out.print("Enter password: ");
        password = input.nextLine();

        if((username.equals("employee") || username.equals("payroll_staff")) && password.equals("12345")){

            if(username.equals("employee")){

                System.out.println("1. Enter Employee Number");
                System.out.println("2. Exit");

                int choice = input.nextInt();

                if(choice == 1){

                    System.out.print("Enter employee number: ");
                    int empNumber = input.nextInt();

                    try{

                        File file = new File("employees.csv");
                        Scanner fileReader = new Scanner(file);

                        boolean found = false;

                        while(fileReader.hasNextLine()){

                            String line = fileReader.nextLine();
                            String data[] = line.split(",");

                            int fileEmpNum = Integer.parseInt(data[0]);

                            if(empNumber == fileEmpNum){

                                found = true;

                                System.out.println("Employee #: " + data[0]);
                                System.out.println("Employee Name: " + data[1]);
                                System.out.println("Birthday: " + data[2]);

                                System.out.println("Cutoff Date: June 1 to June 15");
                                System.out.println("Total Hours Worked: " + data[3]);
                                System.out.println("Gross Salary: " + data[4]);
                                System.out.println("Net Salary: " + data[5]);

                                System.out.println("Cutoff Date: June 16 to June 30");
                                System.out.println("Total Hours Worked: " + data[6]);
                                System.out.println("Gross Salary: " + data[7]);

                                System.out.println("SSS: " + data[8]);
                                System.out.println("PhilHealth: " + data[9]);
                                System.out.println("PagIBIG: " + data[10]);
                                System.out.println("Tax: " + data[11]);

                                double deductions = Double.parseDouble(data[8])
                                        + Double.parseDouble(data[9])
                                        + Double.parseDouble(data[10])
                                        + Double.parseDouble(data[11]);

                                System.out.println("Total Deductions: " + deductions);

                                double net = Double.parseDouble(data[7]) - deductions;

                                System.out.println("Net Salary: " + net);
                            }
                        }

                        if(found == false){
                            System.out.println("Employee number does not exist.");
                        }

                        fileReader.close();

                    }catch(FileNotFoundException e){
                        System.out.println("File not found.");
                    }

                }else{
                    System.out.println("Program terminated.");
                }

            }

            if(username.equals("payroll_staff")){

                System.out.println("1. Process Payroll");
                System.out.println("2. Exit");

                int option = input.nextInt();

                if(option == 1){

                    System.out.println("1. One Employee");
                    System.out.println("2. All Employees");
                    System.out.println("3. Exit");

                    int subOption = input.nextInt();

                    if(subOption == 1){

                        System.out.print("Enter employee number: ");
                        int empNumber = input.nextInt();

                        try{

                            File file = new File("employees.csv");
                            Scanner fileReader = new Scanner(file);

                            boolean found = false;

                            while(fileReader.hasNextLine()){

                                String line = fileReader.nextLine();
                                String data[] = line.split(",");

                                int fileEmpNum = Integer.parseInt(data[0]);

                                if(empNumber == fileEmpNum){

                                    found = true;

                                    System.out.println("Employee #: " + data[0]);
                                    System.out.println("Employee Name: " + data[1]);
                                    System.out.println("Birthday: " + data[2]);

                                }
                            }

                            if(found == false){
                                System.out.println("Employee number does not exist.");
                            }

                            fileReader.close();

                        }catch(FileNotFoundException e){
                            System.out.println("File not found.");
                        }

                    }

                    if(subOption == 2){

                        try{

                            File file = new File("employees.csv");
                            Scanner fileReader = new Scanner(file);

                            while(fileReader.hasNextLine()){

                                String line = fileReader.nextLine();
                                String data[] = line.split(",");

                                System.out.println("Employee #: " + data[0]);
                                System.out.println("Employee Name: " + data[1]);
                                System.out.println("Birthday: " + data[2]);
                                System.out.println("----------------------");

                            }

                            fileReader.close();

                        }catch(FileNotFoundException e){
                            System.out.println("File not found.");
                        }

                    }

                }else{
                    System.out.println("Program terminated.");
                }

            }

        }else{
            System.out.println("Incorrect username and/or password.");
        }

    }
                        }

                    if(subOption == 2){

                        try{

                            File file = new File("employees.csv");
                            Scanner fileReader = new Scanner(file);

                            while(fileReader.hasNextLine()){

                                String line = fileReader.nextLine();
                                String data[] = line.split(",");

                                System.out.println("Employee #: " + data[0]);
                                System.out.println("Employee Name: " + data[1]);
                                System.out.println("Birthday: " + data[2]);
                                System.out.println("----------------------");

                            }

                            fileReader.close();

                        }catch(FileNotFoundException e){
                            System.out.println("File not found.");
                        }

                    }

                }else{
                    System.out.println("Program terminated.");
                }

            }

        }else{
            System.out.println("Incorrect username and/or password.");
        }

    }
}