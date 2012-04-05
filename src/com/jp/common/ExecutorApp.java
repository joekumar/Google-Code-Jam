package com.jp.common;

import com.jp.storeCredit.StoreCredit;

public class ExecutorApp {
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
  // String inputFileName = "/Users/joekumar/Documents/workspace/CodeJam/src/com/jp/data/sample_input.txt";
  // String outputFileName = "/Users/joekumar/Documents/workspace/CodeJam/src/com/jp/data/sample_output.txt";
    String inputFileName = "/Users/joekumar/Downloads/A-large-practice.in";
    String outputFileName = "/Users/joekumar/Desktop/output/sample_output.txt";
    InputOutputProcessor inputOutputProcessor = new InputOutputProcessor();
    inputOutputProcessor.initializeInput(inputFileName);
    int numberOfCases = inputOutputProcessor.getNumberOfCases();
    
    String[] resultArray = new String[numberOfCases];
    inputOutputProcessor.setDoesInputHaveDataSetLines(false);
    inputOutputProcessor.setNumberOfDataSetLines(3);
    
    for (int i = 1; i <= numberOfCases; i++) {
      
      try {
        String[] dataSet = inputOutputProcessor.getDataSet();
       /* for (int j = 0; j < dataSet.length; j++) {
          System.out.println(" Data of " + i + " st data set and " + j
             + " th element is " + dataSet[j]);
        }*/
          StoreCredit storeCredit = new StoreCredit();
          int result[] = storeCredit.findStoreCredit(dataSet);
          String resultCase = "Case #"+ i + ": "+ result[0]+ " "+ result[1];
          resultArray[i-1] = resultCase;
          System.out.println(resultCase);
      }
      
      catch (Exception exp) {
        exp.printStackTrace();
        inputOutputProcessor.closeScanner();
      }
      
    }
    
    inputOutputProcessor.closeScanner();
    inputOutputProcessor.writeOutput(outputFileName, resultArray);
   
  }
  
}
