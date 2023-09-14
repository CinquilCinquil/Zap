package networking;
import java.util.Scanner;

//TextOutputObject
public class TextOutputObject implements Runnable {

    public String lastOutput = "-";
    private String lastlastOutput = "-";
    Networking netObj;
    GUI g;

    //Method that gets called when the object is instantiated
    public TextOutputObject(Networking netObj, GUI g) {
        this.netObj = netObj;
        this.g = g;
        System.out.println("Created TextOutputObject");
    }

    static Thread thread;

    public void start() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void run() {
        System.out.println("Text output thread created and now it runs");

        //Make it output text every 4 seconds to test if you can input text while it's used for output
        for (int i = 0; i < 1000; i++) {
    
            //Pause
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {System.out.println("TEXT OUTPUT INTERUPTED");}
            
            lastOutput = netObj.lastOuput;
            Boolean b = new String(lastlastOutput).equals(lastOutput);

            if (!b)
            {
                System.out.println("i" + Integer.toString(i) + ": " + lastOutput);
                g.pushMsg(lastOutput);
                lastlastOutput = lastOutput;
            }
        }

        System.out.println("END OF CONNECTION. REBOBINE");
    }
}
