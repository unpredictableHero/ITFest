

import static org.apache.log4j.Logger.getLogger;

import org.apache.log4j.Logger;

public class Example {

    public static final Logger LOGGER = getLogger(Example.class);

    public static void main(String[] args) {

        LOGGER.error("Wrong");

    }
}
