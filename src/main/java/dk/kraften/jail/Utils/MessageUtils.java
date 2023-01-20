package dk.kraften.jail.Utils;

public class MessageUtils {

    public static String processPlaceholders(String message, Placeholder... placeholders) {
        for (Placeholder p : placeholders) { // Looping through all the given placeholders
            if (message.contains(p.getIdentifier())) { // Check if the message contains the placeholder
                message = message.replace(p.getIdentifier(), p.getReplacement()); // If so replace it
            }
        }
        return message;
    }
}
