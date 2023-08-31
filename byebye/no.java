/*
// A Java program for a serverSide
package networking;

import java.io.*;
import java.net.*;
 
public class Server {
 
    // initialize socket and input stream
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;
 
    // constructor with port
    public Server(int port)
    {
 
        // starts server and waits for a connection
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
 
            String line = "";
 
            // reads message from client until "End" is sent
            while (!line.equals("End")) {

                line = sendLine(line);
                line = receiveLine(line);
                
            }
 
            System.out.println("Closing connection");
 
            // close connection
            socket.close();
 
            in.close();
        }
 
        catch (IOException i) {
 
            System.out.println(i);
        }
    }

    public String sendLine(String line)
    {
        try {

            line = input.readLine();

            out.writeUTF(line); // sending info
        }

        catch (IOException i) {

            System.out.println(i);
        }
        
        return line;
    }

    public String receiveLine(String line)
    {
        try {

            line = in.readUTF(); // receiving info

            System.out.println("client - " + line);
        }

        catch (IOException i) {

            System.out.println(i);
        }

        return line;
    }
 
    public static void main(String[] args)
    {
        Server server = new Server(5000);
    }
}
*/
