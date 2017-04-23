/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionar;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 *
 * @author Ioana
 */
public class Dictionar implements DictionarProc{
    HashMap<Word, ArrayList<Word>> dictionar;
    public Dictionar()
    {
        this.dictionar=new HashMap<Word, ArrayList<Word>>();
    }
    public HashMap<Word, ArrayList<Word>> getDictionar()
    {
        return this.dictionar;
    }
    public void setDictionar(HashMap<Word, ArrayList<Word>> d)
    {
        this.dictionar=d;
    }
    @Override
    public void addWord(Word w, ArrayList<Word> sinonime) {
        assert isWellFormed();
        ArrayList<Word> cuv=new ArrayList<Word>();
        cuv.add(w);
        cuv.add(sinonime.get(1));
        getDictionar().put(w, sinonime);
        getDictionar().put(sinonime.get(0), cuv);
        ArrayList<Word> cuv1=new ArrayList<Word>();
        cuv1.add(w);
        cuv1.add(sinonime.get(0));
        getDictionar().put(sinonime.get(1),cuv1);
        assert isWellFormed();
    }

    @Override
    public void deleteWord(Word w) {
        getDictionar().remove(w);
    }

    @Override
    public ArrayList<Word> listWord(Word w) {
         NullWord q=new NullWord();
        assert isWellFormed();
        assert !(q.getWord().equals(getKeyWord(w).getWord()));
        ArrayList<Word>  a=getDictionar().get(w);
        return (ArrayList<Word>)a.clone();
    }

    @Override
    public void defineWord(Word w, Word sinonim) throws IOException{
         NullWord q=new NullWord();
         try{
         assert !(q.getWord().equals(getKeyWord(w).getWord()));
         ArrayList<Word> cuv=new ArrayList<Word>();
         cuv.add(w);
         assert isWellFormed();
         getDictionar().get(w).add(sinonim);
         getDictionar().put(sinonim, cuv);
         if(getKeyWord(sinonim).equals(q))
         {
             JOptionPane.showMessageDialog(null,"Dictionarul nu este consistent!", null,JOptionPane.ERROR_MESSAGE);
         }
         else
         {
             JOptionPane.showMessageDialog(null, "Dictionarul este consistent!",null, JOptionPane.INFORMATION_MESSAGE);
         }
         }
         catch (AssertionError i) {
		i.getMessage();
        }
    }
    public AbstractWord getKeyWord(Word w)
    {
        NullWord cuv=new NullWord();
        Word cuv1=new Word();
        cuv1.setWord(cuv.getWord());
       // System.out.println(cuv1.getWord());
        for(Word a:getDictionar().keySet())
            if(a.equals(w))
                return w;
        return cuv1;
    }
    public boolean isWellFormed() {
		boolean ok = true;
		for (Map.Entry<Word, ArrayList<Word>> entry : getDictionar().entrySet()) {
			if (entry.getValue().isEmpty()) {
				ok = false;
			}
		}
		return ok;
    }
    public void punereFisier()
    {
        try{
        JSONObject obj = new JSONObject();
        JSONArray ar=new JSONArray();
        for (Map.Entry<Word, ArrayList<Word>> entry : dictionar.entrySet())
        {
            for(int i=0;i< entry.getValue().size();i++)
            {
                ar.add(entry.getValue().get(i).getWord());
            }
            obj.put(entry.getKey().getWord(),ar);
        }
        File f=new File("Dictionar.txt");  
        f.createNewFile();  
        FileWriter file = new FileWriter(f); 
	obj.writeJSONString(file);
        System.out.println("Successfully Copied JSON Object to File...");
	System.out.println("\nJSON Object: " + obj);
        file.flush();
        file.close();
        }
        catch (IOException i) {
		i.printStackTrace();
        }
    }
    
}
