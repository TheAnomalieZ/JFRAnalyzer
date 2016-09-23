package com.taz.jfrparser.cpuanalyzer;

import com.jrockit.mc.flightrecorder.spi.IEvent;
import com.jrockit.mc.flightrecorder.spi.IView;
import com.taz.jfrparser.core.EventHandler;
import com.taz.jfrparser.core.JFREvent;

import java.util.ArrayList;

public class CPULoadHandler extends EventHandler {
    public ArrayList<CPULoadEvent> eventList;
    public CPULoadHandler(IView view){
        super(view,"CPU Load");
        eventList = new ArrayList<CPULoadEvent>();
    }

    public ArrayList<CPULoadEvent> getEventSeries() {
        for (IEvent event : view) {
            if(EVENT_TYPE.equals(event.getEventType().getName())){
                CPULoadEvent cpuLoadEvent = new CPULoadEvent();

                cpuLoadEvent.setStartTimestamp(event.getStartTimestamp());
                cpuLoadEvent.setEndTimestamp(event.getEndTimestamp());

                cpuLoadEvent.setJvmUser(event.getValue("jvmUser").toString());
                cpuLoadEvent.setJvmSystem(event.getValue("jvmSystem").toString());
                cpuLoadEvent.setMachineTotal(event.getValue("machineTotal").toString());

                eventList.add(cpuLoadEvent);
            }
        }
        return eventList;
    }

}
