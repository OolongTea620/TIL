package h1;

import h1.manager.Game;

public class Main {
    private static Game game;

    public static void main(String[] args) {
        game = new Game();
        game.run();
    }

}
