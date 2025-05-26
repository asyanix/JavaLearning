public class Car extends Thread {
    private final String carName;
    private final CarWash carWash;

    public Car(String carName, CarWash carWash) {
        this.carName = carName;
        this.carWash = carWash;
    }

    @Override
    public void run() {
        if (!carWash.tryEnterWaitingArea()) {
            System.out.println(carName + " уехала — нет мест для ожидания.");
            return;
        }

        try {
            System.out.println(carName + " ждёт своей очереди.");

            int slotNumber = carWash.enterWashingBay();
            System.out.println(carName + " начала мойку на месте #" + slotNumber);

            Thread.sleep(15 * 1000); // моделируем мойку

            System.out.println(carName + " завершила мойку на месте #" + slotNumber);
            carWash.leaveWashingBay(slotNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            carWash.leaveWaitingArea();
        }
    }
}
