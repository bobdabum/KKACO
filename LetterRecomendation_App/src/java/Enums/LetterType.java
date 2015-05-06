/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Enums;

/**
 *
 * @author My Pc
 */
public enum LetterType {
    GENERALPURPOSE(0), CONFIDENTIAL(1);
    private int type;
    LetterType(int type){
        this.type = type;
    }
    public int getType(){
        return type;
    }
}
