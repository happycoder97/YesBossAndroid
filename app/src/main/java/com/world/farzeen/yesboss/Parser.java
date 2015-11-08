package com.world.farzeen.yesboss;

/**
 * Created by farzeen on 11/4/15.
 */
public class Parser {

    Status status = new Status();
    private static final String MAGIC = "$SUCCESS";
    private enum Mode { ON,OFF,WATERLEVEL,TEMP };

    public Status parse(String message) {
        status.clear();
        message = message.replace('\n',' ');
        message = message.replace('\r',' ');
        String[] tokens = message.split(" ");
        if(!tokens[0].equals(MAGIC)) return null;
        Mode mode = null;
        for(String tok:tokens) {
            if (tok.equals("ON")) mode = Mode.ON;
            else if (tok.equals("OFF")) mode = Mode.OFF;
            else if (tok.equals("WATERLEVEL")) mode = Mode.WATERLEVEL;
            else if (tok.equals("TEMP")) mode = Mode.TEMP;
            else if (mode == null) return null;
            else {
                switch (mode) {
                    case ON:
                    case OFF:
                        try {
                            Integer dev_no = Integer.parseInt(tok);
                            status.setDevice(dev_no, mode == Mode.ON);
                        } catch (NumberFormatException ne) {
                            return null;
                        }
                        break;
                    case TEMP:
                        try {
                            //remove the C at the end of temperature. eg. 30C
                            status.temperatureC = Byte.parseByte(tok.substring(0, tok.length() - 2));
                        } catch (NumberFormatException ne) {
                            return null;
                        }
                        break;
                    case WATERLEVEL:
                        try {
                            //remove the % at the end of waterlevel. eg. 50%
                            status.waterLevel = Byte.parseByte(tok.substring(0, tok.length() - 2));
                        } catch (NumberFormatException ne) {
                            return null;
                        }
                        break;
                }
            }
        }
        return status;
    }
}
