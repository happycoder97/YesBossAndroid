package com.world.farzeen.yesboss;

import android.text.format.Time;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by farzeen on 10/26/15.
 */
public class Status {
    public byte temperatureC;
    public byte waterLevel;
    private List<Boolean> deviceStatus;

    public Status() {
        deviceStatus = new ArrayList<Boolean>();
        for(byte b=0;b<8;b++) deviceStatus.add(false);
        temperatureC = 0;
        waterLevel = 0;
    }

    /* set a number of devices to on or off */
    public void setDevice(List<Integer> devices,boolean on) {
        for(Integer i:devices) {
            deviceStatus.set(i,on);
        }
    }
    /* set a device to on or off */
    public void setDevice(Integer device,boolean on) {
        deviceStatus.set(device,on);
    }

    public List<Integer> getDevicesForStatus(boolean on) {
        ArrayList<Integer> devices = new ArrayList<Integer>();
        for(Integer b=0;b<deviceStatus.size();b++) {
            if(on==deviceStatus.get(b)) devices.add(b);
        }
        return devices;
    }

    public void clear() {
        for(byte b=0;b<8;b++) deviceStatus.set(b,false);
        temperatureC = 0;
        waterLevel = 0;
    }

}
