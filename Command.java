public enum Command {
    CREATE("create", "creates a new note"),
    READ("read", "reads a note"),
    UPDATE("update", "updates a note"),
    LINKS("links", "lists all links in a note"),
    TAG("tag", "tags a note"),
    UNTAG("untag", "untags a note"),
    TAGS("tags", "lists all tags in alphabetical order"),
    TAGGED("tagged", "lists all tagNotes with a specific tag"),
    TRENDING("trending", "lists the most popular tags"),
    NOTES("tagNotes", "lists all tagNotes of a given type last edited within a given time interval"),
    DELETE("delete", "deletes a note"),
    HELP("help", "shows the available commands"),
    EXIT("exit", "terminates the execution of the program");

    private final String commandName;
    private final String description;

    Command(String commandName, String description) {
        this.commandName = commandName;
        this.description = description;
    }

    public String getCommandName() {
        return commandName;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Returns the Command enum constant that matches the given string.
     *
     * @param text the string to match
     * @return the matching Command enum constant, or null if no match is found
     */
    public static Command fromString(String text) {
        for (Command command : Command.values()) {
            if (command.getCommandName().equals(text)) {
                return command;
            }
        }
        return null;
    }

    /**
     * Returns a string with all available commands and their descriptions.
     *
     * @return a string with all available commands and their descriptions
     */
    public static String getAllCommandsDescription() {
        return """
                create - creates a new note
                read - reads a note
                update - updates a note
                links - lists all links in a note
                tag - tags a note
                untag - untags a note
                tags - lists all tags in alphabetical order
                tagged - lists all tagNotes with a specific tag
                trending - lists the most popular tags
                tagNotes - lists all tagNotes of a given type last edited within a given time interval
                delete - deletes a note
                help - shows the available commands
                exit - terminates the execution of the program
                """;

    }
}