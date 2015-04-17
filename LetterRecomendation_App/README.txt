PLEASE IMPLEMENT THESE THINGS WHEN WRITING THE FRONTEND/BACKEND TO KEEP THINGS CONSISTENT

//BACKEND TO FRONTEND --------------------- ADD THESE ATTRIBUTES TO THE RESPONSE
LoginController -> UserProfile.jsp
"user" User Object
"letters" ArrayList<Letter>
 
RegistrationController -> UserProfile.jsp
"user" User Object
"letters" ArrayList<Letter>
 
? -> LettersReceived.jsp
"user" User Object
"letters" ArrayList<Letter>
 
//FRONTEND TO BACKEND --------------------- ADD THESE ATTRIBUTES IN THE NAMES OF THE FORMS
register.jsp -> RegistrationController
"email" email
"fName" first name
"lName" last name
"pw" password
  
index.jsp -> LoginController
"email" email
"pw" password
  
UserProfile.jsp -> EditUserInfoController
"fName"fname
"lName" lname
"userID" userID
"email" email

UserProfile.jsp -> EditUserPWController
"userID" userID
"pw" password
  
UserProfile.jsp -> RequestLetterController
"wid" writer_id,
"rid" recomendee_id,
"deadline" deadline, //note these are going to be strings so when creating the 
//gregoriancalendar object, you need to parse the string
"validto" validto,
"private" isPrivate

