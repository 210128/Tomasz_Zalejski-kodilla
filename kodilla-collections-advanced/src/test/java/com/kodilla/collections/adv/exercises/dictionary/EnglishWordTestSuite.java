package com.kodilla.collections.adv.exercises.dictionary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnglishWordTestSuite {
    @Test
    public void shouldGetWord(){
        //Given
        EnglishWord englishWord = new EnglishWord(PartOfSpeech.NOUN, "play");
        //When
        String result = englishWord.getWord();
        //Then
        assertEquals(result, "play");
    }
}