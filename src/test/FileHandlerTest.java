package test;

import com.minet.utils.FileHandler;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileHandlerTest {
    String filePath = "src/assets/testFile.txt";
    File fileObject = new File(filePath);
    FileHandler file = new FileHandler();

    @Test
    @Disabled
    void createFileTest() throws IOException {
        file.createFile(filePath);
        file.writeToFile("Something to check inside file",filePath);
        //assertEquals("Something to check inside file","Something to check inside file",file.readFromFile(filePath));
        fileObject.delete();

    }

    @Test
    void writeToFileTest() {
    }
}