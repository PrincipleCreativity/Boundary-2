package org.principlecreativity.boundary2.common.util;

import java.util.Date;
import java.util.TimerTask;

public class ModTimer extends java.util.Timer {
    public void schedule(Task task, Date time) {
        super.schedule(new TimerTask() {
            @Override
            public void run() {
                task.run();
            }
        }, time);
    }

    public void schedule(Task task, long delay) {
        super.schedule(new TimerTask() {
            @Override
            public void run() {
                task.run();
            }
        }, delay);
    }
    public void schedule(Task task, long delay, long period) {
        super.schedule(new TimerTask() {
            @Override
            public void run() {
                task.run();
            }
        }, delay, period);
    }

    public void schedule(Task task, Date firstTime, long period) {
        super.schedule(new TimerTask() {
            @Override
            public void run() {
                task.run();
            }
        }, firstTime, period);
    }
}
