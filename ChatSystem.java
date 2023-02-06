/**
 * This class implements a chat system. It is the top level class in this project.
 * The system communicates via text input/output in the text terminal.
 *
 * This class uses an object of class InputReader to read input from the user,
 * and an object of class ChatBot to generate responses. A loop repeatedly
 * reads input and generates output until the users wants to leave.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 0.1 (2016.02.29)
 */
public class ChatSystem {
    private InputReader reader;
    private ChatBot chatbot;

    /**
     * Creates a technical support system.
     */
    public ChatSystem() {
        reader = new InputReader();
        chatbot = new ChatBot();
    }

    /**
     * Start the chat system. This will print a welcome message and
     * enter into a dialog with the user, until the user ends the dialog.
     */
    public void start() {
        boolean finished = false;
        printWelcome();
        while (!finished) {
            String input = reader.getInput().trim().toLowerCase();
            if (input.startsWith("bye")) {
                finished = true;
            } else {
                String response = chatbot.generateResponse(input);
                System.out.println(response);
            }
        }
        printGoodbye();
    }

    /**
     * Print a welcome message to the screen.
     */
    private void printWelcome() {
        System.out.println("Welcome to the Talk-A-Lot Chat System.");
        System.out.println();
        System.out.println("Please tell us about your problem.");
        System.out.println("We will assist you with any problem you might have.");
        System.out.println("Please type 'bye' to exit our system.");
    }

    /**
     * Print a good-bye message to the screen.
     */
    private void printGoodbye() {
        System.out.println("Nice talking to you. Bye...");
    }
}