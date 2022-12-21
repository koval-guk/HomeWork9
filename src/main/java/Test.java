public class Test {
    public static void main(String[] args) {

        FileLoggerConfiguration fileLoggerConfiguration = new FileLoggerConfiguration();
        fileLoggerConfiguration.setLevel(LoggingLevel.DEBUG);
        FileLogger logger = new FileLogger(fileLoggerConfiguration);
        System.out.println(fileLoggerConfiguration.getMaxSize());
        logger.debug("test1");
        logger.info("test2");
        logger.debug("test3");
        logger.info("test4");
        logger.debug("test5");
        logger.info("test6");
        logger.debug("test7");
        logger.info("test8");
        logger.debug("test9");
        logger.info("test10");
        fileLoggerConfiguration.setLevel(LoggingLevel.INFO);
        logger.debug("test11");
        logger.info("test12");
        logger.debug("test13");
        logger.info("test14");
        logger.debug("test15");
        logger.info("test16");
        logger.debug("test17");
        logger.info("test18");
        logger.debug("test19");
        logger.info("test20");
        logger = new FileLogger(new FileLoggerConfigurationLoader("ConfigurationLoadFile.txt").load());
        logger.debug("test21");
        logger.info("test22");
        logger.debug("test23");
        logger.info("test24");
        logger.debug("test25");
        logger.info("test26");
        logger.debug("test27");
        logger.info("test28");
        logger.debug("test29");
        logger.info("test30");
    }
}
