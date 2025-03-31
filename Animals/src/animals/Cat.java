package animals;

public class Cat extends Animal implements Speakable, Runnable, Commandable, Eatable, Sleepable {
    private String eyeColor;
    
    public Cat(String name, String type, String sound, String eyeColor) {
        super(name, type, sound);
        this.eyeColor = eyeColor;
    }

    @Override
    public void say() {
        System.out.println(name + " говорит: " + sound + "\n");
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
    
    public String getEyeColor() {
        return eyeColor;
    }
    
    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Цвет глаз: " + eyeColor;
    }
}
