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


    private static final String FILE15 =
            "!@#*912, I am going home." + System.lineSeparator() +
            "Hello 8, my -lucky- number" + System.lineSeparator() +
            "8136 is our waiting number. Let's go sit down and wait." + System.lineSeparator() +
            "8136 is our ticket number. Let's go sit down and enjoy the show." + System.lineSeparator() +
            "8130, I have a special task for you." + System.lineSeparator() +
            "Hello friends, it is so nice to have you with us today." + System.lineSeparator() +
            "Albert Einstein was a genius." + System.lineSeparator() +
            "hello hello hello~~~~~~~~~" + System.lineSeparator() +
            "--''--911" + System.lineSeparator() +
            "@#$%" + System.lineSeparator() +
            "hello" + System.lineSeparator() +
            "Beach" + System.lineSeparator();

    private static final String FILE79 = "hello" + System.lineSeparator();

    private static final String FILE86 = "" + System.lineSeparator() +
            "" + System.lineSeparator() +
            "" + System.lineSeparator() +
            "" + System.lineSeparator() +
            "d" + System.lineSeparator() +
            "" + System.lineSeparator() +
            "" + System.lineSeparator() +
            "" + System.lineSeparator() +
            "" + System.lineSeparator();

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
    public void fileprocessorTest15() throws Exception {
        File inputFile1 = createInputFile(FILE15);

        fileProcessor.setFilepath(inputFile1.getPath());
        fileProcessor.setS(false);
        fileProcessor.setL(true);
        fileProcessor.setTInt(3);

        fileProcessor.process();
        String expected1 =
                "1 !@#" + System.lineSeparator() +
                        "2 Hel" + System.lineSeparator() +
                        "3 813" + System.lineSeparator() +
                        "4 813" + System.lineSeparator() +
                        "5 813" + System.lineSeparator() +
                        "6 Hel" + System.lineSeparator() +
                        "7 Alb" + System.lineSeparator() +
                        "8 hel" + System.lineSeparator() +
                        "9 --'" + System.lineSeparator() +
                        "10 @#$" + System.lineSeparator() +
                        "11 hel" + System.lineSeparator() +
                        "12 Bea"  + System.lineSeparator();
        String actual1 = getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1, actual1);
    }

    @Test
    public void fileprocessorTest18() throws Exception {
        File inputFile1 = createInputFile(FILE15);

        fileProcessor.setFilepath(inputFile1.getPath());
        fileProcessor.setS(true);
        fileProcessor.setL(true);
        fileProcessor.setRString("hello");
        fileProcessor.setTInt(2);

        fileProcessor.process();
        String expected1 =
                "1 81" + System.lineSeparator() +
                        "2 81" + System.lineSeparator() +
                        "3 81" + System.lineSeparator() +
                        "4 --" + System.lineSeparator() +
                        "5 !@" + System.lineSeparator() +
                        "6 Al" + System.lineSeparator() +
                        "7 Be" + System.lineSeparator() +
                        "8 He" + System.lineSeparator() +
                        "9 He" + System.lineSeparator();
        String actual1 = getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1, actual1);
    }

    @Test
    public void fileprocessorTest26() throws Exception {
        File inputFile1 = createInputFile(FILE15);

        fileProcessor.setFilepath(inputFile1.getPath());
        fileProcessor.setS(true);
        fileProcessor.setL(true);
        fileProcessor.setRString("hello hello");
        fileProcessor.setTInt(4);
        fileProcessor.process();
        String expected1 =
                "1 8130" + System.lineSeparator() +
                        "2 8136" + System.lineSeparator() +
                        "3 8136" + System.lineSeparator() +
                        "4 --''" + System.lineSeparator() +
                        "5 !@#*" + System.lineSeparator() +
                        "6 Albe" + System.lineSeparator() +
                        "7 Beac" + System.lineSeparator() +
                        "8 Hell" + System.lineSeparator() +
                        "9 Hell" + System.lineSeparator() +
                        "10 hell" + System.lineSeparator();
        String actual1 = getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1, actual1);
    }

    @Test
    public void fileprocessorTest34() throws Exception {
        File inputFile1 = createInputFile(FILE15);

        fileProcessor.setFilepath(inputFile1.getPath());
        fileProcessor.setS(true);
        fileProcessor.setL(false);
        fileProcessor.setKString("hell");
        fileProcessor.setTInt(4);

        fileProcessor.process();
        String expected1 =
                "8136" + System.lineSeparator() +
                        "8136" + System.lineSeparator();
        String actual1 = getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1, actual1);
    }

    @Test
    public void fileprocessorTest79() throws Exception {
        File inputFile1 = createInputFile(FILE86);

        fileProcessor.setFilepath(inputFile1.getPath());
        fileProcessor.setS(true);
        fileProcessor.setL(true);

        fileProcessor.process();
        String expected1 = "1 " + System.lineSeparator() +
                "2 " + System.lineSeparator() +
                "3 " + System.lineSeparator() +
                "4 " + System.lineSeparator() +
                "5 " + System.lineSeparator() +
                "6 " + System.lineSeparator() +
                "7 " + System.lineSeparator() +
                "8 " + System.lineSeparator() +
                "9 " + System.lineSeparator();
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

    @Test
    public void fileprocessorTest100() throws Exception {
        String FILE4 =
                "Spaces should not matter" + System.lineSeparator() +
                        "Spacesshould not matter" + System.lineSeparator() +
                        "Spacesshouldnot matter" + System.lineSeparator() +
                        "Spacesshouldnotmatter" + System.lineSeparator() +
                        "Spaces shouldnot matter" + System.lineSeparator() +
                        "abbb" + System.lineSeparator() +
                        "a ddd" + System.lineSeparator() +
                        "a ccc" + System.lineSeparator();
        File inputFile1 = createInputFile(FILE4);

        fileProcessor.setFilepath(inputFile1.getPath());
        fileProcessor.setS(false);
        fileProcessor.setL(false);
        fileProcessor.setKString("Spaces");
        fileProcessor.setTInt(2);

//        fileProcessor.setTInt(4);
        fileProcessor.process();
        String expected1 = "";
        String actual1 = getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1, actual1);

    }




    // Add your test cases under the provided one and
    // (1) make sure that your tests are called fileprocessorTest* (where "*" can be any string)
    // (2) make sure to specify the @Test annotation on the line before the test, as done above
 }


