/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.core.launcher;

import java.beans.PropertyChangeEvent;
import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

/**
 *
 * @author tina
 */
public class AfficheurHeureSurConsole implements TimerChangeListener {

    @Override
    public void propertyChange(String propertyName, Object oldValue, Object newValue) {

        TimerService ts = Lookup.getInstance().getService(TimerService.class);

        System.out.println("" + ts.getHeures() + ":" + ts.getMinutes() + ":" + ts.getSecondes() + "," + ts.getDixiemeDeSeconde());
    }

    // cette méthode provient du PropertyChangeListener
    // à utiliser plustard !
    @Override
    public void propertyChange(PropertyChangeEvent pce) {

        TimerService ts = Lookup.getInstance().getService(TimerService.class);
        Integer hou = ts.getHeures();
        Integer min = ts.getMinutes();
        Integer dis = ts.getDixiemeDeSeconde();
        Integer sec = ts.getSecondes();

        /*
         * Integer hou=0; Integer min=0; Integer dis=0; Integer sec=0;
         * 
         */
        if ("hou".equals(pce.getPropertyName()))
            hou = (Integer) pce.getNewValue();
        else if ("min".equals(pce.getPropertyName()))
            min = (Integer) pce.getNewValue();
        if ("sec".equals(pce.getPropertyName()))
            sec = (Integer) pce.getNewValue();
        if ("dissec".equals(pce.getPropertyName()))
            dis = (Integer) pce.getNewValue();

        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
    }

}
