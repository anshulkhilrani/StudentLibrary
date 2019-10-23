package StudentLibrary;

import java.util.*;

public class Student {
    String studentName;
    String regNum;

    Books[] borrowedBooks = new Books[3];
    public int booksCount = 0;
    
    Scanner input = new Scanner(System.in);
    
    public void student() {

        System.out.println("Enter Student Name:");
        this.studentName = input.nextLine();

        System.out.println("Enter Reg Number:");
        this.regNum = input.nextLine();

    }
}