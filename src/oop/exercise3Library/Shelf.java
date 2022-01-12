package oop.exercise3Library;

import java.util.ArrayList;

public class Shelf {
    public int shelfCapacity;
    public ArrayList<Book> books;

    Shelf(int shelfCapacity, ArrayList<Book> books) throws Exception {
        this.shelfCapacity = shelfCapacity;
        this.books = books;

        if (shelfCapacity < books.size()) {
            throw new Exception("Books can't exceed the size of a shelf.");
        }
    }

    Shelf(int shelfCapacity) {
        this.shelfCapacity = shelfCapacity;
    }

    boolean addBook(Book gangplank) {
        if (this.books.size() <= shelfCapacity) {
            books.add(gangplank);
            return true;
        }
        return false;
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

    boolean removeBook(Book book) {
        if (books.contains(book)) {
            books.remove(book);
            return true;
        }
        return false;
    }

    ArrayList<Book> getBooksByAuthor(Author author) {
        ArrayList<Book> booksByAuthor = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).author == author) {
                booksByAuthor.add(books.get(i));
            }
        }
        return booksByAuthor;
    }

    int getFreeSlots() {
        return shelfCapacity - books.size();
    }
}
