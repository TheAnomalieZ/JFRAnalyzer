package com.taz.jfrparser.gcanalyzer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StateIdentifier {
    /**
     * State 0 : Initial state
     * State 1 : HH     //High time between GC,Used heap diff High
     * State 2 : HL     //High time between GC, Used heap diff Low
     * State 3 : LL     //Low time between GC, Used heap diff Low
     * State 4 : LH     //Low time between GC, Used heap diff High
     */
    private final Map<Long, MemEvent> eventMap;
    private List<Integer> stateSequence = new ArrayList<Integer>();

    public StateIdentifier(Map<Long, MemEvent> eventMap) {
        this.eventMap = eventMap;
    }

    public ArrayList<Integer> configureStates() {
        long lastMemoryDif = 0;
        long lastGCTimeDif = -1;
        long tempLastUsedMem = 0;
        long tempLastGCEndTime = -1;
        int mod = 0;
        int count = 1;
        for (Map.Entry<Long, MemEvent> memEventEntry : eventMap.entrySet()) {
            if (count % 2 != 0) {
                MemEvent memEvent = memEventEntry.getValue();
                tempLastGCEndTime = memEvent.getEndTimestamp();
                tempLastUsedMem = memEvent.getUsedHeap();

            }
            if (count % 2 == 0) {
                MemEvent memEvent = memEventEntry.getValue();
                long memDif = memEvent.getUsedHeap() - tempLastUsedMem;
                long gcGap = memEvent.getStartTimestamp() - tempLastGCEndTime;
                if(lastGCTimeDif==-1 && lastMemoryDif==0) {
                    lastGCTimeDif = gcGap;
                    lastMemoryDif = memDif;
                }
                else{
                    identifyState(lastMemoryDif,lastGCTimeDif,memDif,gcGap);
                    lastMemoryDif = memDif;
                    lastGCTimeDif = gcGap;
                }

            }
            count++;
        }

        return (ArrayList<Integer>) stateSequence;
    }

    private void identifyState(long lastMemDiff, long lastGCTimeDiff, long currMemDiff, long currGCTimeDiff) {
        int state = 0;
        if(currGCTimeDiff>=lastGCTimeDiff && currMemDiff>=lastMemDiff) {
            state =1;
            stateSequence.add(0);
        }
        if(currGCTimeDiff>lastGCTimeDiff && currMemDiff<lastMemDiff) {
            state =2;
            stateSequence.add(1);
        }
        if(currGCTimeDiff<lastGCTimeDiff && currGCTimeDiff<lastGCTimeDiff) {
            state =3;
            stateSequence.add(2);
        }
        if(currGCTimeDiff<lastGCTimeDiff && currGCTimeDiff>lastGCTimeDiff) {
            state =4;
            stateSequence.add(3);
        }

    }

}

    //        String csv = "output.csv";
//        CSVWriter writer = new CSVWriter(new FileWriter(csv));
//        ArrayList<String> A = new ArrayList<String>();
//    java.io.File courseCSV = new java.io.File("benchmark.csv");
//
//    //create PrintWriter object on new File object
//    java.io.PrintWriter outfile = null;
//try {
//        outfile = new java.io.PrintWriter(courseCSV);
//        } catch (FileNotFoundException e) {
//        e.printStackTrace();
//        }
//
//
//
//        for(Integer num : stateSequence){
//        System.out.print(num-1+" ");
//        outfile.write(num-1 + "\n");
//        }
//        outfile.close();
//
//        String[] stockArr = new String[A.size()];
//        stockArr = A.toArray(stockArr);
//        writer.append(stockArr);
//        writer.close();