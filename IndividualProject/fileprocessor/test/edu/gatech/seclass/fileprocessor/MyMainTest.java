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

public class MyMainTest {

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
  private static final String FILE3 = "Hello Hello" + System.lineSeparator();;


  //All alphanumerics only
  private static final String FILE4 =  
            "Hi there" + System.lineSeparator() +
            "Ammar" + System.lineSeparator();
  
  //Lines of many non-alphanumerics
  private static final String FILE5 =  
            "--’’--9111234" + System.lineSeparator() +
            "--’’--9111234" + System.lineSeparator();

  

    // test cases

    /*
    *   TEST CASES
    */



    // Frame 1: Test Case 1
    @Test
    public void  fileprocessorTest1() throws Exception {
        File inputFile1 = createInputFile(FILE2);

        String args[] = {inputFile1.getPath()};
        Main.main(args);

        String expected1 = "";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected1, actual1);
    }



    // Frame 2: Test Case 2
    @Test
    public void  fileprocessorTest2() throws Exception {
        File inputFile1 = createInputFile(FILE3);

        String args[] = {"" ,inputFile1.getPath()};
        Main.main(args);

        String expected1 =  "Hello Hello" + System.lineSeparator();

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected1, actual1);
    }

    // Frame 3: Test Case 3
    @Test
    public void  fileprocessorTest3() throws Exception {
        File inputFile1 = createInputFile(FILE2);

        String args[] = {inputFile1.getPath()};
        Main.main(args);

        String expected1 = "";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected1, actual1);
    }


    // Frame 4: Test Case 4
    @Test
    public void  fileprocessorTest4() throws Exception {
        File inputFile1 = createInputFile(FILE3);

        String args[] = {inputFile1.getPath()};
        Main.main(args);

        String expected1 = "Hello Hello";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected1, actual1);
    }

    // Frame 5: Test Case 5
    @Test
    public void  fileprocessorTest5() throws Exception {
        File inputFile1 = createInputFile(FILE4);

        String args[] = {inputFile1.getPath()};
        Main.main(args);

        String expected1 =  "Hi there" + System.lineSeparator() +
        "Ammar" + System.lineSeparator();

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected1, actual1);
    }

    // Frame 6: Test Case 6
    @Test
    public void  fileprocessorTest6() throws Exception {
        File inputFile1 = createInputFile(FILE1);

        String args[] = {"-t", inputFile1.getPath()};
        Main.main(args);

        String expected1 = "H" + System.lineSeparator() +
        "A" + System.lineSeparator() +
        "N" + System.lineSeparator() +
        "@" + System.lineSeparator() +
        "#" + System.lineSeparator() +
        "-" + System.lineSeparator() +
        "h" + System.lineSeparator();

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected1, actual1);
    }

    // Frame 7: Test Case 7
    @Test
    public void  fileprocessorTest7() throws Exception {
        File inputFile1 = createInputFile(FILE1);

        String args[] = {"-t", "0", inputFile1.getPath()};
        Main.main(args);

        String expected1 =  "Hello Hello" + System.lineSeparator() +
        "Ammar Abdelwahed" + System.lineSeparator() +
        "Natalie" + System.lineSeparator() +
        "@#$% Ammer Hammer" + System.lineSeparator() +
        "#%Albert Einstein" + System.lineSeparator() +
        "--’’--9111234" + System.lineSeparator() +
        "hello there again" + System.lineSeparator();

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected1, actual1);
    }


     // Frame 8: Test Case 8
     @Test
     public void  fileprocessorTest8() throws Exception {
         File inputFile1 = createInputFile(FILE1);
 
         String args[] = {"-t", "-1", inputFile1.getPath()};
         Main.main(args);
 
      
     }


     // Frame 9: Test Case 9
     @Test
     public void  fileprocessorTest9() throws Exception {
         File inputFile1 = createInputFile(FILE1);
 
         String args[] = {"-t", "1"};
         Main.main(args);
     }

     // Frame 10: Test Case 10 		(Key = 2.2.3.2.2.1.0.3.1.1.2.)
     @Test
     public void  fileprocessorTest10() throws Exception {
         File inputFile1 = createInputFile(FILE1);
 
         String args[] = {"-t", "1", "-l", inputFile1.getPath()};
         Main.main(args);

         String expected1 = "1 H" + System.lineSeparator() +
        "2 A" + System.lineSeparator() +
        "3 N" + System.lineSeparator() +
        "4 @" + System.lineSeparator() +
        "5 #" + System.lineSeparator() +
        "6 -" + System.lineSeparator() +
        "7 h" + System.lineSeparator();

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected1, actual1);
     }


      // Frame 11: Test Case 11 		(Key = 2.2.3.2.2.1.0.3.1.2.2.)
      @Test
      public void  fileprocessorTest11() throws Exception {
          File inputFile1 = createInputFile(FILE1);
  
          String args[] = {"-t", "1", inputFile1.getPath()};
          Main.main(args);

          String expected1 = "H" + System.lineSeparator() +
          "A" + System.lineSeparator() +
          "N" + System.lineSeparator() +
          "@" + System.lineSeparator() +
          "#" + System.lineSeparator() +
          "-" + System.lineSeparator() +
          "h" + System.lineSeparator();
  
          String actual1 = getFileContent(inputFile1.getPath());
  
          assertEquals("The files differ!", expected1, actual1);
      }

      // Frame 12: Test Case 12 		(Key = 2.2.3.2.2.2.1.3.1.1.2.)
      @Test
      public void  fileprocessorTest12() throws Exception {
          File inputFile1 = createInputFile(FILE1);
  
          String args[] = {"-t", "1", "-l", "-k", "hello",inputFile1.getPath()};
          Main.main(args);

          String expected1 = "1 h" + System.lineSeparator();
  
          String actual1 = getFileContent(inputFile1.getPath());
  
          assertEquals("The files differ!", expected1, actual1);
      }

      // Frame 13: Test Case 13	(Key = 2.2.3.2.2.2.1.3.1.2.2.)
      @Test
      public void  fileprocessorTest13() throws Exception {
          File inputFile1 = createInputFile(FILE1);
  
          String args[] = {"-t", "1", "-k", "hello",inputFile1.getPath()};
          Main.main(args);

          String expected1 = "h" + System.lineSeparator();
  
          String actual1 = getFileContent(inputFile1.getPath());
  
          assertEquals("The files differ!", expected1, actual1);
      }


      // Frame 14: Test Case 14 		(Key = 2.2.3.2.2.2.2.3.1.1.2.)
      @Test
      public void  fileprocessorTest14() throws Exception {
          File inputFile1 = createInputFile(FILE1);
  
          String args[] = {"-t", "1", "hello", "-l" ,inputFile1.getPath()};
          Main.main(args);
      }


      // Frame 15: Test Case 15 		(Key = 2.2.3.2.2.2.2.3.1.2.2.)
      @Test
      public void  fileprocessorTest15() throws Exception {
          File inputFile1 = createInputFile(FILE1);

          String args[] = {"-t", "1", "hello",inputFile1.getPath()};
          Main.main(args);
      }


      // Frame 16: Test Case 16   (Key = 2.2.3.3.2.1.0.3.1.1.2.)
      @Test
      public void  fileprocessorTest16() throws Exception {
          File inputFile1 = createInputFile(FILE5);
  
          String args[] = {"-t", "1",inputFile1.getPath()};
          Main.main(args);
      }


      // Frame 17: Test Case 17    (Key = 2.2.3.3.2.1.0.3.1.2.2.)
      @Test
      public void  fileprocessorTest17() throws Exception {
          File inputFile1 = createInputFile(FILE5);
  
          String args[] = {"-t", "1",inputFile1.getPath()};
          Main.main(args);
      }


      // Frame 18: Test Case 18 		(Key = 2.2.3.3.2.2.1.3.1.1.2.)
      @Test
      public void  fileprocessorTest18() throws Exception {
          File inputFile1 = createInputFile(FILE5);
  
          String args[] = {"-t", "1", "-l", inputFile1.getPath()};
          Main.main(args);
      }


      // Frame 19: Test Case 19 		(Key = 2.2.3.3.2.2.1.3.1.2.2.)
      @Test
      public void  fileprocessorTest19() throws Exception {
          File inputFile1 = createInputFile(FILE5);
  
          String args[] = {"-t", "1", "-k", "je", inputFile1.getPath()};
          Main.main(args);
      }

      // Frame 20: Test Case 20 		(Key = 2.2.3.3.2.2.2.3.1.1.2.)
      @Test
      public void  fileprocessorTest20() throws Exception {
          File inputFile1 = createInputFile(FILE5);
  
          String args[] = {"-t", "1", "-k", "je", "-l", inputFile1.getPath()};
          Main.main(args);
      }

      // Frame 21: Test Case 21 		(Key = 2.2.3.3.2.2.2.3.1.2.2.)
      @Test
      public void  fileprocessorTest21() throws Exception {
          File inputFile1 = createInputFile(FILE1);
  
          String args[] = {"-t", "1", "-k", "je", inputFile1.getPath()};
          Main.main(args);
      }

      // Frame 22: Test Case 22 		(Key = 2.3.3.2.2.1.0.3.1.1.2.)
      @Test
      public void  fileprocessorTest22() throws Exception {
          File inputFile1 = createInputFile(FILE5);
  
          String args[] = {"-t", "1", "-k", "je", "-l", inputFile1.getPath()};
          Main.main(args);
      }

      // Frame 23: Test Case 23 		(Key = 2.3.3.2.2.1.0.3.1.2.2.)
      @Test
      public void  fileprocessorTest23() throws Exception {
          File inputFile1 = createInputFile(FILE1);
  
          String args[] = {"-t", "1", "-s", inputFile1.getPath()};
          Main.main(args);
      }

      // Frame 24: Test Case 24 (Key = 2.3.3.2.2.2.1.3.1.1.2.)
      @Test
      public void  fileprocessorTest24() throws Exception {
          File inputFile1 = createInputFile(FILE1);
  
          String args[] = {"-t", "1", "-s", "-k", "je", "-l", inputFile1.getPath()};
          Main.main(args);
      }

      // Frame 25: Test Case 25 		(Key = 2.3.3.2.2.2.1.3.1.2.2.)
      @Test
      public void  fileprocessorTest25() throws Exception {
          File inputFile1 = createInputFile(FILE1);
  
          String args[] = {"-t", "1", "-s", "-k", "je", inputFile1.getPath()};
          Main.main(args);
      }

      // Frame 26: Test Case 26 		(Key = 2.3.3.2.2.2.2.3.1.1.2.)
      @Test
      public void  fileprocessorTest26() throws Exception {
          File inputFile1 = createInputFile(FILE1);

          String args[] = {"-t", "1", "-s", "-l", inputFile1.getPath()};
          Main.main(args);
      }

      // Frame 27: Test Case 27 		(Key = 2.3.3.2.2.2.2.3.1.2.2.)
      @Test
      public void  fileprocessorTest27() throws Exception {
          File inputFile1 = createInputFile(FILE1);

          String args[] = {"-t", "1", "-s", "je", inputFile1.getPath()};
          Main.main(args);
      }

      // Frame 28: Test Case 28 		(Key = 2.3.3.3.2.1.0.3.1.1.2.)
      @Test
      public void  fileprocessorTest28() throws Exception {
          File inputFile1 = createInputFile(FILE5);

          String args[] = {"-t", "1", "-s", "-l", inputFile1.getPath()};
          Main.main(args);
      }

      // Frame 29: Test Case 29 		(Key = 2.3.3.3.2.1.0.3.1.2.2.)
      @Test
      public void  fileprocessorTest29() throws Exception {
          File inputFile1 = createInputFile(FILE5);

          String args[] = {"-t", "1", "-s", inputFile1.getPath()};
          Main.main(args);
      }

      // Frame 30: Test Case 30 		(Key = 2.3.3.3.2.2.1.3.1.1.2.)
      @Test
      public void  fileprocessorTest30() throws Exception {
          File inputFile1 = createInputFile(FILE5);

          String args[] = {"-t", "1", "-s", "-k", "jello", "-l", inputFile1.getPath()};
          Main.main(args);
      }


      // Frame 31: Test Case 31 		(Key = 2.3.3.3.2.2.1.3.1.2.2.)
      @Test
      public void  fileprocessorTest31() throws Exception {
          File inputFile1 = createInputFile(FILE5);

          String args[] = {"-t", "1", "-s", "-k", "jello", inputFile1.getPath()};
          Main.main(args);
      }

      // Frame 32: Test Case 32 		(Key = 2.3.3.3.2.2.2.3.1.1.2.)
      @Test
      public void  fileprocessorTest32() throws Exception {
          File inputFile1 = createInputFile(FILE5);

          String args[] = {"-t", "1", "-s", "jello", "-l", inputFile1.getPath()};
          Main.main(args);
      }

      // Frame 33: Test Case 33 		(Key = 2.3.3.3.2.2.2.3.1.1.2.)
      @Test
      public void  fileprocessorTest33() throws Exception {
          File inputFile1 = createInputFile(FILE5);

          String args[] = {"-t", "1", "-s", "jello", inputFile1.getPath()};
          Main.main(args);
      }
 

  }