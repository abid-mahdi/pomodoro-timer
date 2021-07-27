package dev.abidmahdi;

public class Controller {

    public Controller(Model model, View view) {
        view.getStartPauseBtn().setOnAction((e) -> {
            if (model.isRunning()) {
                model.pauseTimer();
                model.setRunning(false);
            } else {
                model.startTimer();
                model.setRunning(true);
            }
        });
    }
}
