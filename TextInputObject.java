package networking;
import java.util.Scanner;

//TextInputObject class
public class TextInputObject implements Runnable {
   
  private Scanner inputReader = new Scanner(System.in);
  public String lastInput = "-";

  //Method that gets called when the object is instantiated
  public TextInputObject() {
    System.out.println("Created TextInputObject");
  }

  //create a thread object and check if it's not already created
  static Thread thread;

  //This method gets called from the main
  public void start() {
    if (thread == null) {
      thread = new Thread(this);
      thread.start();
    }
  }

  //this method gets called by the thread.start(); from above
  @Override
  public void run() {
    System.out.println("Text input thread created and now it runs");
    readTextFromConsole();
  }

  //check for input all the time - THIS WILL NOT HALT THE PROGRAM
  public void readTextFromConsole() {
    System.out.print("");
    lastInput = inputReader.nextLine();
    readTextFromConsole();
  }

}
