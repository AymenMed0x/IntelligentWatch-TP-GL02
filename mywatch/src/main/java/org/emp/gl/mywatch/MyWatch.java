package org.emp.gl.mywatch;

import org.emp.gl.action.Action;
import org.emp.gl.mywatch.WatchState;
import org.emp.gl.timer.service.impl.withdelegation.TimerServiceImplWithDelegation;

public class MyWatch extends TimerServiceImplWithDelegation implements Action {

    WatchState watchState=new NormalState(this);


    public void set_satate(WatchState watchState) {
        this.watchState = watchState;
    }

    @Override
    public void doConfig() {
        // TODO Auto-generated method stub
        watchState.config();
    }

    @Override
    public void doIncrement() {
        // TODO Auto-generated method stub
        watchState.increment();
    }

    @Override
    public void doMode() {
        // TODO Auto-generated method stub
        watchState.mode();
    }

}
