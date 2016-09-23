package com.taz.jfrparser.core;

/**
 * Created by mani on 9/23/16.
 */
public abstract class JFREvent {
    long startTimestamp;
    long endTimestamp;
    String EVENT_TYPE;

    public JFREvent(String eventType) {
        this.EVENT_TYPE = eventType;
    }

    public long getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(long startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public long getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(long endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    @Override
    public String toString(){
        return "Event Type="+this.EVENT_TYPE ;
    }

}
