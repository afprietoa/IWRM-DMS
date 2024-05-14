package co.edu.usa.iwrmdms.user_ms.configuration;

public class Constants {

    public static final String CHANGE_USER_ROLE_FROM_ADMINISTRATOR = "The Role of user was changed by administrator.";
    public static final String ADMINISTRATOR_ROLE ="ADMINISTRATOR_ROLE";
    public static final Long VOLUNTEER_ROLE_ID = 1L;
    public static final Long ASSISTANT_ROLE_ID = 2L;
    public static final Long SPECIALIST_ROLE_ID = 3L;
    public static final Long INSPECTOR_ROLE_ID = 4L;
    public static final int MAX_PAGE_SIZE = 2;
    public static final String USER_CREATED_MESSAGE = "The user was created.";
    public static final String USER_UPDATED_MESSAGE = "The user was updated.";
    public static final String USER_DELETED_MESSAGE = "The user was deleted.";

    public static final String ROLE_CREATED_MESSAGE = "The role was created.";
    public static final String ROLE_UPDATED_MESSAGE = "The role was updated.";
    public static final String ROLE_DELETED_MESSAGE = "The role was deleted.";

    public static final String PROFILE_CREATED_MESSAGE = "The profile was created.";
    public static final String PROFILE_UPDATED_MESSAGE = "The profile was updated.";
    public static final String PROFILE_DELETED_MESSAGE = "The profile was deleted.";

    public static final String WRONG_CREDENTIALS_MESSAGE = "Wrong credentials";
    public static final String NO_DATA_FOUND_MESSAGE = "No data found for the requested petition";
    public static final String PROFILE_ALREADY_EXISTS_MESSAGE = "A profile already exists with the DNI number provided";
    public static final String EMAIL_ALREADY_EXISTS_MESSAGE = "A profile with that mail already exists";
    public static final String PROFILE_NOT_FOUND_MESSAGE = "No profile found with the id provided";
    public static final String ROLE_NOT_FOUND_MESSAGE = "No role found with the id provided";
    public static final String ROLE_NOT_ALLOWED_MESSAGE = "No permission granted to create users with this role";
    public static final String USER_ALREADY_EXISTS_MESSAGE = "A user already exists with the role provided";
    public static final String USER_NOT_FOUND_MESSAGE = "No user found with the role provided";
    public static final String RESPONSE_MESSAGE_KEY = "message";

    // exceptions
    public static final String RESPONSE_ERROR_MESSAGE_KEY = "error";
    public  static final String DIFFERENT_RESOURCE_DELETE_ERROR = "The resource belong other resource.";
    //
    public static final String SWAGGER_TITLE_MESSAGE = "Scheduling Management";
    public static final String SWAGGER_DESCRIPTION_MESSAGE = "Management API REST";
    public static final String SWAGGER_VERSION_MESSAGE = "1.0.0";
    public static final String SWAGGER_LICENSE_NAME_MESSAGE = "Apache 2.0";
    public static final String SWAGGER_LICENSE_URL_MESSAGE = "http://springdoc.org";
    public static final String SWAGGER_TERMS_OF_SERVICE_MESSAGE = "http://swagger.io/terms/";
}
