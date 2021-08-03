package com.zehui.net.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;

public class NIOServer {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(8081));
            //设置为非阻塞模式
            serverSocketChannel.configureBlocking(false);
            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            //创建处理器
//            handler

            while (true) {
                //等待请求，每次等待阻塞3s，超过3s后线程继续向下运行，如果传入0或者不传参数将一致阻塞
                if (selector.select(3000) == 0) {
                    System.out.println("等待请求超时。。。。。");
                    continue;
                }
                System.out.println("处理请求。。。。");
//                获取待处理的selectionkey
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    //接受到链接请求
                    if (selectionKey.isAcceptable()) {

                    }
//                    读数据
                    //                处理完成后，从待处理的selectionkey迭代器中移除当前锁使用的key
                    iterator.remove();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static class Handler {
        private int bufferSize = 1024;
        private String localCharset = "UTF-8";

        public Handler() {
        }

        public Handler(int bufferSize) {
            this(bufferSize,null);
        }

        public Handler(String localCharset) {
            this(-1,localCharset);
        }

        public Handler(int bufferSize, String localCharset) {
            this.bufferSize = bufferSize;
            this.localCharset = localCharset;
        }

        public void handleAccept(SelectionKey selectionKey) throws IOException {
            SocketChannel socketChannel = ((ServerSocketChannel) selectionKey.channel()).accept();
            socketChannel.configureBlocking(false);
            socketChannel.register(selectionKey.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));

        }

        public void handleRead(SelectionKey key) throws IOException {
//            获取channel
            SocketChannel channel = (SocketChannel) key.channel();
//            获取buffer并重置
            ByteBuffer buffer = (ByteBuffer) key.attachment();
            buffer.clear();
//            没有读到内容则关闭
            if (channel.read(buffer) == -1) {
                channel.close();
            } else {
//                将buffer转为读状态
                buffer.flip();
//                将buffer中接受到的值按localcharset格式编码后保存到receivedString
                String receivedString = Charset.forName(localCharset).newDecoder().decode(buffer).toString();
                System.out.println("received data ：from client :" + receivedString);
//                返回数据给客户端
                String sendString = "received data : " + receivedString;
                ByteBuffer sendBuffer = ByteBuffer.wrap(sendString.getBytes(localCharset));
                channel.write(sendBuffer);
                channel.close();
            }


        }
    }

}
