package oop.exercise3Library;

import java.util.ArrayList;

public class Shelf {
    public int shelfCapacity; // in the number of books it can handle
    public ArrayList<Book> books;
    public int freeSlots;

    Shelf(int shelfCapacity, ArrayList<Book> books) throws Exception {
        this.shelfCapacity = shelfCapacity;
        this.books = books;

        if (shelfCapacity < books.size()) {
            throw new Exception("Books can't exceed the size of a shelf.");
        }
        freeSlots = shelfCapacity - books.size();
    }

    Shelf(int shelfCapacity) {
        this.shelfCapacity = shelfCapacity;
        if (!books.isEmpty()) {
            freeSlots = shelfCapacity;
        } else {
            freeSlots = shelfCapacity - books.size();
        }
    }

    void addBook(Book gangplank) {
        if (this.books.size() > shelfCapacity) {
            books.add(gangplank);
            freeSlots--;
        }
    }

    void addBook(ArrayList<Book> books) {
        for (int i = 0; i < books.size(); i++) {
            if (!this.books.contains(books.get(i))) {
                System.out.println("Added book");
                this.books.add(books.get(i));
            } else {
                System.out.println("Book is not added");
            }
        }
    }

    void removeBook(Book book) {
        if (!books.isEmpty()) {
            books.remove(book);
            freeSlots++;
        } else {
            System.out.println("Shelf is empty.");
        }
    }

    ArrayList<Book> getBooksByAuthor(Author author) {
        ArrayList<Book> booksByAuthor = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).author == author) {
                booksByAuthor.add(books.get(i));
                freeSlots--;
            }
        }
        return booksByAuthor;
    }
}
