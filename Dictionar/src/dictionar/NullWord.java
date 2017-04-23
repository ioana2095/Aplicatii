/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionar;

/**
 *
 * @author Ioana
 */
public class NullWord extends AbstractWord {

    @Override
    public boolean isNil() {
        return true;
    }

    @Override
    public String getWord() {
        return "Nu exista in dictionar";
    }
    
}
