// A Java program for a ClientSide
package networking;

import java.io.*;
import java.net.*;
 
public class Networking {
 
    // initialize socket and input output streams
    private Socket socket = null;
    private ServerSocket server = null;
    private DataOutputStream out = null;
    private DataInputStream in = null;
    private DataInputStream input = null;

    public TextInputObject inputObj;
    public TextOutputObject outputObj;

    private String lastLine = "-";

    public Networking(int port, TextInputObject inputObj, TextOutputObject outputObj) // Server constructor
    {
        this.inputObj = inputObj;
        this.outputObj = outputObj;

        connectServer(port);
 
        exchangeMsgs();
 
        disconnect();
    }

    public Networking(String address, int port, TextInputObject inputObj, TextOutputObject outputObj) // Client constructor
    {
        this.inputObj = inputObj;
        this.outputObj = outputObj;

        connectClient(address, port);
 
        exchangeMsgs();
 
        disconnect();
    }

    // --------------------------------- Networking    

    private void connectServer(int port)
    {
        try {
            server = new ServerSocket(port);
 
            System.out.println("Server started");
 
            System.out.println("Waiting for a client ...");
 
            socket = server.accept();
 
            System.out.println("Client accepted");

            // takes input from terminal
            input = new DataInputStream(System.in);
 
            // takes input from the client socket
            in = new DataInputStream( new BufferedInputStream(socket.getInputStream()));

            // sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());
        }

        catch (IOException i) {System.out.println(i);}
    }

    private void connectClient(String address, int port)
    {
        // establish a connection
        try {
 
            socket = new Socket(address, port);
 
            System.out.println("Connected");
 
            // takes input from terminal
            input = new DataInputStream(System.in);
 
            // sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());

            // takes input from the server socket
            in = new DataInputStream( new BufferedInputStream(socket.getInputStream()));
        }
 
        catch (UnknownHostException u) {System.out.println(u);}
 
        catch (IOException i) {System.out.println(i);}
    }

    private void disconnect()
    {
        // close the connection
        try {

            input.close();
            out.close();
            socket.close();
        }
 
        catch (IOException i) {System.out.println(i);}
    }

    // --------------------------------- Exchanging information

    private void exchangeMsgs()
    {
        // string to read message from input
        String line = "";
 
        // keep reading until "End" is input
        while (!line.equals("End")) {
 
            line = sendLine(line);
            line = receiveLine(line);
            
        }
    }

    public String sendLine(String line)
    {
        try {

            line = inputObj.lastInput;
            out.writeUTF(line); // sending info
        }

        catch (IOException i) {System.out.println(i);}
        
        return line;
    }

    public String receiveLine(String line)
    {
        try {

            line = in.readUTF(); // receiving info
            outputObj.lastOutput = "other: " + line;
            
        }

        catch (IOException i) {System.out.println(i);}

        return line;
    }
}
