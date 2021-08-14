/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter;

/**
 * Holds the title, number of the chapter, and the number of pages for each chapter in the book.
 * @author brunokoppel
 */
public class Chapter {

    /**
     * Number of Chapters, static value that changes as chapters get created
     */
    public static int NumberOfChapters = 0;
    
    /**
     * Number of the chapter 
     */
    public int chapterNumber;
    
    /**
     * Title of the chapter
     */
    public String chapterTitle;
    
    /**
     * Number of pages in the chapter
     */
    public int chapterNumberOfPages;
    
    /**
     * Default constructor for the chapter when the user does not provide any information for it.
     */
    Chapter(){
        setChapterNumber(NumberOfChapters);
        setChapterTitle("");
        setChapterPages(0);
        NumberOfChapters++;
        System.out.println(this.toString());
    }
    
    /**
     * Constructor for the chapter when the user creates it with some information in it.
     * @param title of the chapter
     * @param numberOfPages in the chapter
     */
    Chapter(String title, int numberOfPages){
        setChapterNumber(NumberOfChapters);
        setChapterTitle(title);
        setChapterPages(numberOfPages);
        NumberOfChapters++;
        System.out.println(this.toString());
    }
    
    /**
     * Sets the Number of the chapter
     * @param NumberOfChapters is the count of chapters that have been created, which get updated every time a chapter is created.
     */
    public void setChapterNumber(int NumberOfChapters){
        this.chapterNumber = NumberOfChapters;
    }
    
    /**
     * Sets the title for the chapter
     * @param title gets passed from the user when creating the Chapter.
     */
    public void setChapterTitle(String title){
        this.chapterTitle = title;
    }
    
    /**
     * Sets the number of pages for a chapter.
     * @param numberOfPages gets passed from the user when creating the Chapter.
     */
    public void setChapterPages(int numberOfPages){
        this.chapterNumberOfPages = numberOfPages;
    }
    
    /**
     * Returns the number of the chapter
     * @return the number of the chapter.
     */
    public int getChapterNumber(){
        return chapterNumber;
    }
    
    /**
     * Returns the title of the chapter
     * @return the title of the chapter.
     */
    public String getChapterTitle(){
        return chapterTitle;
    }
    
    /**
     * Returns the number of pages in the chapter
     * @return the number of pages in the chapter.
     */
    public int getChapterNumberOfPages(){
        return chapterNumberOfPages;
    }
    
    /**
     * Prints the information that was set to the chapter just created
     * @return the information that was set to the chapter just created.
     */
    @Override
    public String toString() {
        return String.format("Chapter " + getChapterNumber() + ": " + getChapterTitle() + 
                ", is " + getChapterNumberOfPages() + " pages long.");
    }
    
}
