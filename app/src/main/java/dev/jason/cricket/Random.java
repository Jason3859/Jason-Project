package dev.jason.cricket;

import java.util.Arrays;
import java.util.List;

public class Random {
    private final java.util.Random random = new java.util.Random();

    public int randomInt() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        return numbers.get(random.nextInt(numbers.size()));
    }

    public String computerChoice() {
        List<String> choices = Arrays.asList("Bat", "Ball");
        return choices.get(random.nextInt(choices.size()));
    }
}
