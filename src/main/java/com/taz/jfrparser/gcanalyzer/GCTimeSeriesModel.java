package com.taz.jfrparser.gcanalyzer;

import com.jrockit.mc.flightrecorder.spi.IView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class GCTimeSeriesModel {
    private IView view;
    private Map<Long,MemEvent> eventMap;
    private GCTimeHandler gcTimeHandler;
    private GCMemoryHandler gcMemoryHandler;
    private StateIdentifier stateIdentifier;
    private ArrayList<Integer> stateSequence;

    public GCTimeSeriesModel(IView view){
        this.view = view;
        eventMap = new LinkedHashMap<Long, MemEvent>();

    }


    public ArrayList<Integer> getOuputOne(){
        gcTimeHandler= new GCTimeHandler(view, eventMap);
        gcTimeHandler.configureEventGCTime();

        gcMemoryHandler= new GCMemoryHandler(view, eventMap);
        gcMemoryHandler.configureGCMemory();

        stateIdentifier= new StateIdentifier(eventMap);
        stateSequence = stateIdentifier.configureStates();

        return stateSequence;
    }
}
