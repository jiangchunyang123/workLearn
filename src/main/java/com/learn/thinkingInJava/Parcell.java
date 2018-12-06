package com.learn.thinkingInJava;

public class Parcell {
    private static class ParcelContents implements Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    protected static class ParcelDestination implements Destination {
        private String label;

        private ParcelDestination(String whereTo) {
            this.label = whereTo;
        }

        public String readLabel() {
            return label;
        }

    }

    public static Destination destination(String s) {
        return new ParcelDestination(s);
    }

    public static Contents contents() {
        return new ParcelContents();
    }

    public static void main(String[] args) {
        Contents contents = contents();
        Destination destination = destination("Tasmania");
    }
}
