package animals;

public class Fish extends Animal implements Speakable, Swimable, Eatable, Sleepable {
    private double size;

    public Fish(String name, String type, String sound, double size) {
        super(name, type, sound);
        this.size = size;
    }

    @Override
    public void swim() {
        System.out.println(name + " плавает.");
    }

    @Override
    public void eat() {
        System.out.println(name + " ест планктонов.");
    }

    @Override
    public void sleep() {
        System.out.println(name + " спит в аквариуме.");
    }

    @Override
    public void say() {
        System.out.println(name + " говорит: " + sound + "\n");
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return super.toString() + ", Размер: " + size;
    }
}