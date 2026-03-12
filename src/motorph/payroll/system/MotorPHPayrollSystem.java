/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package motorph.payroll.system;

/**
 *
 * @author alex
 */
public class MotorPHPayrollSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 //Alex logic
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

    }
    
}
