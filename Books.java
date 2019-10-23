package StudentLibrary;

import java.util.Scanner;



public class Books{

public int sNo;
public String bookName;
public String authorName;
public int bookQty;
public int bookQtyCopy;

Scanner input = new Scanner(System.in);

public void book(){

    System.out.println("Enter Serial No of Book:");
    this.sNo = input.nextInt();
    input.nextLine();
    System.out.println("Enter Book Name:");
    this.bookName = input.nextLine();
    System.out.println("Enter Author Name:");
    this.authorName = input.nextLine();
    System.out.println("Enter Quantity of Books:");
    this.bookQty = input.nextInt();
    bookQtyCopy = this.bookQty;

}

public static class Library{
	static Books[] theBooks = new Books[50];
public static int count;    

Scanner input = new Scanner(System.in);


public int compareBookObjects(Books b1, Books b2){

    if (b1.bookName.equalsIgnoreCase(b2.bookName)){

        System.out.println("Book of this Name Already Exists.");
        return 0;

    }
    if (b1.sNo==b2.sNo){

        System.out.println("Book of this Serial No Already Exists.");
        return 0;
    }
    return 1;
}

public void addBook(Books b){

    for (int i=0; i<count; i++){

        if (this.compareBookObjects(b, this.theBooks[i]) == 0)
            return;

    }

    if (count<50){

        theBooks[count] = b;
        count++;

    }
    else{

        System.out.println("No Space to Add More Books.");

    }

}

public void searchBySno(){

    System.out.println("\t\t\t\tSEARCH BY SERIAL NUMBER\n");

    int sNo;
    System.out.println("Enter Serial No of Book:");
    sNo = input.nextInt();

    int flag = 0;
    System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
    for (int i=0; i<count; i++){

        if (sNo == theBooks[i].sNo){

            System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" + 
                theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty);
            flag++;
            return;

        }

    }
    if (flag == 0)
        System.out.println("No Book for Serial No " + sNo + " Found.");

}

public void searchByAuthorName(){

    System.out.println("\t\t\t\tSEARCH BY AUTHOR'S NAME");
    input.nextLine();
    System.out.println("Enter Author Name:");
    String authorName = input.nextLine();
    int flag = 0;
    System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
    for (int i=0; i<count; i++){

        if (authorName.equalsIgnoreCase(theBooks[i].authorName)){

            System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" + 
                theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty);
            flag++;
        }

    }
    if (flag == 0)
        System.out.println("No Books of " + authorName + " Found.");

}




public void upgradeBookQty(){

    System.out.println("\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
    System.out.println("Enter Serial No of Book");
    int sNo = input.nextInt();
    for (int i=0; i<count; i++){

        if (sNo == theBooks[i].sNo){

            System.out.println("Enter No of Books to be Added:");
            int addingQty = input.nextInt();
            theBooks[i].bookQty += addingQty;
            theBooks[i].bookQtyCopy += addingQty;
            return;

        }

    }

}


public void dispMenu(){

    System.out.println("----------------------------------------------------------------------------------------------------------");
    System.out.println("Enter 0 to Exit Application.");
    System.out.println("Enter 1 to Add new Book.");
    System.out.println("Enter 2 to Upgrade Quantity of a Book.");
    System.out.println("Enter 3 to Search a Book.");
    System.out.println("Enter 4 to Show All Books.");
    System.out.println("Enter 5 to Register Student.");
    System.out.println("Enter 6 to Show All Registered Students.");
    System.out.println("Enter 7 to Check Out Book. ");
    System.out.println("Enter 8 to Check In Book");
    System.out.println("---------------------------------------------------------------------------------------------------------");

}

public int isAvailable(int sNo){




    for (int i=0; i<count; i++){

        if (sNo == theBooks[i].sNo){
            if(theBooks[i].bookQtyCopy > 0){

                System.out.println("Book is Available.");
                return i;

            }
            System.out.println("Book is Unavailable");
            return -1;

        }

    }

    System.out.println("No Book of Serial Number " + " Available in Library.");
    return -1;


}

public Books checkOutBook(){

    System.out.println("Enter Serial No of Book to be Checked Out.");
    int sNo = input.nextInt();

    int bookIndex =isAvailable(sNo);

    if (bookIndex!=-1){

       
        theBooks[bookIndex].bookQtyCopy--;

        return theBooks[bookIndex];
    }

    return null;

}

public static void checkInBook(Books b){

    for (int i=0; i<count; i++){

        if (b.equals(theBooks[i]) ){

            theBooks[i].bookQtyCopy++;
            return;

        }

    }

}
}

public static void showAllBooks() {
    System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
    System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
    for (int i=0; i<count; i++){

        System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" + 
                theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty);


    }
}}



