package Enums;

public enum PieceType {
    EMBER("🔥"),
    FROST("❄️"),
    STORM("⚡"),
    THORN("🌿");

    private final String emote;

    PieceType(String emote){
        this.emote = emote;
    }

    public String getEmote(){
        return this.emote;
    }
}
