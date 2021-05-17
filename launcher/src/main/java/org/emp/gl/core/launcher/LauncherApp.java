package org.emp.gl.core.launcher;

import org.emp.gl.action.Action;
import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.gui.control.GuiControl;
import org.emp.gl.gui.display.GuiDisplay;
import org.emp.gl.mywatch.MyWatch;
// import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;
import org.emp.gl.timer.service.impl.withdelegation.TimerServiceImplWithDelegation;


/**
 * 
 * 
 * 
 * Hello world!
 *
 */
public class LauncherApp {

    // ce code nous permettra d'enregistrer les service que notre application
    // utilsiera
    // lors de l'execution
    static {
        // Lookup.getInstance().register(TimerService.class, new
        // DummyTimeServiceImpl());
        //Lookup.getInstance().register(TimerService.class, new TimerServiceImplWithDelegation());
        // Lookup.getInstance().register(TimerChangeListener.class, new GuiDisplay());
        MyWatch myWatch = new MyWatch();
        Lookup.getInstance().register(TimerService.class, myWatch);
        Lookup.getInstance().register(Action.class, myWatch);
        Lookup.getInstance().register(TimerChangeListener.class, new GuiDisplay());

        Lookup.getInstance().register(GuiControl.class, new GuiControl());
        

    }

    public static void main(String[] args) {

        GuiDisplay gd = (GuiDisplay) Lookup.getInstance().getService(TimerChangeListener.class);
        gd.Run(args);
        GuiControl gc = (GuiControl) Lookup.getInstance().getService(GuiControl.class);
        gc.Run(args);
        testDuTimeService();

        

    }

    private static void testDuTimeService() {

        TimerService ts = Lookup.getInstance().getService(TimerService.class);
        ts.addTimeChangeListener(Lookup.getInstance().getService(TimerChangeListener.class));
        // ts.addTimeChangeListener(gd);



        // ts.addTimeChangeListener(new CompteARebour(5 + (int)(Math.random() * 10)));

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
