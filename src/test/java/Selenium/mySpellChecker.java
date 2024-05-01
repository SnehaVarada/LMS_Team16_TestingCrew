package Selenium;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class mySpellChecker {
    private Set<String> dictionary;

    public mySpellChecker(String dictionaryFilePath) throws IOException {
        loadDictionary(dictionaryFilePath);
    }

    private void loadDictionary(String filePath) throws IOException {
        dictionary = new HashSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String word;
        while ((word = reader.readLine()) != null) {
            dictionary.add(word.toLowerCase());
        }
        reader.close();
    }

    public boolean check(String word) {
        return dictionary.contains(word.toLowerCase());
    }

    public static void spellingchck(String wordToCheck ) {
		/*
		 * if (args.length != 2) { System.err.
		 * println("Usage: java SpellChecker <dictionary_file> <word_to_check>");
		 * System.exit(1); }
		 */
    	
    	

        String dictionaryFilePath = "C:\\Users\\saisn\\MyNewWorkSpace\\Team16_TesingCru\\src\\test\\resources\\DataFiles\\download_dict.txt";
        String wordToCheck1 = "lms";

        try {
            mySpellChecker spellChecker = new mySpellChecker(dictionaryFilePath);
            if (spellChecker.check(wordToCheck1)) {
                System.out.println("Word is spelled correctly.");
            } else {
                System.out.println("Word is misspelled.");
            }
        } catch (IOException e) {
            System.err.println("Error loading dictionary: " + e.getMessage());
            System.exit(1);
        }
    }
}
