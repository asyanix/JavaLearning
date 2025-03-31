package animals;

import java.util.Objects;

public abstract class Animal  {
    protected String name;
    protected String type;
    protected String sound;
    
    public Animal(String name, String type, String sound) {
        this.name = name;
        this.type = type;
        this.sound = sound;
    }

    public abstract void say();
    
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
