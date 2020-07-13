package edu.gatech.seclass.fileprocessor;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/*
DO NOT ALTER THIS CLASS.  Use it as an example for MyMainTest.java
 */

public class MainTest {

    private ByteArrayOutputStream outStream;
    private ByteArrayOutputStream errStream;
    private PrintStream outOrig;
    private PrintStream errOrig;
    private Charset charset = StandardCharsets.UTF_8;

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
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(outOrig);
        System.setErr(errOrig);
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
        File file =  createTmpFile();

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
  
  //Normal File
	private static final String FILE1 =
            "Hello Hello" + System.lineSeparator() +
            "Ammar Abdelwahed" + System.lineSeparator() +
            "Natalie" + System.lineSeparator() +
            "@#$% Ammer Hammer" + System.lineSeparator() +
            "#%Albert Einstein" + System.lineSeparator() +
            "--’’--9111234" + System.lineSeparator() +
            "hello there again" + System.lineSeparator();

  //Empty File
  private static final String FILE2 = "";

  //One Liner
  private static final String FILE3 = "Hello Hello";


  //All alphanumerics only
  private static final String FILE4 =  
            "Hi there" + System.lineSeparator() +
            "Ammar" + System.lineSeparator();

    // test cases

    /*
    *   TEST CASES
    */

    // Frame 1: Instructor example 1 from assignment directions
    @Test
    public void mainTest1() throws Exception {
        File inputFile1 = createInputFile(FILE1);

        String args[] = {"-s", "-l", inputFile1.getPath()};
        Main.main(args);

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


    // Frame 2: Instructor error example
    @Test
    public void mainTest7() throws Exception {
        //no arguments on the command line will pass an array of length 0 to the application (not a null).
        String args[]  = new String[0];
        Main.main(args);
        assertEquals("Usage: filesummary [-s] [-r string | -k string] [-t [integer]] [-l] <filename>", errStream.toString().trim());
    }

}