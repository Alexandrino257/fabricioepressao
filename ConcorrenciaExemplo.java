class Contador implements Runnable {
    private String nome;

    public Contador(String nome) {
        this.nome = nome;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(nome + ": " + i);
            try {
                // Pausa de 500 milissegundos
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(nome + " foi interrompido.");
            }
        }
    }
}

public class ConcorrenciaExemplo {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Contador("Thread 1"));
        Thread thread2 = new Thread(new Contador("Thread 2"));

        thread1.start(); // Inicia a primeira thread
        thread2.start(); // Inicia a segunda thread

        try {
            // Aguarda as threads terminarem
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrompido.");
        }

        System.out.println("Contagem finalizada!");
    }
}
