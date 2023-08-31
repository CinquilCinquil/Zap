package networking;
import java.util.Scanner;

//Main app
public class textInpuOutputManager {

    //here we create the two threads (objects that implement the runnable interface)
    static TextInputObject ti;
    static TextOutputObject to;

    public static void main(String[] args) {
        //we instantiate the objects
        ti = new TextInputObject();
        to = new TextOutputObject();
        //we call the start method to start the threads for input and output
        ti.start();
        to.start();
    }

}

