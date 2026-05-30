import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("     SMART STUDENT GRADE CALCULATOR");
        System.out.println("======================================");

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        String rollNo = sc.nextLine();

        System.out.print("Enter number of subjects: ");
        int subjects = Integer.parseInt(sc.nextLine());

        String[] subjectNames = new String[subjects];
        int[] marks = new int[subjects];

        int total = 0;

        for (int i = 0; i < subjects; i++) {
            System.out.print("\nEnter Subject " + (i + 1) + " Name: ");
            subjectNames[i] = sc.nextLine();

            while (true) {
                System.out.print("Enter marks in " + subjectNames[i] + " (0-100): ");
                int mark = Integer.parseInt(sc.nextLine());

                if (mark >= 0 && mark <= 100) {
                    marks[i] = mark;
                    total += mark;
                    break;
                } else {
                    System.out.println("Invalid marks! Please enter between 0 and 100.");
                }
            }
        }

        double average = (double) total / subjects;
        String grade;
        String message;

        if (average >= 90) {
            grade = "A+";
            message = "Outstanding Performance!";
        } else if (average >= 80) {
            grade = "A";
            message = "Excellent Work!";
        } else if (average >= 70) {
            grade = "B";
            message = "Very Good Performance!";
        } else if (average >= 60) {
            grade = "C";
            message = "Good, but keep improving.";
        } else if (average >= 40) {
            grade = "D";
            message = "Passed. Need more practice.";
        } else {
            grade = "F";
            message = "Failed. Work hard and try again.";
        }

        String result = average >= 40 ? "PASS" : "FAIL";

        System.out.println("\n\n======================================");
        System.out.println("            STUDENT REPORT CARD");
        System.out.println("======================================");
        System.out.println("Name        : " + name);
        System.out.println("Roll Number : " + rollNo);
        System.out.println("--------------------------------------");

        for (int i = 0; i < subjects; i++) {
            System.out.printf("%-15s : %d/100\n", subjectNames[i], marks[i]);
        }

        System.out.println("--------------------------------------");
        System.out.println("Total Marks : " + total + "/" + (subjects * 100));
        System.out.printf("Percentage  : %.2f%%\n", average);
        System.out.println("Grade       : " + grade);
        System.out.println("Result      : " + result);
        System.out.println("Remark      : " + message);
        System.out.println("======================================");

        sc.close();
    }
}