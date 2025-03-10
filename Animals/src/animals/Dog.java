package animals;

public class Dog extends Animal {
    private double weight;
    
    public Dog(String name, String type, String sound, double weight) {
        super(name, type, sound);
        this.weight = weight;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    @Override
    public void say() {
        System.out.println(name + " говорит: " + sound + "\n");
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Вес: " + weight;
    }
}
