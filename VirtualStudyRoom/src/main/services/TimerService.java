package main.services;

import main.models.Timer;

public class TimerService {
    private boolean isRunning = false;

    public void startTimer(Timer timer) {
        if (isRunning) {
            System.out.println("❌ A timer is already running.");
            return;
        }

        isRunning = true;
        System.out.println("⏳ Timer started for " + timer.getDuration() + " minutes.");

        for (int i = timer.getDuration(); i > 0; i--) {
            if (!isRunning) {
                System.out.println("⏸ Timer stopped.");
                return;
            }
            System.out.println("⏳ Time left: " + i + " minutes");

            try {
                Thread.sleep(60000); // Wait for 1 minute (60,000 milliseconds)
            } catch (InterruptedException e) {
                System.out.println("⚠️ Timer interrupted.");
                return;
            }
        }

        if (isRunning) {
            System.out.println("🎉 Time's up!");
        }
        isRunning = false;
    }

    public void stopTimer() {
        isRunning = false;
    }
}
