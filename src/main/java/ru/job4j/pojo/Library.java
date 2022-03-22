package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
    Book one = new Book("Clean code", 464);
    Book two = new Book("Head Firs Java", 690);
    Book three = new Book("Grokking Algorithms", 290);
    Book four = new Book("Java Complete Reference", 1500);
    Book[] books = new Book[4];
    books[0] = one;
    books[1] = two;
    books[2] = three;
    books[3] = four;
    for (int i = 0; i < books.length; i++) {
        Book bk = books[i];
        System.out.println(bk.getName() + "." + bk.getPages());
    }
    System.out.println();
    Book tmp = books[0];
    books[0] = books[3];
    books[3] = tmp;
    for (int i = 0; i < books.length; i++) {
         Book bk = books[i];
         System.out.println(bk.getName() + "." + bk.getPages());
    }
    System.out.println();
    for (int i = 0; i < books.length; i++) {
        Book bk = books[i];
        if (bk.getName().equals("Clean code")) {
            System.out.println(bk.getName() + "." + bk.getPages());
        }
    }
  }
}