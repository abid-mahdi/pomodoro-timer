package dev.abidmahdi;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.Timer;
import java.util.TimerTask;

public class Model {

    private boolean isRunning = false;
    private boolean isBreak = false;
    private Timer timer = new Timer();
    private int counter = 60 * 25; // 60 * 25 Testing:10
    private final Label timerLbl, studySessionLbl, whatsNextLbl;
    private int seconds, minutes, studySessionNum =0;

    public Model(Label timerLbl, Label studySessionLbl, Label whatsNextLbl) {
        this.timerLbl = timerLbl;
        this.studySessionLbl = studySessionLbl;
        this. whatsNextLbl = whatsNextLbl;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public void pauseTimer() {
        timer.cancel();
    }

    public void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    counter--;

                    minutes = counter / 60;
                    seconds = counter % 60;

                    String minsStr = minutes < 10 ? "0" + minutes : String.valueOf(minutes);
                    String secStr = seconds < 10 ? "0" + seconds: String.valueOf(seconds);

                    timerLbl.setText(minsStr + ":" + secStr);

                    if (counter == 0 && studySessionNum == 4 && !isBreak) { // long break
                        isBreak = true;
                        counter = 15 * 60;
                        studySessionNum = 0;
                    } else if (counter == 0 && !isBreak) { // short break
                        counter = 5 * 60;
                        isBreak = true;
                    } else if (counter == 0) { // break finished
                        counter = 25 * 60;
                        studySessionNum++;
                        isBreak = false;
                    }

                    // update labels
                    studySessionLbl.setText("Study session number: " + studySessionNum);
                    if (isBreak) whatsNextLbl.setText("Next: Study session (25 minutes)");
                    else if (studySessionNum == 4) whatsNextLbl.setText("Next: Long study break (15 minutes)");
                    else whatsNextLbl.setText("Next: Short study break (5 minutes)");
                });
            }
        }, 0, 1000);
    }

}
