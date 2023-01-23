import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws Exception {
        
        ServerSocket server= null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;

        int port= 5000;

        try {
            server= new ServerSocket(port);
            System.out.println("Server on");

            while(true){
                //Waiting for a client...
                sc = server.accept();

                System.out.println("Client connected");

                in = new DataInputStream(sc.getInputStream());
                out= new DataOutputStream(sc.getOutputStream());

                //Reading message from the client
                String message= in.readUTF();
                System.out.println(message);

                //Sending message to the client
                out.writeUTF("Hello world from the server!");
                
                //Closing the client
                sc.close();

                System.out.println("Client disconnnected");

            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
