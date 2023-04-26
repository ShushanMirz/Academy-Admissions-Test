package org.example;

public interface AllEndpoints {

    String All_Tests =  "/tests";
    String Single_Test = "/tests/{testId}";
    String All_Phases =  "/phases";
    String Single_Phase = "/phases/{phaseId}";
    String All_Events =  "/events";
    String Single_Event = "/events/{eventId}";
    String All_Applicants =  "/applicants";
    String Single_Applicant = "/applicants/{applicantId}";
    String Single_Applicant_Activate = "/applicants/activate";
    String Single_Applicant_Dashboard = "/applicants/dashboard";
    String Single_Applicant_Login = "/applicants/login";
    String All_Info_Applicant = "/info-applicant";
    String Single_Info_Applicant = "/info-applicant/{applicantId}";
    String All_Results =  "/results";
    String Single_Result = "/results/{resultId}";

    String Calendar =  "/calendar";
    String Single_Calendar = "/calendar/{calendarId}";

    String All_Notes =  "/notes";
    String Single_Note= "/notes/{noteId}";

    String All_Courses =  "/courses";
    String Single_Course = "/courses/{courseId}";

    String Auth_Login = "/auth/login";

    String All_Users =  "/users";
    String Single_User = "/users/{usersId}";
    String Single_User_Schedule = "/users/{userId}/schedule";

    String Single_File = "/files/{filesId}";
    String All_Files_Question_Image = "/files/question-image";
    String Single_File_Question_Image = "/files/question-image/{questionImageId}";

    String All_Questions =  "/questions";
    String Single_Question = "/questions/{questionId}";

}
