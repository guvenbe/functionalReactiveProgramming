package com.codingsaint.learning.rxjava.models;

public class Shape {
    private  String shape;
    private String color;

    public Shape(String shape, String color) {
        this.shape = shape;
        color = color;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        color = color;
    }
}
