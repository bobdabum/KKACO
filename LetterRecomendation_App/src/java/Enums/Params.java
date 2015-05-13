/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Enums;

/**
 *
 * @author My Pc
 */
public class Params{
    //User Parameters
    public static final String USER_ID = "userid";
    public static final String USER = "user";
    public static final String PASSWORD  = "pw";
    public static final String EMAIL = "email";
    public static final String FNAME = "fName";
    public static final String LNAME = "lName";
    
    //User Profile Action Parameters
    public static final String ACTION = "action";
    public static final String LOGIN = "login";
    public static final String REGISTER = "register";
    
    //Letter Parameters
    public static final String LETTERS = "letters";
    public static final String LETTERID = "letterid";
    public static final String DEADLINE = "deadline";
    public static final String VALIDTO = "validto";
    public static final String WRITERID = "writer_id";    
    public static final String RECOMENDEEID = "recomendee_id";
    public static final String ISPRIVATE = "isPrivate";
    
    //Request Parameters
    public static final String ACCEPTED = "accepted";
    public static final String SUBMITFILE = "submitFile";
    public static final String SUBMITTEXT = "submitText";
    public static final String TEXT = "text";
    public static final String URL = "url";
    
    //URL Parameters
    public static final String URLPATTERN_USERPROFILE = "/user_profile";
    public static final String URL_USERPROFILE = "/WEB-INF/userProfile.jsp";
    public static final String URLPATTERN_LETTERSREQUESTED = "/letters_requested";
    public static final String URL_LETTERSREQUESTED = "/WEB-INF/lettersRequested.jsp";
    public static final String URLPATTERN_REQUESTSRECEIVED = "/requests_received";
    public static final String URL_REQUESTSRECEIVED = "/WEB-INF/requestsReceived.jsp";
}