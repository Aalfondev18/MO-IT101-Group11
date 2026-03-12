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
