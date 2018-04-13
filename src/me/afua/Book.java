package me.afua;

public class Book {

    //Always include this from now on, even if you are not asked to
    private long id;
    private String title;
    private String author;
    private String isbn;
    private String yearPub;
    private boolean borrowed;

    public Book() {
        borrowed = false;
    }


    public Book(String title, String author, String isbn, String yearPub) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.yearPub = yearPub;
        borrowed=false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getYearPub() {
        return yearPub;
    }

    public void setYearPub(String yearPub) {
        this.yearPub = yearPub;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
}
