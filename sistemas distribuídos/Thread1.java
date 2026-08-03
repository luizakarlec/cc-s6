class PrimeiraThread extends Thread {
    public void run() {
        for(int i=0; i < 50; i++){
            System.out.println("Thread1 executando!");
        }
    }
}

class SegundaThread extends Thread {
    public void run() {
        for(int i=0; i<50; i++){
            System.out.println("Thread2 em acao!");
        }
    }
}

public class Thread1 {
    public static void main(String[] args) {
        PrimeiraThread t1 = new PrimeiraThread();
        SegundaThread t2 = new SegundaThread();
        t1.start();
        t2.start();    
    }
}
