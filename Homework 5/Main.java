package HW_05;

public class Main {
    public static void main(String[] args) {
        Fork[] forks = new Fork[5];
        Philosopher[] philosophers = new Philosopher[5];

        for (int i = 0; i < 5; i++) {
            forks[i] = new Fork(i);
        }

        for (int i = 0; i < 5; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % 5];
            philosophers[i] = new Philosopher(i, leftFork, rightFork);
            philosophers[i].start();
        }
    }
}

