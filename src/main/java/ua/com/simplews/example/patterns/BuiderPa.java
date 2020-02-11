package ua.com.simplews.example.patterns;

import org.junit.jupiter.api.Test;

public class BuiderPa {

    interface houseMaster {
        void setDoor(Door door);
        void setwindow(Window window);
    }

    interface specification {
        String getDescription();
    }

    class Door implements specification {
        public Door(int dors) {
            this.dors = dors;
        }

        private int dors;

        public int getDors() {
            return dors;
        }


        @Override
        public String getDescription() {
            return "it has: " + dors + " dors";
        }
    }

    class Window implements specification {
        public Window(int windows) {
            this.windows = windows;
        }

        private int windows;

        public int getWindows() {
            return windows;
        }

        public void setWindows(int windows) {
            this.windows = windows;
        }

        @Override
        public String getDescription() {
            return "it has: " + windows + " windows";
        }
    }


    class SuperHouse {
        private Door door;
        private Window window;

        public SuperHouse(Door door, Window window) {
            this.door = door;
            this.window = window;
        }

        public Door getDoor() {
            return door;
        }

        public void setDoor(Door door) {
            this.door = door;
        }

        public Window getWindow() {
            return window;
        }

        public void setWindow(Window window) {
            this.window = window;
        }
    }


    class TeremokBuilder implements houseMaster {

        private Door door;
        private Window window;

        @Override
        public void setDoor(Door door) {
            this.door = door;
        }

        @Override
        public void setwindow(Window window) {
            this.window = window;
        }

        public SuperHouse getResult() {
            return new SuperHouse(door, window);
        }
    }

    class HouseMaker {

        public void teremokBuilder(houseMaster builder) {
            builder.setDoor(new Door(2));
            builder.setwindow(new Window(4));
        }

        public void chumBuilder(houseMaster builder) {
            builder.setDoor(new Door(1));
            builder.setwindow(new Window(0));
        }

    }

    @Test
    void buildSmth() {
        TeremokBuilder teremokBuilder = new TeremokBuilder();
        HouseMaker houseMaker = new HouseMaker();
        houseMaker.teremokBuilder(teremokBuilder);
        SuperHouse superHouse = teremokBuilder.getResult();
        System.out.println(superHouse.getDoor().getDescription());
        System.out.println(superHouse.getWindow().getDescription());
    }


}
