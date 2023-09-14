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

        System.out.println("LETS GO");

        Networking netObj;
        String title;

        if (line == 0)
        {
            netObj = new Networking("127.0.0.1", 5000);
            title = "Client - Zap";
        }
        else {
            netObj = new Networking(5000);
            title = "Server - Zap";
        }

        GUI g = new GUI(title, netObj);

        ti = new TextInputObject(netObj);
        to = new TextOutputObject(netObj, g);

        ti.start();
        to.start();

        netObj.start(); // starting the while true loop
 
    }
}
