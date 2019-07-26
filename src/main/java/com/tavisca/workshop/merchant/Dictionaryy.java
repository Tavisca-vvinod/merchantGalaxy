package com.tavisca.workshop.merchant;

import javax.naming.directory.Attribute;
import java.util.HashMap;

public class Dictionaryy {
    public  HashMap<String, String> wordRoman= new HashMap<String, String>();
    public int convert(String input)
    {
        String[][] answer= WordsToCreditsParser.parse(input);
        int  number= Integer.parseInt(answer[1][0]);
        String roman=wordRoman.get(answer[0][0]) +wordRoman.get(answer[0][1]);
        return number/RomanToNumeral.convertToDecimal(roman);
    }
}
