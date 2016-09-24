package com.taz.jfrparser.core;

import com.taz.jfrparser.cpuanalyzer.CPULoadEvent;
import com.taz.jfrparser.gcanalyzer.MemEvent;

import java.util.ArrayList;

/**
 * Created by  Maninesan on 9/23/16.
 */
public class CSVWriter {

    private static CSVWriter csvWriter = new CSVWriter();

    public static CSVWriter getInstance() {
        return csvWriter;
    }

    private CSVWriter() {
    }

    public void printCPUOutput(ArrayList<CPULoadEvent> eventList){
        for(int i=0;i<eventList.size();i++){
            try{
                System.out.println(eventList.get(i).getEndTimestamp()-eventList.get(i-1).getStartTimestamp()+"  "+eventList.get(i).getJvmUser());
            }catch(IndexOutOfBoundsException e){

            }
        }
    }

    public void printGCOutput(ArrayList<MemEvent> eventList){
        for(int i=0;i<eventList.size();i++){
            try{
//                System.out.println(eventList.get(i).getEndTimestamp()-eventList.get(i-1).getStartTimestamp()+"  "+eventList.get(i).getJvmUser());
            }catch(IndexOutOfBoundsException e){

            }
        }
    }

}
