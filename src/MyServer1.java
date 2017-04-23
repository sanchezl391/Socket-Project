    /**
     * Created by Luis Sanchez on 4/20/2017.
     */


    import java.io.*;
    import java.net.*;
    import java.awt.*;//NEWBOSTON
    import java.awt.event.*;//NEWBOSTON
    import javax.swing.*;//NEWBOSTON

    //Code that goes on server
    //Code Retrieved from: http://stackoverflow.com/questions/28308584/connecting-two-computers-for-client-server-communication-in-java

    public class MyServer1 extends JFrame{//"extends JFrame" NEWBOSTON
//        private JTextField message;//NEWBOSTON.
//        private JTextArea allChatHistory;//NEWBOSTON

        ServerSocket ss;
        Socket s;
        DataInputStream dis;
        DataOutputStream dos;
        InetAddress addr;

        public MyServer1()
        {
            try
            {

                System.out.println("Server Started");
                addr = InetAddress.getByName("127.0.0.1");
                ss=new ServerSocket(3306, 1000,addr);
                s=ss.accept();
                System.out.println(s);
                System.out.println("CLIENT CONNECTED");
                dis= new DataInputStream(s.getInputStream());
                dos= new DataOutputStream(s.getOutputStream());
                ServerChat();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }

        public static void main (String as[])
        {
            new MyServer1();
        }

        public void ServerChat() throws IOException
        {
            String str, s1;
            do
            {
                str=dis.readUTF();
                System.out.println("Client Message:"+str);
                BufferedReader br=new BufferedReader(new   InputStreamReader(System.in));
                s1=br.readLine();
                dos.writeUTF(s1);
                dos.flush();
            }
            while(!s1.equals("bye"));
        }
    }
