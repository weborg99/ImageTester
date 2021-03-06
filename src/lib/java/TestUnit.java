import com.applitools.eyes.Eyes;

import java.io.File;
import java.io.IOException;
import java.nio.file.AccessDeniedException;

public abstract class TestUnit implements ITestable {
    protected final File file_;
    private String name_;

    protected TestUnit(File file) {
        file_ = file;
        if (file != null && !file.canRead()) {
            throw new RuntimeException(String.format("Unreadable path/file %s, might be a permission issue!", file.getAbsolutePath()));
        }
    }

    protected TestUnit(String name) {
        file_ = null;
        name_ = name;
    }

    public String name() {
        return file_ == null ? name_ : file_.getName();
    }
}
