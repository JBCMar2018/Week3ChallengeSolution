package me.afua;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //This application uses methods instead of having everything in main
        int ID=1;

        Scanner keyboard = new Scanner(System.in);
        Library thisLibrary = new Library();
        boolean stop=false;
        String yesno;


        //Show the menu
        System.out.println(showMenu());


        //Add a book
        addBook(thisLibrary,ID);


        //List books
//        System.out.println(listBooks(thisLibrary));
//
//        //Borrow a book
//        System.out.println("Enter a book ID");
//        long id = keyboard.nextLong();
//        keyboard.nextLine();
//        Book found = new Book();
//
//        for (Book toFind:thisLibrary.getBooks()) {
//            if(toFind.getId()==id)
//            {
//                found = toFind;
//            }
//
//        }
//        if(found.isBorrowed())
//        found.setBorrowed(true);


    }

    public static String showMenu()
    {
           StringBuilder builder = new StringBuilder();
           builder.append("1. List all books\n");
           builder.append("2. Add a book\n");
           builder.append("3. Borrow a book\n");
           return builder.toString();
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

        Book b = new Book(title, author, yearPub, isbn);
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
            builder.append("Status:"+(eachBook.isBorrowed()?"Borrowed":"Available"));
            builder.append("ISBN:"+eachBook.getIsbn()+"\n\n");

        }
        return builder.toString();
    }

    public static void addBook(Library thisLibrary, int ID)
    {
        Scanner keyboard = new Scanner(System.in);
        boolean stop = false;
        String yesno="";
        do{

            thisLibrary.addBook(newBook(ID));
            System.out.println("Would you like to enter another book?");
            yesno = keyboard.nextLine();
            if(yesno.equalsIgnoreCase("n")||yesno.equalsIgnoreCase("nO"))
            {
                stop = true;
            }
            ID++;
        }while(!stop);
    }



}
