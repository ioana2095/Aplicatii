/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionar;

import java.util.Objects;

/**
 *
 * @author Ioana
 */
public class Word extends AbstractWord implements Cloneable{
    private String word;
    
    public Word()
    {   
    }
    @Override
    public String getWord()
    {
        return this.word;
    }
    public void setWord(String s)
    {
        this.word=s;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Word other = (Word) obj;
        if (this.getWord() == null) {
            if (other.getWord()!= null)
                return false;
        } else if (!getWord().equals(other.getWord()))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.word);
        return hash;
    }

    /**
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
      Object clone = null;
      
      try {
         clone = super.clone();
         
      } catch (CloneNotSupportedException e) {
         e.printStackTrace();
      }
      
      return clone;
   }

    @Override
    public boolean isNil() {
       return false;
    }
    
}
