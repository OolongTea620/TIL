package h1.config;

import h1.answer.Length;

public class Option {
    private Length answerOption;

    public Option(int answerLength) {
        switch (answerLength) {
            case 3:
                this.answerOption = Length.THREE;
                break;
            case 4:
                this.answerOption = Length.FOUR;
                break;
            case 5:
                this.answerOption = Length.FIVE;
                break;
            default:
                this.answerOption = Length.THREE;
        }
    }

    public int getLengthValue() {
        return this.answerOption.getValue();
    }

}
