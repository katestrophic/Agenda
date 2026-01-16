package katestrophic.agenda.utils;

/** @purpose back-end constant values, format minimum: TYPE_ATTRIBUTE_SUBJECT */
public class Constants {
    public static final String LOCAL_DB_NAME = "agendabase.db";

    // LOGIN SETTINGS
    public static final int LOGIN_ATTEMPT_FLAG = 5;
    public static final int LOGIN_ATTEMPT_MAX = 10;
    public static final int DEFAULT_PASSCODE_LENGTH = 4;

    // DIRECTORY SETTINGS
    public static final String DEFAULT_ROOT_PATH = "Agenda/app/data/";
    public static final int DIR_DEPTH_MAX = 4;

    // FOLDER SETTINGS
    public static final String DEFAULT_FOLDER_HEX = "#757575";

    // FILE EXTENSIONS
    public static final String FILE_EXT_DB = ".db";
    public static final String FILE_EXT_MD = ".md";
    public static final String FILE_EXT_TXT = ".txt";
    public static final String FILE_EXT_CSS = ".css";
    public static final String FILE_EXT_DAT = ".dat";
    public static final String FILE_EXT_JSON = ".json";
}