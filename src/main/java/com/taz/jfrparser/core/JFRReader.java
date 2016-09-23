package com.taz.jfrparser.core;

import com.jrockit.mc.flightrecorder.FlightRecording;
import com.jrockit.mc.flightrecorder.FlightRecordingLoader;
import com.jrockit.mc.flightrecorder.spi.IView;
import com.taz.jfrparser.cpuanalyzer.CPULoadEvent;
import com.taz.jfrparser.cpuanalyzer.CPULoadHandler;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Maninesan on 9/23/16.
 */
public class JFRReader {

    private ArrayList<IView> viewList;
    private FlightRecording recording;
    private static JFRReader jfrReader = new JFRReader();
    private static CSVWriter csvWriter;


    public static JFRReader getInstance() {
        csvWriter = CSVWriter.getInstance();
        return jfrReader;
    }

    private JFRReader() {
    }

    public void readJFR(ArrayList<String> filepaths, String eventType){
        for (String filepath:filepaths) {
            recording = FlightRecordingLoader.loadFile(new File(filepath));
            IView view = recording.createView();
            viewList.add(view);
            if(eventType == "CPU Load"){
                getCPUEvents(view);
            }else if(eventType=="GC"){
                getGCEvents(view);
            }
        }
    }

    public ArrayList<IView> getJFRRecording(){
        return viewList;
    }

    public void getCPUEvents(IView view){
        CPULoadHandler cpuLoadHandler = new CPULoadHandler(view);
        ArrayList<CPULoadEvent> eventlist = cpuLoadHandler.getEventSeries();
        csvWriter.printCPUOutput(eventlist);

    }

    public void getGCEvents(IView view){

    }
}
