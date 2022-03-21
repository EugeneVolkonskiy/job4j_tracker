package ru.job4j.tracker.oop;

import static java.lang.Math.sqrt;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    public double ab() {
        return first.distance(second);
    }

    public double ac() {
        return first.distance(third);
    }

    public double bc() {
        return second.distance(third);
    }

    public double semiPerimeter() {
        return (ab() + ac() + bc()) / 2;
    }

    public boolean exist() {
        return (ab() + ac() > bc()) && (ac() + bc() > ab()) && (ab() + bc() > ac());
    }

    public double area() {
        double rsl = -1;
        if (this.exist()) {
            double p = semiPerimeter();
            rsl = sqrt(p * (p - ab()) * (p - ac()) * (p - bc()));
        }
        return rsl;
    }
}
