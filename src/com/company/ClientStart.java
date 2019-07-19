package com.company;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientStart {
    public static void main(String[] args) {
        try {
            Scanner sc=new Scanner(System.in);

            //随即开的临时端口s
            Socket s =new Socket("10.25.17.141",8888);


            GetMessageThread get=new GetMessageThread(s);
            get.start();

            OutputStream out=s.getOutputStream();
            DataOutputStream dout=new DataOutputStream(out);


            while (true)
            {
                //send
                String msg=sc.nextLine();
                dout.writeUTF(msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
