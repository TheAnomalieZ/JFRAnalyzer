package com.taz.jfrparser.core;

public abstract class JFREvent {
    protected long startTimestamp;
    protected long endTimestamp;
    protected String EVENT_TYPE;

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
