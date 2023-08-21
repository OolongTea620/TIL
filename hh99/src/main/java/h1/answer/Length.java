package h1.answer;

public enum Length {
    THREE(3),
    FOUR(4),
    FIVE(5);

    private final int value;

    Length(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
