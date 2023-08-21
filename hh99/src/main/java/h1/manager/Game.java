package h1.manager;

import h1.communicate.Input;
import h1.answer.Answer;
import h1.answer.AnswerMaker;
import h1.communicate.Message;
import h1.config.Option;

public class Game {
    Option option;
    GameStatus gameStatus;
    AnswerMaker answerMaker;
    private int tries;
    Answer answer;

    Input input;
    public Game() {
        this.tries = 0;
        this.gameStatus = GameStatus.Start;
        this.option = new Option(3);
        this.answer = new Answer(this.option.getLengthValue());
        this.answerMaker = new AnswerMaker(this.option.getLengthValue());
    }

    private void start() {
        this.answer = answerMaker.makeAnswer();
        System.out.println(Message.Start.message());
    }

    private void doTry() {
        while (this.gameStatus != GameStatus.End) {

        }
    }

    private void end() {
        System.out.println(Message.End.message(this.tries));
    }

    public void run() {
        this.start();
        this.doTry();
        this.end();
    }




}
