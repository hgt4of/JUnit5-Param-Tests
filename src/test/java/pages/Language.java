package pages;

public enum Language {
    ENGLISH("en", "English", "Wikipedia"),
    FRENCH("fr", "Français", "Wikipédia"),
    GERMAN("de", "Deutsch", "Wikipedia"),
    ITALIAN("it", "Italiano", "Wikipedia"),
    SPANISH("es", "Español", "Wikipedia");

    public final String code;
    public final String buttonText;
    public final String expectedTitle;

    Language(String code, String buttonText, String expectedTitle) {
        this.code = code;
        this.buttonText = buttonText;
        this.expectedTitle = expectedTitle;
    }
}