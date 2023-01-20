package dk.kraften.jail.Utils;

public class Placeholder {
    private String identifier, replacement;

    public Placeholder(String identifier, String replacement) {
        this.identifier = identifier;
        this.replacement = replacement;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getReplacement() {
        return replacement;
    }
}
