/**
 * Created by Luis Sanchez on 4/20/2017.
 */
//code for client
//Code Retrieved from: http://stackoverflow.com/questions/28308584/connecting-two-computers-for-client-server-communication-in-java
import java.io.*;
import java.net.*;

public class MyClient1 {
    Socket s;
    DataInputStream din;
    DataOutputStream dout;
    String serverIP = "127.0.0.1";  // Indicating the place to put Server's IP

    public MyClient1()
    {
        try
        {
            s=new Socket(serverIP, 3306);//server's IP address
            System.out.println(s);
            din= new DataInputStream(s.getInputStream());
            dout= new DataOutputStream(s.getOutputStream());
            ClientChat();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void ClientChat() throws IOException
    {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String s1;
        do
        {
            s1=br.readLine();
            dout.writeUTF(s1);
            dout.flush();
            System.out.println("Server Message:"+din.readUTF());
        }
        while(!s1.equals("stop"));
    }
    public static void main(String args[])
    {
        new MyClient1();
    }
}
