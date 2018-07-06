package com.ace.explore.cloud;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
@Slf4j
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Daemon(), "Daemon");
        thread.setDaemon(true);
        thread.start();
        TimeUnit.SECONDS.sleep(2);
        thread.interrupt();
        log.info("isInterrupted={}", thread.isInterrupted());
        TimeUnit.MILLISECONDS.sleep(5);
        log.info("isInterrupted={}", thread.isInterrupted());
    }

}

@Slf4j
class Daemon implements Runnable {

    @Override
    public void run() {
        int i = 0;
        System.out.println();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            log.error("InterruptedException", e);
        }
        for (; ; ) {
            i++;
            if (i % 9999 == 0) {
                System.out.println(i);
            }
        }
    }

}
