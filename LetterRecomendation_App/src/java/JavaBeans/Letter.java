/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBeans;
import Enums.LetterType;
import Enums.LetterStatus;
import java.util.GregorianCalendar;

/**
 *
 * @author My Pc
 */
public class Letter {
    private int letter_id, writer_id, recomendee_id;
    private GregorianCalendar deadline, validto, requestdate;
    //Type is either general purpose(0) or private(1)
    private LetterType type;    
    //Status is either unread(0), accepted but not written(1), rejected(2), written(3)
    private LetterStatus status;
    private String fileurl,text, writer_fName, writer_lName, rec_fName, rec_lName;

    /**
     * @return the letter_id
     */
    public int getLetter_id() {
        return letter_id;
    }

    /**
     * @param letter_id the letter_id to set
     */
    public void setLetter_id(int letter_id) {
        this.letter_id = letter_id;
    }

    /**
     * @return the writer_id
     */
    public int getWriter_id() {
        return writer_id;
    }

    /**
     * @param writer_id the writer_id to set
     */
    public void setWriter_id(int writer_id) {
        this.writer_id = writer_id;
    }

    /**
     * @return the recomendee_id
     */
    public int getRecomendee_id() {
        return recomendee_id;
    }

    /**
     * @param recomendee_id the recomendee_id to set
     */
    public void setRecomendee_id(int recomendee_id) {
        this.recomendee_id = recomendee_id;
    }

    /**
     * @return the deadline
     */
    public GregorianCalendar getDeadline() {
        return deadline;
    }

    /**
     * @param deadline the deadline to set
     */
    public void setDeadline(GregorianCalendar deadline) {
        this.deadline = deadline;
    }

    /**
     * @return the validto
     */
    public GregorianCalendar getValidto() {
        return validto;
    }

    /**
     * @param validto the validto to set
     */
    public void setValidto(GregorianCalendar validto) {
        this.validto = validto;
    }

    /**
     * @return the requestdate
     */
    public GregorianCalendar getRequestdate() {
        return requestdate;
    }

    /**
     * @param requestdate the requestdate to set
     */
    public void setRequestdate(GregorianCalendar requestdate) {
        this.requestdate = requestdate;
    }

    /**
     * @return the type
     */
    public LetterType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        switch(type){
            case 0:
                this.type = LetterType.GENERALPURPOSE;
                break;
            case 1:
                this.type = LetterType.CONFIDENTIAL;
                break;
        }
    }

    /**
     * @return the status
     */
    public LetterStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        switch(status){
            case 0: 
                this.status = LetterStatus.UNREAD;
                break;
            case 1:
                this.status = LetterStatus.ACCEPTED;
                break;
            case 2:
                this.status = LetterStatus.REJECTED;
                break;
            case 3:
                this.status = LetterStatus.FINISHED;
        }
    }

    /**
     * @return the fileurl
     */
    public String getFileurl() {
        return fileurl;
    }

    /**
     * @param fileurl the fileurl to set
     */
    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the writer_fName
     */
    public String getWriter_fName() {
        return writer_fName;
    }

    /**
     * @param writer_fName the writer_fName to set
     */
    public void setWriter_fName(String writer_fName) {
        this.writer_fName = writer_fName;
    }

    /**
     * @return the writer_lName
     */
    public String getWriter_lName() {
        return writer_lName;
    }

    /**
     * @param writer_lName the writer_lName to set
     */
    public void setWriter_lName(String writer_lName) {
        this.writer_lName = writer_lName;
    }

    /**
     * @return the rec_fName
     */
    public String getRec_fName() {
        return rec_fName;
    }

    /**
     * @param rec_fName the rec_fName to set
     */
    public void setRec_fName(String rec_fName) {
        this.rec_fName = rec_fName;
    }

    /**
     * @return the rec_lName
     */
    public String getRec_lName() {
        return rec_lName;
    }

    /**
     * @param rec_lName the rec_lName to set
     */
    public void setRec_lName(String rec_lName) {
        this.rec_lName = rec_lName;
    }
}
