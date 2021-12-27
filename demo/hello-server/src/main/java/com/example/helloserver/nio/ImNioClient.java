package com.example.helloserver.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class ImNioClient {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("172.28.224.185", 2001));
            if (socketChannel.finishConnect()) {
                int i = 0;
                while (true) {
                    TimeUnit.SECONDS.sleep(1);
                    String info = "woshi" + i++ + "ci from client";
                    // clear会将limit与capacity设置成一样, 表示清空给buffer,
                    // compact将所有未读数据放在Buffer的起始处, 然后将position放在最后一个未读元素正后面, 此时写数据并不会覆盖未读数据
                    // limit也会和clear一样与capacity一致
                    buffer.clear();
                    buffer.put(info.getBytes(StandardCharsets.UTF_8));
                    buffer.flip();  //让position重回开始的位置, limit变为之前position的位置, 这样就有一个数据范围
                    /**
                     * 注意SocketChannel.write()方法的调用是在一个while循环中的。
                     * Write()方法无法保证能写多少字节到SocketChannel。所以，我们重复调用write()直到Buffer没有要写的字节为止。
                     * 非阻塞模式下,read()方法在尚未读取到任何数据时可能就返回了。所以需要关注它的int返回值，它会告诉你读取了多少字节。
                     */
                    while (buffer.hasRemaining()) {
                        System.out.println(buffer);
                        socketChannel.write(buffer);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
