package seedu.address.logic;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Thread used to check for newly missed appointments at regular intervals.
 */
public class TimerThread extends Thread {

    private Logic logic;
    private Boolean running;

    /**
     * Constructor for thread.
     * @param logic
     */
    public TimerThread(Logic logic) {
        this.logic = logic;
        this.running = true;
    }

    /**
     * Executes the AppointmentNesMissesCommand at regular intervals.
     */
    public void run() {
        while (running) {
            try {
                logic.refreshMissedAppointments();
            } catch (ParseException | CommandException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void setStop() {
        this.running = false;
    }
}
