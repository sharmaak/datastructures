package org.simplesoft.datastructures.impl;

import org.simplesoft.datastructures.Stack;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

@Test(enabled = false)
public class StackPerformanceTest {


    private Logger LOGGER = Logger.getLogger(StackPerformanceTest.class);
    private static int TEN_THOUSAND = 10000;
    private static int HUNDRED_THOUSAND = 100000;
    private static int ONE_MILLION = 1000000;
    private static int ONE_BILLION = 1000000000;

    public StackPerformanceTest() {}

    private void nIterationsPushPerformanceTest(Stack<Integer> stack, int n) {

        long startTime = System.currentTimeMillis();
        for(int i=0; i<n; i++) {
            stack.push(i);
        }
        long stopTime = System.currentTimeMillis();
        long totalTime = stopTime-startTime;
        double averageTime = totalTime/n;

        LOGGER.info(
            String.format(
                    "Type=%s | Iterations=%s | Total Time = %s ms | average time = %s ms",
                    stack.getClass().getCanonicalName(), n, totalTime, averageTime));
    }

    @Test(enabled = false)
    public void testLinkedListStack10K() {
        nIterationsPushPerformanceTest(new LinkedListStack<Integer>(), TEN_THOUSAND);
    }

    @Test(enabled = false)
    public void testLinkedListStack100K() {
        nIterationsPushPerformanceTest(new LinkedListStack<Integer>(), HUNDRED_THOUSAND);
    }


    @Test(enabled = false)
    public void testArrayStack10K() {
        nIterationsPushPerformanceTest(new ArrayStack<Integer>(), TEN_THOUSAND);
    }

    @Test(enabled = false)
    public void testArrayStack100K() {
        nIterationsPushPerformanceTest(new ArrayStack<Integer>(), HUNDRED_THOUSAND);
    }

    @Test(enabled = false)
    public void testLinkedListStack1Mi() {
        for(int i=1; i<=10; i++) {
            nIterationsPushPerformanceTest(new LinkedListStack<Integer>(), ONE_MILLION*i);
        }
    }

    @Test(enabled = false)
    public void testArrayStack1Mi() {
        for(int i=1; i<=10; i++) {
            nIterationsPushPerformanceTest(new ArrayStack<Integer>(), ONE_MILLION*i);
        }
    }

}
