package h1.board;

public class Score {
    private int strike;
    private int ball;

    public Score() {
        this.strike = 0;
        this.ball = 0;
    }

    public void addStrike() {
        this.strike += 1;
    }

    public void addBall() {
        this.ball += 1;
    }
}
