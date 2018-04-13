package me.afua;

import java.util.Scanner;

public class Main {
    //Creates a class variable which will always be available, so that you can keep track of the ID. You won't
    //need this for Spring, though!
    private static int ID=1;

    public static void main(String[] args) {
        //This application uses methods instead of having everything in main
        Scanner keyboard = new Scanner(System.in);
        Library thisLibrary = new Library();
        boolean stop=false;
        String exit;

        //Show the menu
        do{

        if(thisLibrary.getBooks().size()<1)
        {
            System.out.println("Read through the code in this project and complete the solution! Have fun. ☺");
            System.out.println("There are no books in this library. Please add one");
            addBook(thisLibrary);
        }

        else{
            System.out.println(showMenu());
            getInput(keyboard,thisLibrary);
        }
        }while(!stop);

    }

    public static String showMenu()
    {
           StringBuilder builder = new StringBuilder();
           builder.append("1. List all books\n");
           builder.append("2. Add a book\n");
           builder.append("3. Borrow a book\n");
           return builder.toString();
    }
    public static void getInput(Scanner keyboard, Library thisLibrary)
    {
        switch(keyboard.nextInt())
        {
            case 1:
                System.out.println("List Books");
                System.out.println(listBooks(thisLibrary));
                break;

            case 2:
                System.out.println("Add a Book");
                addBook(thisLibrary);
                break;

            case 3:
                System.out.println("Borrow a Book");
                borrowBook(keyboard,thisLibrary);
                break;

            case 4:
                System.out.println("Return a Book");
                //Complete this!! Yes. I mean you. Reading. Hint: Look through the code.
                break;
            case 5:
                System.exit(0);
                break;

        }
    }

    public static Book newBook(int id) {
        Scanner sc = new Scanner(System.in);
        String title, author, yearPub, isbn;
        System.out.println("Enter title:");
        title = sc.nextLine();

        System.out.println("Enter author:");
        author = sc.nextLine();

        System.out.println("Enter year of publication:");
        yearPub = sc.nextLine();

        System.out.println("Enter ISBN number:");
        isbn = sc.nextLine();

        Book b = new Book(title, author, isbn, yearPub);
        b.setId(id);

        return b;

    }

    public static String listBooks(Library library)
    {
        StringBuilder builder = new StringBuilder();
        for(Book eachBook:library.getBooks())
        {
            builder.append("Book:"+eachBook.getId()+"\n");
            builder.append("Title:"+eachBook.getTitle()+"\n");
            builder.append("Author:"+eachBook.getAuthor()+"\n");
            builder.append("Year of Publication:"+eachBook.getYearPub()+"\n");
            builder.append("Status: "+(eachBook.isBorrowed()?"Borrowed":"Available")+"\n");
            builder.append("ISBN:"+eachBook.getIsbn()+"\n\n");

        }
        return builder.toString();
    }

    //You can overload methods AS WELL as constructors. This means you can have multiple methods of the same name, and pass
    //DIFFERENT variables to them. You can't have two methods with the same method signature, though. So you can't have two
    //methods that look like method(String, String) - they should ALWAYS accept different data types.
    public static String listBooks(boolean available, Library library)
    {
        //List books by availability.

        StringBuilder builder = new StringBuilder();

        for(Book eachBook:library.getBooks())
        {
            //If the book is borrowed, it is not available.
            //by extension, if it is not borrowed, then it is available.
            //Read that again. :0)
            if(eachBook.isBorrowed()==!available)
            {
                builder.append("Book ID:"+eachBook.getId()+"\n");
                builder.append("Title:"+eachBook.getTitle()+"\n");
                builder.append("Author:"+eachBook.getAuthor()+"\n");
                builder.append("Year of Publication:"+eachBook.getYearPub()+"\n");
                builder.append("Status: "+(eachBook.isBorrowed()?"Borrowed":"Available")+"\n");
                builder.append("ISBN:"+eachBook.getIsbn()+"\n\n");
            }
        }
        return builder.toString();
    }

    public static void addBook(Library thisLibrary)
    {
        Scanner keyboard = new Scanner(System.in);
        boolean stop = false;
        String yesno="";
        do{

            thisLibrary.addBook(newBook(ID));
            System.out.println("Would you like to enter another book?");
            yesno = keyboard.nextLine();
            if(yesno.equalsIgnoreCase("n")||yesno.equalsIgnoreCase("no"))
            {
                stop = true;
            }
            else{
                stop = false;
            }
            ID++;
        }while(!stop);
    }

    public static void borrowBook(Scanner keyboard, Library thisLibrary)
    {

        System.out.println("This is the list of available books: ");
        //Show available books
        System.out.println(listBooks(true,thisLibrary));
        System.out.println("Enter a book ID");
        long id = keyboard.nextLong();
        keyboard.nextLine();
        Book found = new Book();

        for (Book toFind:thisLibrary.getBooks()) {
            if(toFind.getId()==id)
            {
                found = toFind;
                System.out.println("ID: "+toFind.getId()+"Title:"+ toFind.getTitle() +" has been found\n");
            }

        }
        if(!found.isBorrowed())
            found.setBorrowed(true);
        else
        {
            System.out.println("This book has already been borrowed");
        }
        thisLibrary.getBooks().set(thisLibrary.getBooks().indexOf(found),found);
        System.out.println(listBooks(thisLibrary));
    }

    public static void returnBook(Scanner keyboard, Library thisLibrary)
    {

        System.out.println("Enter a book ID");
        long id = keyboard.nextLong();
        keyboard.nextLine();
        Book found = new Book();

        for (Book toFind:thisLibrary.getBooks()) {
            if(toFind.getId()==id)
            {
                found = toFind;
                System.out.println("ID: "+toFind.getId()+"Title:"+ toFind.getTitle() +" has been found\n");
            }

        }
        if(found.isBorrowed())
            found.setBorrowed(false);
        else{
            System.out.println("This book is already available");
        }
        thisLibrary.getBooks().set(thisLibrary.getBooks().indexOf(found),found);
        System.out.println(listBooks(thisLibrary));
    }

}
