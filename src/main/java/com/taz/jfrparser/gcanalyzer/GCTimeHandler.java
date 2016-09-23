package com.taz.jfrparser.gcanalyzer;

import com.jrockit.mc.flightrecorder.spi.IEvent;
import com.jrockit.mc.flightrecorder.spi.IView;
import com.taz.jfrparser.core.EventHandler;

import java.util.Map;

public class GCTimeHandler extends EventHandler{
    private final Map<Long,MemEvent> eventMap;

    public GCTimeHandler(IView view, Map<Long,MemEvent> eventMap){
        super(view,"Garbage Collection");
        this.eventMap = eventMap;
    }

    public void getEventSeries() {
        for (IEvent event : view) {
            if(EVENT_TYPE.equals(event.getEventType().getName())){
                MemEvent memEvent = new MemEvent();
                memEvent.setStartTimestamp(event.getStartTimestamp());
                memEvent.setEndTimestamp(event.getEndTimestamp());
                memEvent.setGcId(Long.parseLong(event.getValue("gcId").toString()));
                if(!eventMap.containsKey(memEvent.getGcId())){
                    eventMap.put(memEvent.getGcId(),memEvent);
                }
                else {
                    System.out.println("gcID already exists!");
                }
            }
        }
    }
}
