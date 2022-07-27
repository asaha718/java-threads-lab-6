import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // create an executor
        ExecutorService executor = Executors.newCachedThreadPool();

        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            // submit tasks to your executor
            executor.submit(new PrimeLogger(num));
        }
    }
}

class PrimeLogger implements Runnable {
    private final int num;

    public PrimeLogger(int num) {
        this.num = num;
    }

    boolean isPrime(int num){
        if( num < 2) {
            return false;
        }

        for(int i= 2; i < num; i++) {
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
    @Override
    public void run() {
        // print num if it is prime

        if(isPrime(num)){
            System.out.println(num + " is a prime number");
        }else{
            System.out.println(num + " is NOT a prime number");
        }
    }
}