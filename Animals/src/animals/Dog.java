package animals;

public class Dog extends Animal implements Speakable, Runnable, Commandable, Eatable, Sleepable {
    private double weight;
    
    public Dog(String name, String type, String sound, double weight) {
        super(name, type, sound);
        this.weight = weight;
    }

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
    public void say() {
        System.out.println(name + " говорит: " + sound + "\n");
    }
    
    public double getWeight() {
        return weight;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Вес: " + weight;
    }
}
