package com.zwc.nettystudy.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class Server {
    public static void main(String[] args) throws Exception {
        AsynchronousServerSocketChannel open = AsynchronousServerSocketChannel.open();
        AsynchronousServerSocketChannel socketChannel = open.bind(new InetSocketAddress(8888));
        socketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            @Override
            public void completed(AsynchronousSocketChannel result, Object attachment) {

            }

            @Override
            public void failed(Throwable exc, Object attachment) {

            }
        });
    }
}
