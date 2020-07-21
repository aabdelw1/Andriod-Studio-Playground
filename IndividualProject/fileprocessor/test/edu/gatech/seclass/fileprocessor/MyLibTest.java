package edu.gatech.seclass.fileprocessor;

import org.apache.commons.lang.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class MyLibTest {

    private ByteArrayOutputStream outStream;
    private ByteArrayOutputStream errStream;
    private PrintStream outOrig;
    private PrintStream errOrig;
    private Charset charset = StandardCharsets.UTF_8;
    private FileProcessorInterface fileProcessor;

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Before
    public void setUp() throws Exception {
        outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);
        errStream = new ByteArrayOutputStream();
        PrintStream err = new PrintStream(errStream);
        outOrig = System.out;
        errOrig = System.err;
        System.setOut(out);
        System.setErr(err);
        fileProcessor = new FileProcessor();
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(outOrig);
        System.setErr(errOrig);
        fileProcessor=null;
    }

    /*
     *  TEST UTILITIES
     */

    // Create File Utility
    private File createTmpFile() throws Exception {
        File tmpfile = temporaryFolder.newFile();
        tmpfile.deleteOnExit();
        return tmpfile;
    }

    // Write File Utility
    private File createInputFile(String input) throws Exception {
        File file = createTmpFile();

        OutputStreamWriter fileWriter =
                new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);

        fileWriter.write(input);

        fileWriter.close();
        return file;
    }

    //Read File Utility
    private String getFileContent(String filename) {
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(filename)), charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    /*
     * TEST FILE CONTENT
     */
    private static final String FILE1 =
            "Hello" + System.lineSeparator() +
                    "Beatrice" + System.lineSeparator() +
                    "albert" + System.lineSeparator() +
                    "@#$%" + System.lineSeparator() +
                    "#%Albert" + System.lineSeparator() +
                    "--’’--911" + System.lineSeparator() +
                    "hello" + System.lineSeparator();

    // You can add more files here using the same approach used for FILE1

    /*
     *   TEST CASES
     */

    @Test
    public void fileprocessorTest1() throws Exception {
        File inputFile1 = createInputFile(FILE1);

        fileProcessor.setFilepath(inputFile1.getPath());
        fileProcessor.setS(true);
        fileProcessor.setL(true);
        fileProcessor.process();
        String expected1 =
                "1 --’’--911" + System.lineSeparator() +
                        "2 #%Albert" + System.lineSeparator() +
                        "3 Beatrice" + System.lineSeparator() +
                        "4 Hello" + System.lineSeparator() +
                        "5 albert" + System.lineSeparator() +
                        "6 hello" + System.lineSeparator();
        String actual1 = getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1, actual1);
    }

    // Add your test cases under the provided one and
    // (1) make sure that your tests are called fileprocessorTest* (where "*" can be any string)
    // (2) make sure to specify the @Test annotation on the line before the test, as done above
 }


