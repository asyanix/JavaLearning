package animals;

public class Horse extends Animal {
    private double weight;
    private double speed;
    
    public Horse(String name, String type, String sound, double weight, double speed) {
        super(name, type, sound);
        this.weight = weight;
        this.speed = speed;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    public double getSpeed() {
        return speed;
    }
    
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    
    @Override
    public void say() {
        System.out.println(name + " говорит: " + sound + "\n");
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Вес: " + weight + ", Скорость: " + speed;
    }
}
