package com.example.helloserver.nio;

import org.joda.time.LocalDateTime;
import org.joda.time.Period;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class TestMappedByteBuffer {
    public static void testBuffer() {
        FileChannel fileChannel;
        File file;
        FileInputStream fileInputStream;
        ClassPathResource resource = new ClassPathResource("a.pdf");
        try {
            file = resource.getFile();
            fileInputStream = new FileInputStream(file);
            fileChannel = fileInputStream.getChannel();
            LocalDateTime localDateTime = LocalDateTime.now();
            ByteBuffer buffer = ByteBuffer.allocate((int) file.length());
            fileChannel.read(buffer);
            System.out.println(new Period(localDateTime, LocalDateTime.now()).getMillis());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testMappedByteBuffer() {
        FileChannel fileChannel;
        File file;
        FileInputStream fileInputStream;
        ClassPathResource resource = new ClassPathResource("a.pdf");
        try {
            file = resource.getFile();
            fileInputStream = new FileInputStream(file);
            fileChannel = fileInputStream.getChannel();
            LocalDateTime localDateTime = LocalDateTime.now();
            MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            System.out.println(new Period(localDateTime, LocalDateTime.now()).getMillis());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        testBuffer();
        System.out.println("==========");
        testMappedByteBuffer();
    }

}
