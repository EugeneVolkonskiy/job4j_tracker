package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void ride() {
        System.out.println("Едем");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("Количество пассажиров: " + passengers);
    }

    @Override
    public int refuel(int liters) {
        return liters * 50;
    }
}
