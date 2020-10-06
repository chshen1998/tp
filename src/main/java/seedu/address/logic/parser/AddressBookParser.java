package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.UndoCommand;
import seedu.address.logic.commands.patientcommands.HelpCommand;
import seedu.address.logic.commands.patientcommands.PatientAddCommand;
import seedu.address.logic.commands.patientcommands.PatientDeleteCommand;
import seedu.address.logic.commands.patientcommands.PatientEditCommand;
import seedu.address.logic.commands.patientcommands.PatientFindCommand;
import seedu.address.logic.commands.patientcommands.PatientListCommand;
import seedu.address.logic.commands.patientcommands.PatientRemarkCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.logic.parser.patientparser.AddCommandParser;
import seedu.address.logic.parser.patientparser.DeleteCommandParser;
import seedu.address.logic.parser.patientparser.EditCommandParser;
import seedu.address.logic.parser.patientparser.FindCommandParser;
import seedu.address.logic.parser.patientparser.RemarkCommandParser;

/**
 * Parses user input.
 */
public class AddressBookParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {

        case PatientAddCommand.COMMAND_WORD:
            return new AddCommandParser().parse(arguments);

        case PatientEditCommand.COMMAND_WORD:
            return new EditCommandParser().parse(arguments);

        case PatientDeleteCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case PatientFindCommand.COMMAND_WORD:
            return new FindCommandParser().parse(arguments);

        case PatientListCommand.COMMAND_WORD:
            return new PatientListCommand();

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case PatientRemarkCommand.COMMAND_WORD:
            return new RemarkCommandParser().parse(arguments);

        case UndoCommand.COMMAND_WORD:
            return new UndoCommand();


        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
