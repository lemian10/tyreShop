package ru.lemian.tireshop;

public class Pet {
    private String name;
    private int возраст;

    public void Назвать(String имя) {
        name = имя;
    }

    public void СкажиСвоеИмя() {
        System.out.println(name);
    }

    public void Сидеть() {
        System.out.println("Я сажусь");
    }

    public void Есть() {
        System.out.println("Я ем");
        Пищеворение();
    }

    private void Пищеворение() {
        System.out.println("живот переваривает");

    }
}
