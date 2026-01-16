package katestrophic.agenda.managers;

import android.content.Context;
import java.io.File;

import katestrophic.agenda.entities.SectionEntity;
import katestrophic.agenda.utils.Constants;

public class FileManager {
    private final File userRoot;

    public FileManager(Context context, String userId) {
        // Points to: files/Agenda/app/data/<userid>/
        this.userRoot = new File(context.getFilesDir(), Constants.DEFAULT_ROOT_PATH + userId);
        if (!userRoot.exists()) userRoot.mkdirs();
    }

    /**
     * @purpose "If it doesn't exist, rebuild."
     * Validates and creates physical directories from the Section's nav map.
     */
    public void syncSectionStorage(SectionEntity section) {
        File sectionRoot = new File(userRoot, section.getName());
        if (!sectionRoot.exists()) sectionRoot.mkdirs();

        for (String path : section.getDirectoryNav()) {
            File folder = new File(sectionRoot, path);
            if (!folder.exists()) {
                folder.mkdirs();
            }
        }
    }

    /**
     * @purpose Checks if a folder path is valid before adding to DB
     */
    public boolean isPathValid(String path) {
        if (path == null || path.isEmpty()) return false;
        String[] parts = path.split("/");
        return parts.length <= Constants.DIR_DEPTH_MAX;
    }
}
