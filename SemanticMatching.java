package com.pb.semantic.matching;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import edu.smu.tspell.wordnet.*;

/**
 * Displays word forms and definitions for synsets containing the word form
 * specified on the command line. To use this application, specify the word
 * form that you wish to view synsets for, as in the following example which
 * displays all synsets containing the word form "airplane":
 * <br>
 * 
 */

public class SemanticMatching{
  
  public static int SementicMatchingFunction (String Str1,String Str2)
  {
    File f=new File("C:\\Users\\va003to\\Downloads\\wn3.1.dict\\dict");
    System.setProperty("wordnet.database.dir", f.toString());
    
    WordNetDatabase database = WordNetDatabase.getFileInstance();
    Synset[] synsets = database.getSynsets(Str1);
    
    if (synsets.length > 0){
      ArrayList<String> al = new ArrayList<String>();
      // add elements to al, including duplicates
      HashSet<String> hs = new HashSet<String>();
      for (int i = 0; i < synsets.length; i++){
        String[] wordForms = synsets[i].getWordForms();
        for (int j = 0; j < wordForms.length; j++)
        {
          al.add(wordForms[j]);
        }

        hs.addAll(al);
        al.clear();
        al.addAll(hs);

       
      }

      if (al.contains(Str2.toLowerCase()))
        return 100;
      else
        return 0;

     }

    else
    {
      return 0;
    }
    
  }
  
  
 
}

