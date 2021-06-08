/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Book;

/**
 * Holds the author, title, year, chapter, and number of chapters for a book object.
 * @author brunokoppel
 */
public class Book {

    /**
     * A book counter for how many books have been created.
     */
    public static int NumberOfBooks = 0;
    
    /**
     * Name of the author of the book object
     */
    public String author;
    
    /**
     * Title of the book object
     */
    public String title;
    
    /**
     * Year of publication of the book object
     */
    public int date;
    
    /**
     * Array for the chapters of the book object, using the Chapter UML created previously.
     */
    public Chapter chapters[];
    
    /**
     * Store how many chapters are in the book object.
     */
    public int numberOfChapters;
    
    /**
     * Default constructor for the book when the user does not provide any information for it.
     */
    Book(){
        setAuthor("");
        setTitle("");
        setDate(0);
        setNumberOfChapters(0);
        NumberOfBooks++;
        System.out.println(this.toString());
    }
    
    /**
     * Constructor for the book when the user creates it by providing the number of chapters.
     * @param author of the book.
     * @param title of the book.
     * @param date of publication of the book (year).
     * @param numberOfChapters in the chapter
     */
    Book(String author, String title, int date, int numberOfChapters){
        setAuthor(author);
        setTitle(title);
        setDate(date);
        setNumberOfChapters(numberOfChapters);
        NumberOfBooks++;
        System.out.println(this.toString());
    }
    
    /**
     * Constructor for the book when the user creates it by providing the number of chapters.
     * @param author of the book.
     * @param title of the book.
     * @param date of publication of the book (year).
     * @param chapters array with the chapters of the book.
     */
    Book(String author, String title, int date, Chapter chapters[]){
        setAuthor(author);
        setTitle(title);
        setDate(date);
        setChapters(chapters);
        NumberOfBooks++;
        System.out.println(this.toString());
    }
    
    /**
     * Sets the name of the Author of the book.
     * @param author is the name of the writer of the book, passed by the user.
     */
    public void setAuthor(String author){
        this.author = author;
    }
    
    /**
     * Sets the title for the book.
     * @param title is the title of the book passed by the user.
     */
    public void setTitle(String title){
        this.title = title;
    }
    
    /**
     * Sets the date of publication for the book
     * @param date is the year when the book was published, passed by the user..
     */
    public void setDate(int date){
        this.date = date;
    }
    
    /**
     * Sets the number of Chapters to a desired number.
     * @param numberOfChapters the number of chapters in the book, passed by the user.
     */
    public void setNumberOfChapters(int numberOfChapters){
        if (numberOfChapters > 100)
        {
            this.numberOfChapters = 100;
        }
        else if (numberOfChapters < 0)
        {
            this.numberOfChapters = 0;
        }
        else
        {
            this.numberOfChapters = numberOfChapters;
        }
    }
    
    /**
     * Sets the chapters of the book to be the same as the array passed by the user.
     * @param chapters array of chapters passed by the user.
     */
    public void setChapters(Chapter chapters[]){
        setNumberOfChapters(chapters.length);
        this.chapters = chapters;
    }
    
    
     /**
     * Gets the name of the Author of the book.
     */
    public String getAuthor(){
        return this.author;
    }
    
    /**
     * Gets the title for the book.
     */
    public String getTitle(){
        return this.title;
    }
    
    /**
     * Gets the date of publication for the book
     */
    public int getDate(){
        return this.date;
    }
    
    /**
     * Gets the number of Chapters in the book.
     */
    public int getNumberOfChapters(){
        return this.numberOfChapters;
    }
    
    /**
     * Gets the chapters of the book to be the same as the array passed by the user.
     */
    public Chapter[] getChapters(){
        return this.chapters;
    }
    
    /**
     * Prints the information that was set to the book just created
     * @return the information that was set to the book just created.
     */
    @Override
    public String toString() {
        return String.format("Book: " + getTitle() + " written by " + getAuthor() + 
                " (" + getDate() + "), is " + getNumberOfChapters() + " chapters.");
    }
    
}
