import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The Main class provides a console-based interface for managing student data.
 * Users can add, retrieve, update, and delete student records.
 *
 * @author Nirupam Reddy Nannuri
 */

public class Main {

    /**
     * The main method is the entry point of the application.
     * It provides a menu for users to perform CRUD operations on student data.
     *
     */
    public static void main(String[] args) {
        Student student = new Student();
        Scanner in = new Scanner(System.in);
        char selection;
        do {
            System.out.print("(C) Add New Student Data \n" +
                    "(R) Retrieve Existing Student Data \n" +
                    "(U) Update Existing Student Data \n" +
                    "(D) Delete Existing Student Data \n" +
                    "(Q) Quit \n\n" +
                    "Enter your selection: ");
            selection = in.next().toUpperCase().charAt(0);
            in.nextLine();
            switch (selection) {
                case 'C':
                    System.out.println();
                    try {
                        System.out.print("Enter Student ID: ");
                        int id = in.nextInt();
                        if (id <= 0) {
                            throw new IdInvalidException("Student ID should be greater than 0");
                        }
                        in.nextLine();
                        System.out.print("Enter Student Name: ");
                        String name = in.nextLine();
                        System.out.print("Enter Student Age: ");
                        int age = in.nextInt();
                        if (age <= 0) {
                            throw new InvalidAgeException("Student Age should be greater than 0");
                        }
                        in.nextLine();
                        System.out.print("Enter Student Gender: ");
                        String gender = in.next();
                        in.nextLine();
                        System.out.print("Enter Student Email: ");
                        String email = in.next();
                        in.nextLine();
                        System.out.print("Enter Student Phone Number: ");
                        String phoneNumber = in.next();
                        in.nextLine();
                        System.out.print("Enter Student Address: ");
                        String address = in.nextLine();
                        Student studentData = new Student(id, name, age, gender,
                                email, phoneNumber, address);
                        student.addStudent(studentData);
                        System.out.println();
                        System.out.println("Student Added Successfully");
                        System.out.println();
                    } catch (IdInvalidException | InvalidAgeException | SQLException e) {
                        System.out.println();
                        System.out.println(e.getMessage());
                        in.nextLine();
                        System.out.println();
                    } catch (InputMismatchException e){
                        System.out.println();
                        System.out.println("Invalid! Must be a number");
                        in.nextLine();
                        System.out.println();
                    }
                    break;
                case 'R':
                    System.out.println();
                    System.out.print("Enter Student ID: ");
                    try {
                        int id = in.nextInt();
                        if (id <= 0) {
                            throw new IdInvalidException("Student ID should be greater than 0");
                        }
                        System.out.println();
                        student.format();
                        student.retrieveStudent(id);
                        System.out.println("Student Retrieved Successfully");
                        System.out.println();
                    } catch (IdInvalidException | SQLException e) {
                        System.out.println();
                        System.out.println(e.getMessage());
                        in.nextLine();
                        System.out.println();
                    } catch (InputMismatchException e){
                        System.out.println();
                        System.out.println("Invalid! Must be a number");
                        in.nextLine();
                        System.out.println();
                    }
                    break;
                case 'U':
                    System.out.println();
                    System.out.print("Enter Student ID: ");
                    try{
                        int studentId = in.nextInt();
                        if (studentId <= 0) {
                            throw new IdInvalidException("Student ID should be greater than 0");
                        }
                        in.nextLine();
                        System.out.println();
                        System.out.print("Which data field do you want to update?" +
                                " \n" +
                                "(I) Student ID \n" +
                                "(N) Student Name \n" +
                                "(A) Student Age \n" +
                                "(G) Student Gender \n" +
                                "(E) Student Email \n" +
                                "(P) Student Phone Number \n" +
                                "(J) Student Address \n" +
                                "(X) Update Entire Data for this Student " +
                                "\n\n" +
                                "Enter your selection: ");
                        char field = in.next().toUpperCase().charAt(0);
                        in.nextLine();
                        switch (field) {
                            case 'I':
                                System.out.println();
                                try {
                                    System.out.print("Enter New Student ID: ");
                                    int updatedStudentId = in.nextInt();
                                    if (updatedStudentId <= 0) {
                                        throw new IdInvalidException("Student ID should be greater than 0");
                                    }
                                    student.updateStudentId(updatedStudentId, studentId);
                                    System.out.println();
                                    System.out.println("Student Updated Successfully");
                                    System.out.println();
                                } catch (IdInvalidException | SQLException e) {
                                    System.out.println();
                                    System.out.println(e.getMessage());
                                    in.nextLine();
                                    System.out.println();
                                } catch (InputMismatchException e){
                                    System.out.println();
                                    System.out.println("Invalid! Must be a number");
                                    in.nextLine();
                                    System.out.println();
                                }
                                break;
                            case 'N':
                                System.out.println();
                                try {
                                    System.out.print("Enter New Name: ");
                                    String updatedStudentName = in.nextLine();
                                    student.updateStudentName(updatedStudentName, studentId);
                                    System.out.println();
                                    System.out.println("Student Updated Successfully");
                                    System.out.println();
                                } catch (SQLException e) {
                                    System.out.println();
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 'A':
                                System.out.println();
                                try {
                                    System.out.print("Enter New Age: ");
                                    int updatedStudentAge = in.nextInt();
                                    if (updatedStudentAge <= 0) {
                                        throw new InvalidAgeException("Student Age should be greater than 0");
                                    }
                                    student.updateStudentAge(updatedStudentAge, studentId);
                                    System.out.println();
                                    System.out.println("Student Updated Successfully");
                                    System.out.println();
                                } catch (InvalidAgeException | SQLException e) {
                                    System.out.println();
                                    System.out.println(e.getMessage());
                                    in.nextLine();
                                } catch (InputMismatchException e){
                                    System.out.println();
                                    System.out.println("Invalid! Must be a number");
                                    in.nextLine();
                                    System.out.println();
                                }
                                break;
                            case 'G':
                                System.out.println();
                                try {
                                    System.out.print("Enter New Gender: ");
                                    String updatedStudentGender = in.nextLine();
                                    student.updateStudentGender(updatedStudentGender, studentId);
                                    System.out.println();
                                    System.out.println("Student Updated Successfully");
                                    System.out.println();
                                } catch (SQLException e) {
                                    System.out.println();
                                    System.out.println(e.getMessage());
                                    System.out.println();
                                }
                                break;
                            case 'E':
                                System.out.println();
                                try {
                                    System.out.print("Enter New Email: ");
                                    String updatedStudentEmail = in.nextLine();
                                    student.updateStudentEmail(updatedStudentEmail, studentId);
                                    System.out.println();
                                    System.out.println("Student Updated Successfully");
                                    System.out.println();
                                } catch (SQLException e) {
                                    System.out.println();
                                    System.out.println(e.getMessage());
                                    System.out.println();
                                }
                                break;
                            case 'P':
                                System.out.println();
                                try {
                                    System.out.print("Enter New Phone Number: ");
                                    String updatedStudentPhoneNumber = in.nextLine();
                                    student.updateStudentPhoneNumber(updatedStudentPhoneNumber, studentId);
                                    System.out.println();
                                    System.out.println("Student Updated Successfully");
                                    System.out.println();
                                } catch (SQLException e) {
                                    System.out.println();
                                    System.out.println(e.getMessage());
                                    System.out.println();
                                }
                                break;
                            case 'J':
                                try {
                                    System.out.println();
                                    System.out.print("Enter New Address: ");
                                    String updatedStudentAddress = in.nextLine();
                                    student.updateStudentAddress(updatedStudentAddress, studentId);
                                    System.out.println();
                                    System.out.println("Student Updated Successfully");
                                    System.out.println();
                                } catch (SQLException e) {
                                    System.out.println();
                                    System.out.println(e.getMessage());
                                    System.out.println();
                                }
                                break;
                            case 'X':
                                try {
                                    System.out.println();
                                    System.out.print("Enter New Student ID: ");
                                    int id = in.nextInt();
                                    if (id <= 0) {
                                        throw new IdInvalidException("Student ID should be greater than 0");
                                    }
                                    in.nextLine();
                                    System.out.print("Enter Student Name: ");
                                    String name = in.nextLine();
                                    System.out.print("Enter Student Age: ");
                                    int age = in.nextInt();
                                    if (age <= 0) {
                                        throw new InvalidAgeException("Student Age should be greater than 0");
                                    }
                                    in.nextLine();
                                    System.out.print("Enter Student Gender: ");
                                    String gender = in.nextLine();
                                    System.out.print("Enter Student Email: ");
                                    String email = in.nextLine();
                                    System.out.print("Enter Student Phone Number: ");
                                    String phoneNumber = in.nextLine();
                                    System.out.print("Enter Student Address: ");
                                    String address = in.nextLine();
                                    Student studentData = new Student(id, name, age, gender,
                                            email, phoneNumber, address);
                                    student.updateStudent(studentData);
                                } catch (IdInvalidException | InvalidAgeException | SQLException e) {
                                    System.out.println();
                                    System.out.println(e.getMessage());
                                    in.nextLine();
                                    System.out.println();
                                } catch (InputMismatchException e){
                                    System.out.println();
                                    System.out.println("Invalid! Must be a number");
                                    in.nextLine();
                                    System.out.println();
                                }
                        }
                    } catch (IdInvalidException e){
                        System.out.println();
                        System.out.println(e.getMessage());
                        in.nextLine();
                        System.out.println();
                    } catch (InputMismatchException e) {
                        System.out.println();
                        System.out.println("Invalid! Must be a number");
                        in.nextLine();
                        System.out.println();
                    }
                    break;
                case 'D':
                    System.out.println();
                    System.out.print("Enter Student ID: ");
                    try {
                        int studentIdToDelete = in.nextInt();
                        if (studentIdToDelete <= 0) {
                            throw new IdInvalidException("Student ID should " +
                                    "be greater than 0");
                        }
                        in.nextLine();
                        student.deleteStudent(studentIdToDelete);
                        System.out.println();
                        System.out.println("Student Deleted Successfully");
                        System.out.println();
                    } catch (IdInvalidException | SQLException e) {
                        System.out.println();
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'Q':
                    System.out.println();
                    System.out.println("Programming terminating");
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid selection");
                    System.out.println();
                    break;
            }
        } while (selection != 'Q');
    }
}