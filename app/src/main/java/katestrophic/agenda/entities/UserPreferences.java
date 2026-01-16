package katestrophic.agenda.entities;

import android.content.Context;
import java.io.File;

import katestrophic.agenda.utils.Constants;

public class UserPreferences {
    private String customRootPath;
    private String username;
    private String themeColor;

    public UserPreferences(String username) {
        this.username = username;
        // Defaults are set initially
        this.customRootPath = Constants.DEFAULT_ROOT_PATH;
    }

    /** Resolves the actual file path on the device */
    public String getResolvedRootPath(Context context) {
        if (customRootPath.equals(Constants.DEFAULT_ROOT_PATH)) {
            return new File(context.getFilesDir(), Constants.DEFAULT_ROOT_PATH).getAbsolutePath();
        }
        return customRootPath;
    }

    // Setters for SettingsManager to use
    public void setCustomRootPath(String path) { this.customRootPath = path; }
}
