package com.example.numbergame;

import java.util.Random;

public class NumberGame {

    public int RandomNumber;

   private int GuessedNumber;

    public NumberGame(int guessedNumber) {
        GuessedNumber = guessedNumber;
    }

    public int getRandomNumber() {
        return RandomNumber;
    }


    public int getGuessedNumber() {
        return GuessedNumber;
    }

    public void setGuessedNumber(int guessedNumber) {
        GuessedNumber = guessedNumber;
    }

    public int RandomNumberGenrator()
    {
        Random random = new Random();
        this.RandomNumber = 1+random.nextInt(99);
        return this.RandomNumber;
    }

    public String CheckTheGuess()
    {
        if(this.GuessedNumber==this.RandomNumber)
        {
            return  "Guessed it Right";
        } else if (this.GuessedNumber>=this.RandomNumber+1 && this.GuessedNumber<=this.RandomNumber+10) {
            return "So Close but High";
        } else if (this.GuessedNumber<=this.RandomNumber-1&&this.GuessedNumber>=this.RandomNumber-10) {
            return " So Close but low";
        } else if (this.GuessedNumber>=this.RandomNumber+11) {
            return "too high";
        }
        else {
            return "too Low";
        }
    }
}
