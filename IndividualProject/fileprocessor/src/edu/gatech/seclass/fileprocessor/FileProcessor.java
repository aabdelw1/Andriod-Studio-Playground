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
  private static boolean list;
  private static String keep;
  private static String remove;
  private static int trim; 
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
  public void setS(boolean s) {
    // TODO Auto-generated method stub
    this.sort = s;

  }

  @Override
  public void setL(boolean l) {
    // TODO Auto-generated method stub
    this.list = l;
  }

  @Override
  public void setRString(String rString) {
    // TODO Auto-generated method stub
    this.remove = rString;
  }

  @Override
  public void setKString(String kString) {
    // TODO Auto-generated method stub
    this.keep = kString;
  }

  @Override
  public void setTInt(int tInt) throws ProcessingException {
    // TODO Auto-generated method stub
    this.trim = tInt;
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

    //Sorting Function
    if(sort){
      ArrayList<String> tmpArray = new ArrayList<String>();
      ArrayList<ArrayList> fullArray = new ArrayList<ArrayList>();
      for (String line : a) {
          ArrayList<String> isDifferent = new ArrayList<String>();
          String onlySpecialChar = line.replaceAll("[^a-zA-z0-9]", "");
          isDifferent.add(line);
          isDifferent.add(onlySpecialChar);
          fullArray.add(isDifferent);
          if(!onlySpecialChar.equals("")){
              tmpArray.add(onlySpecialChar);
          }
      }
      Collections.sort(tmpArray);
      ArrayList<String> thisIsIt = new ArrayList<String>();
      for(String item : tmpArray){
          for(int i = 0; i < fullArray.size(); i++){
              if(item.equals(fullArray.get(i).get(1))){
                  thisIsIt.add(fullArray.get(i).get(0).toString());
              }

          }
      }
      a = thisIsIt;
    }

    //Keep function
    if(!keep.equals("")){
        ArrayList<String> tmpArray = new ArrayList<String>();
        for(String line : a) {
            boolean isPresent = line.indexOf(keep) != -1 ? true : false;
            if(isPresent) {
                tmpArray.add(line);
            }
        }
        a = tmpArray;
    }

    //Remove function
    if(!remove.equals("")){
        ArrayList<String> tmpArray = new ArrayList<String>();
        for(String line : a) {
            boolean isPresent = line.indexOf(remove) != -1 ? true : false;
            if(!isPresent) {
                tmpArray.add(line);
            }
        }
        a = tmpArray;
    }

    //Trim function
    if(trim <= 0){
        // System.out.print("You cant do that!!");
    } else {
        // if(!trim) trim = 1;
        ArrayList<String> tmpArray = new ArrayList<String>();
        for(String line : a){
            if(trim > (line.length())) {
                String split = line.substring(0, line.length());
                tmpArray.add(split);
            } else {
                String split = line.substring(0, trim);
                tmpArray.add(split);
            }
        }
        a = tmpArray;
    }

    //List Function
    if(list) {
        ArrayList<String> tmpArray = new ArrayList<String>();
        int counter = 1;
        for (String line : a) {
            line = counter + " " + line;
            counter++;
            tmpArray.add(line);
        }
        a = tmpArray;
    }


    //Convert Array to String
    String output = "";
    for(String line : a){
        output = output + line + System.lineSeparator();
    }




    try {
        writeOutput(output);
    } catch (IOException e) {
        e.printStackTrace();
    }

  }
  
}



    // try {
    //   File file = new File(filepath);

    //   if (file.createNewFile()) {
    //     System.out.println("File is created!");
    //   } else {
    //     System.out.println("File is already existed!");
    //   }

	  // } catch (IOException e) {
		//   e.printStackTrace();
	  // }