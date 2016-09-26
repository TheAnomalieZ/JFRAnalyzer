package com.taz.jfrparser.core;

import com.taz.jfrparser.cpuanalyzer.CPULoadEvent;
import com.taz.jfrparser.gcanalyzer.MemEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CSVWriter {

    private static CSVWriter csvWriter = new CSVWriter();

    public static CSVWriter getInstance() {
        return csvWriter;
    }

    private CSVWriter() {
    }


    public void printCPUOutput(ArrayList<CPULoadEvent> eventList, String index){
        File courseCSV = new File("CPULoad"+index+".csv");

        //create PrintWriter object on new File object
        PrintWriter outfile = null;
        try {
            outfile = new PrintWriter(courseCSV);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(int i=0;i<eventList.size();i++){
            try{
                System.out.println(eventList.get(i).getEndTimestamp()-eventList.get(i-1).getStartTimestamp()+"  "+eventList.get(i).getJvmUser());
                outfile.write(eventList.get(i).getEndTimestamp()-eventList.get(i-1).getStartTimestamp()+","+eventList.get(i).getJvmUser() + "\n");
            }catch(IndexOutOfBoundsException e){

            }
        }
        outfile.close();
    }

    public void printGCOutputOne(ArrayList<Integer> stateSequence, String index){
        File courseCSV = new File("GCStates"+index+".csv");
        //create PrintWriter object on new File object
        PrintWriter outfile = null;
        try {
            outfile = new PrintWriter(courseCSV);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for(int i=0;i<stateSequence.size();i++){
                System.out.println(stateSequence.get(i));
                outfile.write(stateSequence.get(i));
            }

        outfile.close();
    }

}
