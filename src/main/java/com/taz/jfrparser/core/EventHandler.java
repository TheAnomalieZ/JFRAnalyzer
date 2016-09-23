package com.taz.jfrparser.core;

import com.jrockit.mc.flightrecorder.spi.IView;
import java.util.ArrayList;


/**
 * Created by Maninesan on 9/23/16.
 */
public abstract class EventHandler {
    public IView view;
    public String EVENT_TYPE;

    public EventHandler(IView view, String eventType){
        this.view = view;
        this.EVENT_TYPE = eventType;
    }

    @Override
    public String toString(){
        return "Event Handler Type="+this.EVENT_TYPE+" Handler" ;
    }
}
