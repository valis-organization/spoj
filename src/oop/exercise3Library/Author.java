package oop.exercise3Library;

public class Author {
    public String authorName;
    public String authorSurname;

    Author(String authorName, String authorSurname) {
        this.authorName = authorName;
        this.authorSurname = authorSurname;
    }

    @Override
    public String toString() {
        return authorName + " " + authorSurname;
    }
}
