package com.taz.jfrparser.core;

import com.taz.jfrparser.cpuanalyzer.CPULoadEvent;

import java.util.ArrayList;

/**
 * Created by  Maninesan on 11/16/16.
 */
public interface CPUHandler {
    ArrayList<CPULoadEvent> getEventSeries();
}
