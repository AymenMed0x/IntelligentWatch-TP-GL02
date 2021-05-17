/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.timer.service.impl.withdelegation;

import java.beans.PropertyChangeSupport;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class TimerServiceImplWithDelegation extends TimerTask implements TimerService {
    public int inchou = 0;
    public int incmin = 0;
    public int incsec = 0;
    public int dixiemeDeSeconde;
    public int minutes;
    public int secondes;
    public int heures;

    /**
     * Constructeur du DummyTimeServiceImpl Ici, nnous avons hérité de la classe
     * TimerTask, et nous nous avons utilisé un objet Timer, qui permet de réaliser
     * des tocs à chaque N millisecondes
     */
    public TimerServiceImplWithDelegation() {
        Timer timer = new Timer();

        LocalTime localTime = LocalTime.now();

        secondes = localTime.getSecond();
        minutes = localTime.getMinute();
        heures = localTime.getHour();
        dixiemeDeSeconde = localTime.getNano() / 100000000;

        timer.scheduleAtFixedRate(this, 100, 100);
    }

    @Override
    public void run() {
        timeChanged();
    }

    PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    @Override
    public void addTimeChangeListener(TimerChangeListener pl) {
        propertyChangeSupport.addPropertyChangeListener(pl);
        System.out.println(secondes);
        System.out.println(minutes);
    }

    @Override
    public void removeTimeChangeListener(TimerChangeListener pl) {
        propertyChangeSupport.removePropertyChangeListener(pl);

    }

    @Override
    public int getMinutes() {
        return minutes;
    }

    @Override
    public int getHeures() {
        return heures;
    }

    @Override
    public int getSecondes() {
        return secondes;
    }

    @Override
    public int getDixiemeDeSeconde() {
        return dixiemeDeSeconde;
    }

    private void timeChanged() {
        updateDixiemeDeSecode();
    }

    private void updateDixiemeDeSecode() {
        int oldValue = dixiemeDeSeconde;
        dixiemeDeSeconde = (dixiemeDeSeconde + 1) % 10;

        if (dixiemeDeSeconde == 0) {
            updateSecode();
        } else {
            this.propertyChangeSupport.firePropertyChange("dissec", null, dixiemeDeSeconde);

        }

    }

    public void updateSecode() {
        int oldValue = secondes;
        secondes = (secondes + 1) % 60;

        if (secondes == 0) {
            updateMinutes();
        } else {
            this.propertyChangeSupport.firePropertyChange("sec", oldValue, secondes);
        }

    }

    public void updateMinutes() {
        int oldValue = minutes;
        minutes = (minutes  + 1) % 60;

        if (minutes == 0) {
            updateHeures();
        } else {
            this.propertyChangeSupport.firePropertyChange("min", oldValue, minutes);

        }

    }

    public void updateHeures() {
        int oldValue = heures;
        heures = (heures  + 1) % 24;

        this.propertyChangeSupport.firePropertyChange("hou", oldValue, heures);
    }
    
    
    
    public void updateSecode2() {
        int oldValue = secondes;
        secondes = (secondes + 1) % 60;

        

    }

    public void updateMinutes2() {
        int oldValue = minutes;
        minutes = (minutes  + 1) % 60;

       

    }

    public void updateHeures2() {
        int oldValue = heures;
        heures = (heures  + 1) % 24;

    }

}