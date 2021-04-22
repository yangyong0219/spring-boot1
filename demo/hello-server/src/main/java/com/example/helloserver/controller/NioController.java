package com.example.helloserver.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/nio")
public class NioController {

    @PostMapping("/fileStream")
    public String fileStream() {
        //传统IO
        InputStream in;
        InputStreamReader inr;
        try {
            ClassPathResource resource = new ClassPathResource("a.txt");
            in = resource.getInputStream();
            inr = new InputStreamReader(in);
            char[] buf = new char[1024];
            int bufRead = inr.read(buf);
            while (bufRead != -1) {
                for (int i = 0; i < bufRead; i++) {
                    System.out.print(buf[i]);
                }
                bufRead = inr.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "fileNio";
    }

    @PostMapping("/fileNio")
    public String fileNio() {

        File file;
        FileInputStream fileInputStream;
        ClassPathResource resource = new ClassPathResource("a.txt");
        CharsetDecoder uft = StandardCharsets.UTF_8.newDecoder();
        try {
            file = resource.getFile();
            fileInputStream = new FileInputStream(file);
            FileChannel channel = fileInputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            CharBuffer charBuffer = CharBuffer.allocate(1024);
            int byteRead = channel.read(byteBuffer);
            while (byteRead != -1) {
                byteBuffer.flip();
                uft.decode(byteBuffer, charBuffer, false);
                charBuffer.flip();
                while (charBuffer.hasRemaining()) {
                    System.out.print(charBuffer.get());
                }
                byteBuffer.compact();
                charBuffer.compact();
                byteRead = channel.read(byteBuffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "fileNio";
    }



}
