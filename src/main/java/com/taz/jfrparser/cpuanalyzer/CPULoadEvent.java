package com.taz.jfrparser.cpuanalyzer;

import com.taz.jfrparser.core.JFREvent;

/**
 * Created by mani on 9/15/16.
 */
public class CPULoadEvent extends JFREvent {

    private String jvmUser;
    private String jvmSystem;
    private String machineTotal;

    public CPULoadEvent(){
        super("CPU Load");
    }

    public String getJvmUser() {
        return jvmUser;
    }

    public void setJvmUser(String jvmUser) {
        this.jvmUser = jvmUser;
    }

    public String getJvmSystem() {
        return jvmSystem;
    }

    public void setJvmSystem(String jvmSystem) {
        this.jvmSystem = jvmSystem;
    }

    public String getMachineTotal() {
        return machineTotal;
    }

    public void setMachineTotal(String machineTotal) {
        this.machineTotal = machineTotal;
    }


}
