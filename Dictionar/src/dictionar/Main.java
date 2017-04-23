/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionar;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Set;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Ioana
 */
public class Main {
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        HashMap<Word, ArrayList<Word>> map=null;
       JSONParser parser = new JSONParser();
       
     

        try {
            FileReader f=new FileReader("Dictionar.txt");
            JSONObject jsonObject = (JSONObject) parser.parse(f);
            map=(HashMap<Word, ArrayList<Word>>)jsonObject;
            map.putAll(map);
            //System.out.print(map.entrySet());
            
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dictionar dictionar=new Dictionar();
        //dictionar.setDictionar(map);
        View v=new View(dictionar);

    }
}
