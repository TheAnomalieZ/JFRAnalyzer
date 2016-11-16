package com.taz.jfrparser.core;

import com.jrockit.mc.flightrecorder.spi.IView;
import com.taz.jfrparser.cpuanalyzer.CPULoadHandler;
import com.taz.jfrparser.gcanalyzer.GCTimeSeriesModel;

/**
 * Created by  Maninesan
 */
public class EventHandlerFactory {

    public CPUHandler getCPULoadHandler(IView view){
        return new CPULoadHandler(view);
    }

    public GCHandler getGCHandler(IView view){
        return  new GCTimeSeriesModel(view);
    }

}
