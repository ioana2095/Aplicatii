/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Ioana
 */
public interface DictionarProc {
    public void addWord(Word w,ArrayList<Word> sinonime);
    public void deleteWord(Word w);
    public ArrayList<Word> listWord(Word w);
    public void defineWord(Word w,Word sinonim)throws IOException;   
}
