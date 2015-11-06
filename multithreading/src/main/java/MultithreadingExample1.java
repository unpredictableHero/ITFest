import java.util.ArrayList;

public class MultithreadingExample1 {

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> a = new ArrayList<>();

        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 20; ++i) {
                    a.add(i);
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 20; ++i) {
                    a.add(i);
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(a.size());
        for (int i = 0; i < a.size(); ++i) {
            System.out.println(i + "  " + a.get(i));
        }
    }
}
