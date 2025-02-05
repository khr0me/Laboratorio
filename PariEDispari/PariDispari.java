class PariDispari extends Thread {
    private int max;
    private boolean pari;
    private static final Object lock = new Object();
    private static boolean turnoPari = true;
    private int start;

    public PariDispari(int start, int max, boolean pari) {
        this.start = start;
        this.max = max;
        this.pari = pari;
    }

    public void run() {
        int x = start;
        if ((x % 2 == 0) != pari) {
            x++; // incremento del numero stampato per renderlo pari/dispari
        }
    
        for (; x <= max; x += 2) {
            synchronized (lock) {
                while (turnoPari != pari) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println((pari ? "Pari" : "Dispari") + " -> " + x);
                turnoPari = !turnoPari;
                lock.notifyAll();
            }
        }
    }
}    