package com.adventuregame.monsters;

import java.util.Random;

public class Snake extends Monster {
    private static Random random = new Random();

    public Snake() {
        super(4, "Snake", random.nextInt(3,7), 12, 0);
    }
}
