package cn.zerry.server.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 *
 * @Author: linzengrui
 * @Date: 2020/4/21 16:48
 */
public class IOServer{
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8000);

        new Thread(() -> {
           while (true){
               try {

                   Socket socket = serverSocket.accept();

                   new Thread(() -> {
                      try {
                          int len;
                          byte[] data = new byte[1024];
                          InputStream inputStream = socket.getInputStream();

                          while ((len = inputStream.read(data)) != -1){
                              System.out.println(new String(data, 0, len));
                          }

                      }catch (Exception e){

                      }
                   }).start();

               }catch (Exception e){

               }
           }
        }).start();

    }
}