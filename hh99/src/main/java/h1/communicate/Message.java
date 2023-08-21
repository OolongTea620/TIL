package h1.communicate;

public enum Message {
    Start("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!"),
    Try("%d번째 시도 : "),
    Score("%dS%dB"),
    End("%d번만에 맞히셨습니다%n게임을 종료합니다");

    private final String text;
    Message(String message) {
        this.text = message;
    }

    public String message() {
        return this.text;
    }

    public String message(int try_times) {
        return String.format(this.text, try_times);
    }

    public String message(int strike, int ball) {
        return String.format(this.text, strike, ball);
    }

}
