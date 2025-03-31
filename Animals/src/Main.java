import animals.*;

public class Main {
    public static void main(String[] args) {
        Animal[] unique_animals = new Animal[9];
        int count = 0;
        
        Animal[] all_animals = {
            new Dog("Бобик", "Лабрадор", "Гав", 30.5),
            new Cat("Бублик", "Британский", "Мяу", "Голубой"),
            new Horse("Жемчужина", "Арабский скакун", "Иго-го", 500, 60),
            new Fish("Немо", "Клоун", "Буль-буль", 10),
            new Dog("Коржик", "Мопс", "Гав гув гав", 40),
            new Cat("Карамелька", "Персидский", "Мяяяяу", "Зеленый"),
            new Horse("Компот", "Мустанг", "Игогогого", 450, 55),

            new Dog("Бобик", "Лабрадор", "Гав", 30.5),                      // Дубликат
            new Cat("Бублик", "Британский вислоухий", "Мяу", "Голубой"),    // Дубликат
            new Horse("Жемчужина", "Арабский скакун", "Иго-го", 500, 60)    // Дубликат
        };
        
        for (Animal animal : all_animals) {
            boolean unique = true;
            for (int i = 0; i < count; i++) {
                if (unique_animals[i].equals(animal)) {
                    unique = false;
                    break;
                }
            }
            if (unique) {
                unique_animals[count++] = animal;
            }
        }
        
        for (int i = 0; i < count; i++) {
            System.out.println(unique_animals[i]);
            unique_animals[i].say();
        }
    }
}
