package edu.gatech.seclass.fileprocessor;
import java.util.*;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;



public class FileProcessor implements FileProcessorInterface {

  private static String filepath;
  private static boolean sort;
  private static boolean list = false;

  private static String keep = "";
  private static Boolean keepB = false;

  private static String remove = "";
  private static Boolean removeB = false;


  private static int trim;
  private static boolean trimB = false;
  private Charset charset = StandardCharsets.UTF_8;


  private String getFileContent(String filename) {
    String content = null;
    try {
        content = new String(Files.readAllBytes(Paths.get(filename)), charset);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return content;
  }

  // Write File Utility
  private File writeOutput(String input) throws Exception {
    File file = new File(filepath);

    OutputStreamWriter fileWriter =
            new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);

    fileWriter.write(input);

    fileWriter.close();
    return file;
  }



  @Override
  public void setFilepath(String filepath) {
    this.filepath = filepath;
  }

  @Override
  public void setS(boolean s) { this.sort = s; }

  @Override
  public void setL(boolean l) {
    this.list = l;
  }

  @Override
  public void setRString(String rString) {
      removeB = true;
      this.remove = rString;
  }

  @Override
  public void setKString(String kString) {
      keepB = true;
      this.keep = kString;
  }

  @Override
  public void setTInt(int tInt) throws ProcessingException {
      trimB = true;
      this.trim = tInt;
  }

  public String toString(ArrayList<String> input) {
      String output = "";
      for(String line : input){
          output = output + line + System.lineSeparator();
      }
      return output;
  }

  @Override
  public void process() throws ProcessingException {

    String fileContent = getFileContent(filepath);

    //Convert fileContent Into Array
    String[] arrayFile = fileContent.split("\\r?\\n");
    ArrayList <String> a = new ArrayList<String>();
    for (String line : arrayFile){
        a.add(line);
    }
//
//    //Sorting Function
//      if(sort){
//          ArrayList<String> tmpArray = new ArrayList<>();
//          int counter = 0;
//          for (String line : a) {
//              String onlySpecialChar = line.replaceAll("[^a-zA-z0-9]", "");
//              if(!onlySpecialChar.equals("")){
//                  tmpArray.add(onlySpecialChar + " " + counter);
//              }
//              counter++;
//          }
//          Collections.sort(tmpArray);
//
//          ArrayList<String> thisIsIt = new ArrayList<>();
//          for(String item : tmpArray){
//              String[] splitArray = item.split("\\s+");
//              int index =  Integer.parseInt(splitArray[1]);
//              thisIsIt.add(a.get(index));
//          }
//          a = thisIsIt;
//      }
//
//
//    //Keep function
//    if(keepB) {
//        if (!keep.equals("")) {
//            ArrayList<String> tmpArray = new ArrayList<String>();
//            for (String line : a) {
//                boolean isPresent = line.indexOf(keep) != -1 ? true : false;
//                if (isPresent) {
//                    tmpArray.add(line);
//                }
//            }
//            a = tmpArray;
//        }
//    }
//
//    //Remove function
//    if(false) {
//        if (!remove.equals("")) {
//            ArrayList<String> tmpArray = new ArrayList<String>();
//            for (String line : a) {
//                boolean isPresent = line.indexOf(remove) != -1 ? true : false;
//                if (!isPresent) {
//                    tmpArray.add(line);
//                }
//            }
//            a = tmpArray;
//        }
//    }
//
//    //Trim function
//
//    if (trimB) {
//        if(trim > 0) {
//            ArrayList<String> tmpArray = new ArrayList<String>();
//            for (String line : a) {
//                if (trim > (line.length())) {
//                    String split = line.substring(0, line.length());
//                    tmpArray.add(split);
//                } else {
//                    String split = line.substring(0, trim);
//                    tmpArray.add(split);
//                }
//            }
//            a = tmpArray;
//        } else {
//            throw new ProcessingException("The argument of t must be greater than 0");
//        }
//    }
//
//    //List Function
//    if(list) {
//        ArrayList<String> tmpArray = new ArrayList<String>();
//        int counter = 1;
//        for (String line : a) {
//            line = counter + " " + line;
//            counter++;
//            tmpArray.add(line);
//        }
//        a = tmpArray;
//        list = false;
//  }


    //Convert Array to String
    String output = "";
    for(String line : a){
        output = output + line + System.lineSeparator();
    }
    output = output + "------------------------" + System.lineSeparator();
    output = output + sort + System.lineSeparator();
      output = output + list + System.lineSeparator();
      output = output + keep + System.lineSeparator();
      output = output + remove + System.lineSeparator();
      output = output + trim + System.lineSeparator();


      try {
        writeOutput(output);

    } catch(Exception e) {
        e.printStackTrace();
    }
//
//        try {
//            writeOutput(e.toString());
//        } catch (Exception p) {
//            p.printStackTrace(); }
//    }

  }
  
}
