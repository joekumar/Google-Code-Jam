package com.jp.common;

public class ExecutorApp {
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String inputFileName = "/Users/joekumar/Documents/workspace/CodeJam/src/com/jp/data/sample_input.txt";
    InputReader inputReader = new InputReader();
    inputReader.initializeInput(inputFileName);
    int numberOfCases = inputReader.getNumberOfCases();
    
    inputReader.setDoesInputHaveDataSetLines(false);
    inputReader.setNumberOfDataSetLines(3);
    
    for (int i = 1; i <= numberOfCases; i++) {
      
      try {
        String[] dataSet = inputReader.getDataSet();
        for (int j = 0; j < dataSet.length; j++) {
          System.out.println(" Data of " + i + " st data set and " + j
              + " th element is " + dataSet[j]);
        }
      }
      
      catch (Exception exp) {
        exp.printStackTrace();
        inputReader.closeScanner();
      }
      
    }
    
    inputReader.closeScanner();
    
  }
  
}
