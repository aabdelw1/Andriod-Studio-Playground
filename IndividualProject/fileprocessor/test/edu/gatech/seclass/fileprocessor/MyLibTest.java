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


    private static final String FILE2 =
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

    @Test
    public void fileprocessorTest7() throws Exception {
        String FILE2 =
                "!@#*912, I am going home." + System.lineSeparator() +
                        "Hello 8, my -lucky- number" + System.lineSeparator() +
                        "8136 is our waiting number. Let's go sit down and wait." + System.lineSeparator() +
                        "8136 is our ticket number. Let's go sit down and enjoy the show." + System.lineSeparator() +
                        System.lineSeparator() +
                        System.lineSeparator() +
                        "8130, I have a special task for you." + System.lineSeparator() +
                        "Hello friends, it is so nice to have you with us today." + System.lineSeparator() +
                        "Albert Einstein was a genius." + System.lineSeparator() +
                        "hello hello hello~~~~~~~~~" + System.lineSeparator() +
                        "--''--911" + System.lineSeparator() +
                        "@#$%" + System.lineSeparator() +
                        "hello" + System.lineSeparator() +
                        "Beach" + System.lineSeparator() ;


        File inputFile1 = createInputFile(FILE2);

        fileProcessor.setFilepath(inputFile1.getPath());
        fileProcessor.setS(true);
        fileProcessor.setL(true);
        fileProcessor.setRString("t's");
        fileProcessor.setTInt(100);
        fileProcessor.process();
        String expected1 =
                "1 8130, I have a special task for you." + System.lineSeparator() +
                        "2 --''--911" + System.lineSeparator() +
                        "3 !@#*912, I am going home." + System.lineSeparator() +
                        "4 Albert Einstein was a genius." + System.lineSeparator() +
                        "5 Beach" + System.lineSeparator() +
                        "6 Hello 8, my -lucky- number" + System.lineSeparator() +
                        "7 Hello friends, it is so nice to have you with us today." + System.lineSeparator() +
                        "8 hello" + System.lineSeparator() +
                        "9 hello hello hello~~~~~~~~~" + System.lineSeparator();

        String actual1 = getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1, actual1);
    }


    @Test
    public void fileprocessorTest8() throws Exception {
        String FILE3 =
                "This is the 1st line." + System.lineSeparator() +
                        "" + System.lineSeparator() +
                        "2460 is the number of students      in our school." + System.lineSeparator() +
                        "hello~~~~~~~~" + System.lineSeparator() +
                        " Hello, do you      remember me?" + System.lineSeparator() +
                        "123 go!" + System.lineSeparator();

        File inputFile1 = createInputFile(FILE3);

        fileProcessor.setFilepath(inputFile1.getPath());
        fileProcessor.setS(true);
        fileProcessor.setL(true);

        fileProcessor.setTInt(4);
        fileProcessor.process();
        String expected1 =
                "1 123" + System.lineSeparator() +
                        "2 2460" + System.lineSeparator() +
                        "3 Hel" + System.lineSeparator() +
                        "4 This" + System.lineSeparator() +
                        "5 hell" + System.lineSeparator();

        String actual1 = getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1, actual1);
    }

    @Test
    public void fileprocessorTest9() throws Exception {
        String FILE4 =
                "Spaces should not matter" + System.lineSeparator() +
                        "Spacesshould not matter" + System.lineSeparator() +
                        "Spacesshouldnot matter" + System.lineSeparator() +
                        "Spacesshouldnotmatter" + System.lineSeparator() +
                        "Spaces shouldnot matter" + System.lineSeparator() +
                        "abbb" + System.lineSeparator()+
                        "a ddd" + System.lineSeparator()+
                        "a ccc" + System.lineSeparator();
        File inputFile1 = createInputFile(FILE4);

        fileProcessor.setFilepath(inputFile1.getPath());
        fileProcessor.setS(true);
        fileProcessor.setL(true);

//        fileProcessor.setTInt(4);
        fileProcessor.process();
        String expected1 =
                "1 Spaces should not matter" + System.lineSeparator() +
                        "2 Spacesshould not matter" + System.lineSeparator() +
                        "3 Spacesshouldnot matter" + System.lineSeparator() +
                        "4 Spacesshouldnotmatter" + System.lineSeparator() +
                        "5 Spaces shouldnot matter" + System.lineSeparator() +
                        "6 abbb" + System.lineSeparator() +
                        "7 a ccc" + System.lineSeparator() +
                        "8 a ddd" + System.lineSeparator();

        String actual1 = getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1, actual1);
    }

    // Add your test cases under the provided one and
    // (1) make sure that your tests are called fileprocessorTest* (where "*" can be any string)
    // (2) make sure to specify the @Test annotation on the line before the test, as done above
 }


