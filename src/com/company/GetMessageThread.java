package com.company;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class GetMessageThread extends  Thread {
    //构造一个线程，只收
    private Socket s;
    public GetMessageThread(Socket s)
    {
        this.s=s;
    }
    @Override
    public void run() {
        InputStream in = null;
        try {
            in = s.getInputStream();
            DataInputStream din = new DataInputStream(in);
            while (true) {
                System.out.println("来自服务器的消息：" + din.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}