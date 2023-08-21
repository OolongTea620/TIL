package h1.answer;

public class AnswerMaker {
    private int randomLength;
    public AnswerMaker(int length) {
        this.randomLength = length;
    }
    private static int makeRandomInt() {
        double dValue = Math.random();
        return (int) (dValue * 10);
    }

    public Answer makeAnswer() {
        Answer answer = new Answer(this.randomLength);
        int[] numberChart = new int[10];
        for (int i =0; i < this.randomLength; i++) {
            int num = makeRandomInt();
            if (numberChart[num] > 0) {
                i--;
            }else {
                numberChart[num] = 1;
                answer.addNum(i, num);
            }
        }
        return answer;
    }
}
