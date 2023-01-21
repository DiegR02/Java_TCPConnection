import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) throws Exception {
        String host= "127.0.0.1";
        int port= 5000;
        DataInputStream in;
        DataOutputStream out;

        try {
            //New Socket
            Socket sc = new Socket(host, port);
            
            in= new DataInputStream(sc.getInputStream());
            out= new DataOutputStream(sc.getOutputStream());

            //Sending message to the server
            out.writeUTF("Hello worl from the client!");

            //Reading message from the server
            String message= in.readUTF();

            System.out.println(message);

            //Closing the client
            sc.close();



        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
