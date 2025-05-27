public class CarWashSimulation {

    public static void main(String[] args) {
        CarWash carWash = new CarWash(6, 6); // 6 мест для мойки и 6 мест парковки

        // 10 машин в час => каждые 6 минут по 1 машине
        int totalCars = 10;
        for (int i = 1; i <= totalCars; i++) {
            Car car = new Car("Машина-" + i, carWash);
            car.start();

            try {
                Thread.sleep(2 * 1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
