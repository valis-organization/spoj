package oop.exercise3Library;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        try {
            Author author = (Author) obj;
            return Objects.equals(this.authorName, author.authorName) && Objects.equals(this.authorSurname, author.authorSurname);
        } catch (Exception e) {
            return false;
        }
    }
}
