/**
 *  Carvoyant Connected Car
 *
 *  Copyright 2014 Carvoyant
 *
 */
metadata 
{
    definition (name: "Connected Car", namespace: "carvoyant", author: "Carvoyant") 
    {
        capability "presenceSensor"
        capability "sensor"
        attribute "ignitionStatus", "string"
        attribute "name", "string"
        command "setIgnitionStatus"
        command "setPresence"
    }
  
    tiles 
    {
        standardTile("ignitionStatus", "device.ignitionStatus", width: 2, height: 2) 
        {
    	    state "ON", label: 'On', action: "switch.off", icon: "st.presence.car.car", backgroundColor: "#00FF00"
    	    state "OFF", label: 'Off', action: "switch.on", icon: "st.presence.car.car", backgroundColor: "#FF0000"
        }
        
        main "ignitionStatus"
        details("ignitionStatus")
    }
}

def init()
{
    sendEvent(name: "ignitionStatus",   value: "OFF")
}

def setPresence(String presence)
{
    sendEvent(name: "presence",   value: presence)
}

def setIgnitionStatus(ignitionStatus)
{
    sendEvent(name: "ignitionStatus",   value: ignitionStatus.toUpperCase())
}
