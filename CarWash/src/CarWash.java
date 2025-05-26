import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore; // отвечает за контроль количества потоков, которым разрешён доступ к ресурсу (мойка или ожидание)

public class CarWash {
    private final Semaphore washingBay;
    private final Semaphore waitingArea;
    private final Queue<Integer> washingSlots;

    public CarWash(int washingSlotsCount, int waitingSlots) {
        this.washingBay = new Semaphore(washingSlotsCount, true);
        this.waitingArea = new Semaphore(waitingSlots, true);

        this.washingSlots = new LinkedList<>();
        for (int i = 1; i <= washingSlotsCount; i++) {
            washingSlots.offer(i);          // добавляет элемент в конец очереди, если есть место
        }
    }

    public boolean tryEnterWaitingArea() {
        return waitingArea.tryAcquire();    // неблокирующий вызов, пытающийся получить разрешение от семафора, возвращает false, если ожидание невозможно
    }

    public void leaveWaitingArea() {
        waitingArea.release();              // освобождает одно разрешение, тем самым разблокирует один из ожидающих потоков, если такой есть
    }

    public int enterWashingBay() throws InterruptedException {
        washingBay.acquire();               // блокирует поток, пока не освободится разрешение, далее поток продолжает выполнение


        synchronized (washingSlots) {
            return washingSlots.poll();     // удаляет и возвращает первый элемент очереди (забираем место)
        }
    }

    public void leaveWashingBay(int slotNumber) {
        synchronized (washingSlots) {
            washingSlots.offer(slotNumber); // возвращаем место
        }
        washingBay.release();
    }
}
