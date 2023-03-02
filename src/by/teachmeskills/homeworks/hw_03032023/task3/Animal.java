package by.teachmeskills.homeworks.hw_03032023.task3;

public abstract class Animal {
    protected abstract void makeNoise();

    protected abstract void eat();

    protected String picture;
    protected Location location;
    protected Boundaries boundaries;
    protected FoodType foodType;
    protected boolean hunger;

    public Animal(String picture, boolean hunger, FoodType foodType) {
        this.picture = picture;
        this.hunger = hunger;
        this.foodType = foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public void setHunger(boolean hunger) {
        this.hunger = hunger;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    protected static class Location {
        private int x;
        private int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public String toString() {
            return "Позиция{x=" + x + ", y=" + y + "}";
        }
    }

    protected static class Boundaries {
        private int width;
        private int height;

        public Boundaries(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        @Override
        public String toString() {
            return "Boundaries{" + "width=" + width + ", height=" + height + "}";
        }
    }

    protected enum FoodType {
        GRASS,
        MEAT,
        MILK,
        BONES
    }

    protected void sleep() {
        System.out.println("Животное спит по-обычному");
    }

    protected void roam() {
        System.out.println("Животное бродит по-обычному");
    }

    protected abstract void printAll();
}
