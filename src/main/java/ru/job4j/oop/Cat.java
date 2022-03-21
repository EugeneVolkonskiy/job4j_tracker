package ru.job4j.oop;

public class Cat {

    private String food;
    private String name;

    public void show() {
        System.out.println(this.name);
        System.out.println(this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public static void main(String[] args) {
        System.out.println("There are first cat's nick and food.");
        Cat cat1 = new Cat();
        cat1.giveNick("gav");
        cat1.eat("kotleta");
        cat1.show();
        System.out.println("There are second cat's nick and food.");
        Cat cat2 = new Cat();
        cat2.giveNick("black");
        cat2.eat("fish");
        cat2.show();
    }
}
