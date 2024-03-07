import javax.swing.text.html.HTMLDocument;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        printDiamond('D');
    }

    public static void printDiamond(char character)
    {
        //If the character is outside the range, exit early
        if(character < 'A' || character > 'Z') return;
        //Set up vars; the line size (diamondSize), the active character, and the direction
        //that we are navigating in the alphabet
        int diamondSize = (character - 'A' + 1) * 2 - 1;
        char curChar = 'A';
        boolean isIncreasing = true;
        while(curChar > '@')
        {
            //Reset the string
            String s = "";
            //Get the amount of space padding on the borders, as well as in the middle
            int midPadding = (curChar - 'A' - 1) * 2 + 1;
            int sidePadding = (diamondSize - 2 - midPadding) / 2;
            String sidePad = IntStream.range(0,sidePadding).mapToObj(i -> " ").collect(Collectors.joining());
            String midPad = IntStream.range(0,midPadding).mapToObj(i -> " ").collect(Collectors.joining());
            //Build the string;
            //1. If padding on the left, add it to the string
            //2. Output the current character
            //3. If there is middle padding (If the character isn't 'A'), add the middle padding
            //   and the second instance of the character
            //4. If padding on the right, add it to the string
            if(sidePadding > 0) s += sidePad;
            s += curChar;
            if(midPadding > 0)
            {
                s += midPad;
                s += curChar;
            }
            if(sidePadding > 0) s += sidePad;
            //Output the line of the diamond
            System.out.print(s);
            // If it isn't the last line of the diamond, add a newline
            if(!(curChar == 'A' && !isIncreasing)) System.out.println();
            // If the last line was the target character, swap the direction we are moving in the alphabet,
            // Then increment/decrement the character.
            if(curChar == character) isIncreasing = false;
            if(isIncreasing) curChar +=1;
            else curChar -=1;
        }
    }

}