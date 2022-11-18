package com.zwc.nettystudy.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress("127.0.0.1",8888));
        ssc.configureBlocking(false);

        System.out.println("server start,listening on"+ssc.getLocalAddress());
        Selector selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> it = keys.iterator();
            while (it.hasNext()){
                SelectionKey key = it.next();
                it.remove();
                handle(key);
            }
        }
    }

    private static void handle(SelectionKey key) {
        if (key.isAcceptable()){
            try {
                ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
                SocketChannel socketChannel = ssc.accept();
                socketChannel.configureBlocking(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
