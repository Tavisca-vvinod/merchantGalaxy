package com.tavisca.workshop.merchant;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Dictionary;
import java.util.WeakHashMap;

public class InputParserTest {
    @Test
    public void canParseWordToRomanNumeralStatement()
    {
        assertArrayEquals(new String[]{"glob","I"},WordToRomanParser.parse("glob is I"));
    }
    @Test
    public void canGetNumberFromWord()
    {
        assertEquals(70,WordToRomanParser.convert("glob is LXX"));
    }
    @Test
    public void canParseWordsToCreditsStatement()
    {
        assertArrayEquals(new String[][]{{"glob","glob","Silver"},{"34", "Credits"}},WordsToCreditsParser.parse("glob glob Silver is 34 Credits"));
    }
    @Test
    public void canParseQuestions()
    {
        assertArrayEquals(new String[]{"many","glob prok Silver"},QuestionsParser.parse("how many Credits is glob prok Silver ?"));
        assertArrayEquals(new String[]{"much","pish tegj glob glob"},QuestionsParser.parse("how much is pish tegj glob glob ?"));
    }
    @Test
    public void answersQuestionTypeMuch()
    {
        Dictionaryy command=new Dictionaryy();
        String command1= "glob is I";
        String command2="prok is V";
        String command3="pish is X";
        command.wordRoman.put(WordToRomanParser.parse(command1)[0],WordToRomanParser.parse(command1)[1]);
        command.wordRoman.put(WordToRomanParser.parse(command2)[0],WordToRomanParser.parse(command2)[1]);
        command.wordRoman.put(WordToRomanParser.parse(command3)[0],WordToRomanParser.parse(command3)[1]);
        int number= command.questionParser("how much is pish tegj glob glob ?");

    }
    @Test
    public void canGetNumberFromCommandTwoType()
    {
        Dictionaryy command=new Dictionaryy();
        String command1= "glob is I";
        String command2="prok is V";
        String command3="pish is X";
        command.wordRoman.put(WordToRomanParser.parse(command1)[0],WordToRomanParser.parse(command1)[1]);
        command.wordRoman.put(WordToRomanParser.parse(command2)[0],WordToRomanParser.parse(command2)[1]);
        command.wordRoman.put(WordToRomanParser.parse(command3)[0],WordToRomanParser.parse(command3)[1]);
        assertEquals(17,command.convert("glob glob Silver is 34 Credits"));
        assertEquals(14450,command.convert("glob prok Gold is 57800 Credits"));
        assertEquals(195,command.convert("pish pish Iron is 3910 Credits"));
    }
}
