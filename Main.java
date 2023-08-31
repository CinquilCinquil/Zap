package networking;
import java.io.*;
import java.util.Scanner;

public class Main
{
    static TextInputObject ti;
    static TextOutputObject to;

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);

        System.out.println("CHOOSE: CLIENT 0, SERVER 1");

        int line = input.nextInt();

        //we instantiate the objects
        ti = new TextInputObject();
        to = new TextOutputObject();
        //we call the start method to start the threads for input and output
        ti.start();
        to.start();

        System.out.println("AAAAAAAAA");

        if (line == 0)
        {
            Networking client = new Networking("127.0.0.1", 5000, ti, to);
        }
        else {
            Networking server = new Networking(5000, ti, to);
        }
 
    }
}
