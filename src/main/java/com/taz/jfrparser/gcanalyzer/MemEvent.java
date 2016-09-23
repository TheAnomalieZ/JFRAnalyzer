package com.taz.jfrparser.gcanalyzer;

import com.taz.jfrparser.core.JFREvent;

public class MemEvent extends JFREvent {

    private long gcId;
    private long usedHeap;

    public MemEvent(){
        super("Garbage Collection");
    }

    public long getGcId() {
        return gcId;
    }

    public long getUsedHeap() {
        return usedHeap;
    }

    public void setGcId(long gcId) {
        this.gcId = gcId;
    }

    public void setUsedHeap(long usedHeap) {
        this.usedHeap = usedHeap;
    }
}
