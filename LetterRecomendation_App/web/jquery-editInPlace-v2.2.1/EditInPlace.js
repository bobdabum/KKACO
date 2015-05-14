/*
 * Another In Place Editor - a jQuery edit in place plugin
 *
 * Copyright (c) 2009 Dave Hauenstein
 *
 * License:
 * This source file is subject to the BSD license bundled with this package.
 * Available online: {@link http://www.opensource.org/licenses/bsd-license.php}
 * If you did not receive a copy of the license, and are unable to obtain it,
 * email davehauenstein@gmail.com,
 * and I will send you a copy.
 *
 * Project home:
 * http://code.google.com/p/jquery-in-place-editor/
 *
 */
$(document).ready(function(){
    $("#fNameEdit").editInPlace({
        url: 'http://localhost:9999/LetterRecomendation_App/user_profile',
        params:'action=editFName',
        show_buttons: true,
        style:'color:black'
    });
    $("#lNameEdit").editInPlace({
        callback: function(unused, enteredText) { return enteredText; },
        url: 'http://localhost:9999/LetterRecomendation_App/web/userProfile.jsp',
        show_buttons: true,
        style:'color:black'
    });
    $("#emailEdit").editInPlace({
        callback: function(unused, enteredText) { return enteredText; },
        url: 'http://localhost:9999/LetterRecomendation_App/web/userProfile.jsp',
        show_buttons: true,
        style:'color:black'
    });   
});