package com.taz.jfrparser.core;

import com.jrockit.mc.flightrecorder.FlightRecording;
import com.jrockit.mc.flightrecorder.FlightRecordingLoader;
import com.jrockit.mc.flightrecorder.spi.IView;
import com.taz.jfrparser.cpuanalyzer.CPULoadEvent;
import com.taz.jfrparser.cpuanalyzer.CPULoadHandler;
import com.taz.jfrparser.gcanalyzer.GCTimeHandler;
import com.taz.jfrparser.gcanalyzer.GCTimeSeriesModel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Maninesan on 9/23/16.
 */
public class JFRReader {

    private ArrayList<IView> viewList = new ArrayList<IView>();
    private FlightRecording recording;
    private static JFRReader jfrReader = new JFRReader();
    private static CSVWriter csvWriter;


    public static JFRReader getInstance() {
        csvWriter = CSVWriter.getInstance();
        return jfrReader;
    }

    private JFRReader() {
    }

    public void readJFR(ArrayList<String> filePaths, String eventType){
        for (String filePath:filePaths) {
            recording = FlightRecordingLoader.loadFile(new File(filePath));
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
        ArrayList<CPULoadEvent> eventList = cpuLoadHandler.getEventSeries();
        csvWriter.printCPUOutput(eventList);

    }

    public void getGCEvents(IView view) {
        GCTimeSeriesModel gcModel = new GCTimeSeriesModel(view);
        ArrayList<Integer> stateSequence = gcModel.getOuputOne();
        csvWriter.printGCOutputOne(stateSequence);

    }
}
