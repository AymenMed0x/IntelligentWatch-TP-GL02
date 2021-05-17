/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.mywatch;


public abstract class WatchState {
    MyWatch myWatch;

    WatchState(MyWatch myWatch) {
        this.myWatch = myWatch;
    }

    public void config() {

    }

    public void mode() {

    }

    public void increment() {

    }

}
