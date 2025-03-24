package animals;

import java.util.Objects;

interface Speakable {
    void say();
}

interface Runnable {
    void run();
}

interface Commandable {
    void doCommand(String command);
}

interface Eatable {
    void eat();
}

interface Sleepable {
    void sleep();
}

public abstract class Animal implements Speakable, Runnable, Commandable, Eatable, Sleepable {
    protected String name;
    protected String type;
    protected String sound;
    
    public Animal(String name, String type, String sound) {
        this.name = name;
        this.type = type;
        this.sound = sound;
    }
    
    @Override
    public abstract void say();
    
    @Override
    public void run() {
        System.out.println(name + " бежит.");
    }
    
    @Override
    public void doCommand(String command) {
        System.out.println(name + " делает комманду: " + command);
    }
    
    @Override
    public void eat() {
        System.out.println(name + " ест.");
    }
    
    @Override
    public void sleep() {
        System.out.println(name + " спит.");
    }
    
    @Override
    public String toString() {
        return type + " " + name + " говорит " + sound;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Animal animal = (Animal) obj;
        return Objects.equals(name, animal.name) && Objects.equals(type, animal.type);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
}
