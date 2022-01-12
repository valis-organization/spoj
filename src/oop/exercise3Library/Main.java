package oop.exercise3Library;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {

        ArrayList<Chapter> chapters = new ArrayList<>();
        chapters.add(new Chapter("asd", 1));
        chapters.add(new Chapter("asd2", 2));
        Author rafau = new Author("Rafał", "Maciąg");
        Book book1 = new Book("Zyl sobie pewien rafal, ktory byl głombem",
                "Osiol rafal",
                rafau,
                chapters, 12);

        ArrayList<Chapter> chaptersOfGangplank = new ArrayList<>();
        chaptersOfGangplank.add(new Chapter("adsd", 1));
        chaptersOfGangplank.add(new Chapter("asd2", 2));
        Book book2 = new Book("Zyl sobie pewien rafal, ktory byl głombem",
                "upo",
                rafau,
                chaptersOfGangplank, 12);

        ArrayList<Book> books = new ArrayList<>();
        Shelf pulka = new Shelf(4, books);

        pulka.addBook(book1);
        System.out.println(pulka.books.toString());
        System.out.println("Wolne miejsca:" + pulka.getFreeSlots());
        pulka.addBook(book2);
        System.out.println("Wolne miejsca:" + pulka.getFreeSlots());

        ArrayList<Chapter> chaptersOfKsiomzka = new ArrayList<>();
        chaptersOfKsiomzka.add(new Chapter("champ", 1));
        chaptersOfKsiomzka.add(new Chapter("rafal", 2));
        Book book3 = new Book("asdZyl sobie pewien rafal, ktory byl głombem",
                "Ksiomzka",
                rafau,
                chaptersOfKsiomzka, 144);

        ArrayList<Chapter> chaptersOfLiczby = new ArrayList<>();
        chaptersOfLiczby.add(new Chapter("jeden", 1));
        chaptersOfLiczby.add(new Chapter("dwa", 2));
        Book book4 = new Book("trzy",
                "Cztery",
                (new Author("Mysliciel", "Wielki")),
                chaptersOfLiczby, 5);
        books.add(book4);
        books.add(book3);

        System.out.println(books);
        System.out.println(pulka.getBooksByAuthor(rafau));
        System.out.println(pulka.getFreeSlots());
        pulka.removeBook(book1);
        System.out.println(books);
        if(pulka.getFreeSlots() > 0 )
        {
            pulka.addBook(book1);
        }
    }
}
