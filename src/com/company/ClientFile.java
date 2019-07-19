package com.company;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientFile {
    public static void main(String[] args) {
        try {
            Scanner sc=new Scanner(System.in);

            Socket s =new Socket("10.25.17.141",8888);

            OutputStream out=s.getOutputStream();
            InputStream in=s.getInputStream();
            DataOutputStream dout=new DataOutputStream(out);
            //DataInputStream din=new DataInputStream(in);

            FileOutputStream fos=new FileOutputStream("d:/Alita.Battle.Angel.2019.BluRay.1080p.DDP7.1.x264-TnP.mkv");

            byte[] buffer=new byte[1024*1024];

            int len=in.read(buffer);
            while (len!=-1)
            {
                fos.write(buffer,0,len);
                len=in.read(buffer);
            }



        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
