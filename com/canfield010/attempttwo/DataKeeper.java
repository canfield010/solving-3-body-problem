package com.canfield010.attempttwo;

import com.canfield010.attempttwo.links.Link;

public class DataKeeper extends Thread {

    public double averageOperationLength = 0;
    public final long t = System.currentTimeMillis();
    public long counter = System.currentTimeMillis();

    public int operationLengthSum = 0;
    public int updates = 0;
    public int[] operations = new int[Link.THREAD_COUNT];
    public int totalOperations = 0;
    public int runningThreads = Link.THREAD_COUNT;

    @Override
    public void run() {
        boolean firstTime = true;

        while (true) {
            if (firstTime) {
                if (System.currentTimeMillis()-counter>10_000) {
                    System.out.println("Ten second update:");
                    sendUpdate();
                    firstTime = false;
                }
            } else {
                if (System.currentTimeMillis()-counter>60_000) {
                    System.out.println("\nNext minute update:");
                    sendUpdate();
                    counter+=60_000;
                }
            }
            if (runningThreads==0) {
                break;
            }
        }

    }

    public void updateData(int threadIndex, int operationLength) {
        updates++;
        operationLengthSum += operationLength;
        operations[threadIndex] += 10;
        totalOperations += 10;
    }

    private void sendUpdate() {
        System.out.println("Average rate: "+1000*((double)totalOperations/((double)(System.currentTimeMillis()-t)))+" attempts per second");
        System.out.println("Average attempt length: "+((double)(operationLengthSum*10))/(double)totalOperations+" operations");
        for (int index = 0; index<Link.THREAD_COUNT; index++) {
            System.out.println(index+" rate:"+(1000*operations[index]/((double)(System.currentTimeMillis()-t))));
        }
    }

}
