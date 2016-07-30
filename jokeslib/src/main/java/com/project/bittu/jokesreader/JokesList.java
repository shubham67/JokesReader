package com.project.bittu.jokesreader;

import java.util.ArrayList;

public class JokesList {

    static ArrayList<String> paidJokes = new ArrayList<>();
    static ArrayList<String> freeJokes = new ArrayList<>();

    public static ArrayList<String> getPaidJokes() {
        paidJokes.add("It is so cold outside I saw a politician with his hands in his own pockets.");
        paidJokes.add("I can't believe I forgot to go to the gym today. That's 7 years in a row now.");
        paidJokes.add("What day does the egg fear the most? Friday.");
        paidJokes.add("There are 10 types of people in the world: those who understand binary, and those who don't.");
        paidJokes.add("I was having dinner with Garry Kasporov (world chess champion) and there was a check tablecloth. It took him two hours to pass me the salt.");
        paidJokes.add("Question: \"What's The Difference Between A Good Lawyer And A Great Lawyer?\"\nAnswer: \"A Good Lawyer Knows The Law And A Great Lawyer Knows The Judge\"");
        paidJokes.add("Q: What did the gangster's son tell his dad when he failed his examination?\n" +
                "A: Dad they questioned me for 3 hours but I never told them anything");
        paidJokes.add("What's the similarity between Income Tax and a Caller Tune?\n" +
                "In both the cases, one pays the money and others enjoy.");
        paidJokes.add("Boss hangs a poster in Office\n" +
                "\"I AM THE BOSS, DO NOT FORGET\"\n" +
                "He returns from lunch, finds a slip on his desk.\n" +
                "\"Ur wife called, she wants her poster back home.\"");
        paidJokes.add("Husband brings the child home from kindergarten and asks his wife, \"He's been crying the whole way home. Isn't he sick or something?\"\n\"No,\" replies the wife, \"he was just trying to tell you he isn't our Frankie.\"");
        paidJokes.add("Why do Java developers wear glasses? Because they can't C#");
        return paidJokes;
    }

    public static ArrayList<String> getFreeJokes() {

        freeJokes.add("Husband brings the child home from kindergarten and asks his wife, \"He's been crying the whole way home. Isn't he sick or something?\"\n\"No,\" replies the wife, \"he was just trying to tell you he isn't our Frankie.\"");
        freeJokes.add("Why do Java developers wear glasses? Because they can't C#");
        freeJokes.add("Q: What did the gangster's son tell his dad when he failed his examination?\n" +
                "A: Dad they questioned me for 3 hours but I never told them anything");
        freeJokes.add("What's the similarity between Income Tax and a Caller Tune?\n" +
                "In both the cases, one pays the money and others enjoy.");
        freeJokes.add("Boss hangs a poster in Office\n" +
                "\"I AM THE BOSS, DO NOT FORGET\"\n" +
                "He returns from lunch, finds a slip on his desk.\n" +
                "\"Ur wife called, she wants her poster back home.\"");
        freeJokes.add("It is so cold outside I saw a politician with his hands in his own pockets.");
        return freeJokes;
    }
}
