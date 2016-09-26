package com.taz.jfrparser.core;

import com.jrockit.mc.flightrecorder.FlightRecording;
import com.jrockit.mc.flightrecorder.FlightRecordingLoader;
import com.jrockit.mc.flightrecorder.spi.IView;
import com.taz.jfrparser.cpuanalyzer.CPULoadEvent;
import com.taz.jfrparser.cpuanalyzer.CPULoadHandler;
import com.taz.jfrparser.gcanalyzer.GCTimeSeriesModel;

import java.io.File;
import java.util.ArrayList;

public class JFRReader {

    private static ArrayList<IView> viewList = new ArrayList<IView>();
    private FlightRecording recording;
    private static JFRReader jfrReader = new JFRReader();
    private static CSVWriter csvWriter;


    public static JFRReader getInstance() {
        csvWriter = CSVWriter.getInstance();
        return jfrReader;
    }

    private JFRReader() {
    }

    public void readJFR(ArrayList<String> filePaths){
        for (String filePath:filePaths) {
            recording = FlightRecordingLoader.loadFile(new File(filePath));
            IView view = recording.createView();
            viewList.add(view);
        }
    }


    public ArrayList<IView> getJFRRecording(){
        return viewList;
    }

    public void getCPUEvents(){
        for (IView view:viewList) {

            String index = Integer.toString(viewList.indexOf(view));
            CPULoadHandler cpuLoadHandler = new CPULoadHandler(view);
            ArrayList<CPULoadEvent> eventList = cpuLoadHandler.getEventSeries();
            csvWriter.printCPUOutput(eventList,index);

        }
    }

    public void getGCEvents() {
        for (IView view:viewList) {
            String index = Integer.toString(viewList.indexOf(view));
            GCTimeSeriesModel gcModel = new GCTimeSeriesModel(view);
            ArrayList<Integer> stateSequence = gcModel.getOuputOne();
            csvWriter.printGCOutputOne(stateSequence, index);
        }
    }

    public void refreshViewList(){
        viewList = new ArrayList<IView>();
    }
}
