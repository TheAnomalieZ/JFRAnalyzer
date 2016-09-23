package com.taz.jfrparser.gcanalyzer;

import com.jrockit.mc.flightrecorder.spi.IEvent;
import com.jrockit.mc.flightrecorder.spi.IView;
import com.taz.jfrparser.core.EventHandler;

import java.util.Map;

public class GCMemoryHandler extends EventHandler {
    private final Map<Long, MemEvent> eventMap;

    public GCMemoryHandler(IView view, Map<Long, MemEvent> eventMap) {
        super(view,"Heap Summary");
        this.eventMap = eventMap;
    }

    public void getEventSeries() {
        for (IEvent event : view) {
            if (EVENT_TYPE.equals(event.getEventType().getName())) {
                if(event.getValue("when").toString().equals("Before GC")){
                    long gcID = Long.parseLong(event.getValue("gcId").toString());
                    if (eventMap.containsKey(gcID)){
                        MemEvent memEvent = eventMap.get(gcID);
                        memEvent.setUsedHeap(Long.parseLong(event.getValue("heapUsed").toString()));
                    }
                    else {
                        System.out.println("gcID doesn't exist!");
                    }
                }
            }
        }
    }
}
