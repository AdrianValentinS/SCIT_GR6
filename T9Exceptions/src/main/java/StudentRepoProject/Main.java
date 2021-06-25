package StudentRepoProject;


import java.util.logging.Logger;

public class Main {

    public static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {

        // See unit tests for method/object functionality checks. Main class proves normal logger functionality.

        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        LOGGER.info("Logger initialized.");

        LOGGER.info("Logger shutdown without errors.");

    }
}
