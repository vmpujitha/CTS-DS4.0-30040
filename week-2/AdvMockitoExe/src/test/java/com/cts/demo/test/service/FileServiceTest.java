package com.cts.demo.test;

import com.cts.demo.io.FileReader;
import com.cts.demo.io.FileWriter;
import com.cts.demo.io.FileService;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class FileServiceTest {
    @Test
    void testServiceWithMockFileIO() {
        FileReader mockFileReader = mock(FileReader.class);
        FileWriter mockFileWriter = mock(FileWriter.class);

        when(mockFileReader.read()).thenReturn("Mock File Content");

        FileService fileService = new FileService(mockFileReader, mockFileWriter);
        String result = fileService.processFile();

        verify(mockFileWriter).write("Mock File Content");
        assertEquals("Processed Mock File Content", result);
    }
}
