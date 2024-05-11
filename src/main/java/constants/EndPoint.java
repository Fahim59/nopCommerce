package constants;

public enum EndPoint {
    REGISTRATION("/register?returnUrl=%2F");

    public final String url;

    EndPoint(String url) {
        this.url = url;
    }
}
