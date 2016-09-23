package com.taz.jfrparser.core;

import com.jrockit.mc.flightrecorder.FlightRecording;
import com.jrockit.mc.flightrecorder.FlightRecordingLoader;
import com.jrockit.mc.flightrecorder.spi.IView;

import java.io.File;

/**
 * Created by Maninesan on 9/23/16.
 */
public class JFRReader {

    private IView view;
    private FlightRecording recording;
    private static JFRReader jfrReader;

    public static JFRReader getInstance() {
        return jfrReader;
    }

    private JFRReader() {
        jfrReader = new JFRReader();
    }

    public void readJFR(String filepath){
        recording = FlightRecordingLoader.loadFile(new File(filepath));
        view = recording.createView();
    }

    public IView getJFRRecording(){
        return view;
    }
}
