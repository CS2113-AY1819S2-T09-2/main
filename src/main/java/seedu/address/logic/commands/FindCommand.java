package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.Messages;
import seedu.address.logic.CommandHistory;

//import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
//import seedu.address.model.task.Task;
import seedu.address.model.task.TaskContainsKeywordsPredicate;
//import static seedu.address.logic.parser.CliSyntax.*;
//import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
//import static java.util.Objects.requireNonNull;
//import seedu.address.logic.CommandHistory;
//import seedu.address.model.Model;

/**
 * Finds and lists all tasks in address book whose name contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class FindCommand extends Command{
    public static final String COMMAND_WORD = "find";
    public static final String COMMAND_ALIAS = "f";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all tasks whose names contain any of "
            + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " cs2113t cs2101 cs3230";

    private final TaskContainsKeywordsPredicate predicate;

    public FindCommand(TaskContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model, CommandHistory history) {
        requireNonNull(model);
        //model.updateFilteredPersonList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_TASK_LISTED_OVERVIEW, model.getFilteredTaskList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof FindCommand // instanceof handles nulls
                && predicate.equals(((FindCommand) other).predicate)); // state check
    }

}
