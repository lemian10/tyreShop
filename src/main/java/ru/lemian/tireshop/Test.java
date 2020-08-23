package ru.lemian.tireshop;

public class Test {
    public static void main(String[] args) {
        // [ 16mb ]
        // [___|___ 16mb - 2Pet]


        Pet ик = new Pet();
        ик.Назвать("котик-ик");
        ик.Есть();
        ик.СкажиСвоеИмя();

        System.out.println("---------------");

        Pet мурка = new Pet();
        ик.Назвать("мурка");
        ик.Есть();
        ик.СкажиСвоеИмя();
    }
}
