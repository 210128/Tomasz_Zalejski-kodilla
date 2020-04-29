package com.kodilla.collections.adv.immutable;

public class ImmutableExample {
    public static void main(String[] args) {
        Book book = new BookHacked("Stephen King", "Roland");
        System.out.println(book.getTitle());
        BookHacked bookHacked = (BookHacked) book;
        bookHacked.modifyTitle("Shining");
        System.out.println(book.getTitle());
    }
}
