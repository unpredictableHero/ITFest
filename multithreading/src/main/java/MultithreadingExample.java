import static org.apache.log4j.Logger.getLogger;

import java.util.Iterator;
import java.util.Vector;

import org.apache.log4j.Logger;

public class MultithreadingExample {

    public static final Logger LOGGER = getLogger(MultithreadingExample.class);
    public static Vector<Object> data = new Vector<Object>();

    public static void main(String[] args) {

        LOGGER.error("Wrong");
        //new Producer().start();
        new Consumer().start();


        //lambda
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    LOGGER.error("Producer exception" + e.getMessage());
                }
                LOGGER.info("Producer");
                data.add(new Object());
                if (data.size() > 1000) {
                    data.remove(data.size() - 1);
                }
            }
        }).start();
    }

    public static class Producer extends Thread {

        public Producer() {
            super("Producer");
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    LOGGER.error("Producer exception" + e.getMessage());
                }
                LOGGER.info("Producer");
                data.add(new Object());
                if (data.size() > 1000) {
                    data.remove(data.size() - 1);
                }
            }
        }
    }

    public static class Consumer extends Thread {

        public Consumer() {
            super("Consumer");
        }

        @Override public void run() {
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    LOGGER.error("Consumer exception" + e.getMessage());
                }
                LOGGER.info("Consumer");
                synchronized (data) {
                    Iterator it = data.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
            }
        }
    }
}
