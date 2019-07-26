package com.tavisca.workshop.merchant;

import javax.naming.directory.Attribute;
import java.util.HashMap;

public class Dictionaryy {
    public  HashMap<String, String> wordRoman= new HashMap<String, String>();
    public  HashMap<String, Integer> itemAmount= new HashMap<String, Integer>();
    public int convert(String input)
    {
        String[][] answer= WordsToCreditsParser.parse(input);
        int  number= Integer.parseInt(answer[1][0]);
        String roman=wordRoman.get(answer[0][0]) +wordRoman.get(answer[0][1]);
        this.itemAmount.put(wordRoman.get(answer[1][1]),number/RomanToNumeral.convertToDecimal(roman));
        return number/RomanToNumeral.convertToDecimal(roman);
    }

    public int questionParser(String input) {
        int number=0;
        return number;
    }
}
