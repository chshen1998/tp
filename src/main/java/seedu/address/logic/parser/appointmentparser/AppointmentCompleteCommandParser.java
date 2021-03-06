package seedu.address.logic.parser.appointmentparser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.appointmentcommands.AppointmentCompleteCommand;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new AppointmentCompleteCommand object
 */
public class AppointmentCompleteCommandParser {

    /**
     * Parses the given {@code String} of arguments in the context of the AppointmentCompleteCommand
     * and returns a AppointmentCompleteCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AppointmentCompleteCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new AppointmentCompleteCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, AppointmentCompleteCommand.MESSAGE_USAGE), pe);
        }
    }
}
