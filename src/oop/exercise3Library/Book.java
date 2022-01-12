package oop.exercise3Library;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Book {
    public String text;
    public String nameOfTheBook;
    public Author author;
    public ArrayList<Chapter> chapters;
    public int numberOfPages;

    Book(String text, String nameOfTheBook, Author author, ArrayList<Chapter> chapters, int numberOfPages) {
        this.text = text;
        this.nameOfTheBook = nameOfTheBook;
        this.author = author;
        this.chapters = chapters;
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "Nazwa ksiazki: " + nameOfTheBook; //+ " Autor: " + author + " Tekst: " + text;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            Book book = (Book) obj;
            if (this.text == book.text) {
                System.out.println("TRUE " + this + book);
                return true;
            } else if (this.author.authorSurname == book.author.authorSurname) {
                System.out.println("TRUE " + this + book);
                return true;
            } else if (this.author.authorName == book.author.authorName) {
                System.out.println("TRUE " + this + book);
                return true;
            }
            System.out.println("FALSE " + this + book);
            return false;
        } catch (Exception e) {
            System.out.println("FALSE - EXCEPTION ");
            return false;
        }
    }

}
