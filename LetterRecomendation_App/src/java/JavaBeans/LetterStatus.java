/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBeans;

/**
 *
 * @author My Pc
 */
public enum LetterStatus {
    UNREAD(0), ACCEPTED(1), REJECTED(2), FINISHED(3);
    private int status;
    LetterStatus(int status){
        this.status = status;
    }
    public int getStatus(){
        return status;
    }
}
