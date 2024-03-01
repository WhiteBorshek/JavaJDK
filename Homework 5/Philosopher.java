package HW_05;

public class Philosopher extends Thread {
    private final int id;
    private final Fork leftFork;
    private final Fork rightFork;
    private int mealsEaten;

    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.mealsEaten = 0;
    }

    @Override
    public void run() {
        while (mealsEaten < 3) { // Философ будет есть только три раза
            think();
            eat();
        }
    }

    private void think() {
        System.out.println("Философ " + id + " размышляет.");
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void eat() {
        System.out.println("Философ " + id + " пытается взять вилки.");
        synchronized (leftFork) {
            System.out.println("Философ " + id + " взял левую вилку.");
            synchronized (rightFork) {
                System.out.println("Философ " + id + " взял правую вилку и начинает есть.");
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Философ " + id + " закончил есть и кладет вилки на стол.");
                mealsEaten++;
            }
        }
    }
}


