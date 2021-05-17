/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.mywatch;

import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.gui.control.GuiControl;
import org.emp.gl.gui.display.GuiDisplay;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;


public class NormalState extends WatchState {

    NormalState(MyWatch myWatch) {
        super(myWatch);
        // TODO Auto-generated constructor stub
        
        System.out.println("normal state");
    }

    @Override
    public void config() {

        
        System.out.println("normal state config");
        GuiControl guicontrol = (GuiControl) Lookup.getInstance().getService(GuiControl.class);
        guicontrol.Run(null);
        //TimerService ts =Lookup.getInstance().getService(TimerService.class);
        //GuiDisplay gDisplay = (GuiDisplay) Lookup.getInstance().getService(TimerChangeListener.class);
        //ts.removeTimeChangeListener(gDisplay);
        //gDisplay.setVisible(false);

        
        GuiControl guiControl= Lookup.getInstance().getService(GuiControl.class);
       
        myWatch.set_satate(new IncrementSecState(myWatch));
    }

    @Override
    public void mode() {
        myWatch.set_satate(new IncrementSecState(myWatch));
        System.out.println("normal state mode");
    }

}
