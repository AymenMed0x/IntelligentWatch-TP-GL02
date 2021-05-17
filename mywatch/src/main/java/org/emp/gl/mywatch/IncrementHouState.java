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


public class IncrementHouState extends WatchState {

    IncrementHouState(MyWatch myWatch) {
        super(myWatch);
        // TODO Auto-generated constructor stub
        GuiControl gc = (GuiControl) Lookup.getInstance().getService(GuiControl.class);
        gc.set_state_name("Hour");
        

        System.out.println("inchou state");
    }

    @Override
    public void config() {
        TimerService ts = Lookup.getInstance().getService(TimerService.class);
        GuiDisplay gDisplay = (GuiDisplay) Lookup.getInstance().getService(TimerChangeListener.class);
        ts.addTimeChangeListener(gDisplay);
       
        myWatch.set_satate(new NormalState(myWatch));
        
    }


    @Override
    public void mode() {

       myWatch.set_satate(new IncrementSecState(myWatch));

    }



    @Override
    public void increment() {
        myWatch.updateHeures2();
        
        System.out.println("inchou state inc");
    }

}
