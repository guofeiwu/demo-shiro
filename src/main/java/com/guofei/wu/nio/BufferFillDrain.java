package com.guofei.wu.nio;

import java.nio.CharBuffer;

/**
 * @author 吴国飞
 * @version v1.0
 * @since 2018/11/16
 */
public class BufferFillDrain {
    private static int index = 0;

    public static void main(String[] args) {
//        fillDrainBuffer();
//        buffer1();
//        createBuffer();
        copyBuffer();
    }

    private static void fillDrainBuffer() {
        // 分配内存
        CharBuffer buffer = CharBuffer.allocate(100);
        while (fillBuffer(buffer)) {
            buffer.flip();
            drainBuffer(buffer);
            buffer.clear();
        }
    }


    private static void drainBuffer(CharBuffer buffer) {
        for (int i = 0; i < 6; i++) {
            System.out.print(buffer.get());
        }
        System.out.println("---" + buffer.position() + "---" + buffer.limit());

        CharBuffer compact = buffer.compact();
//        compact.flip();
        System.out.println("compact---" + buffer.position() + "---" + buffer.limit());
        System.out.println("count:" + compact.remaining());
        compact.put('x').put('y').put('z');
        compact.flip();

        while (compact.hasRemaining()) {
            System.out.print(compact.get());
        }
        System.out.println("+++");
    }

    private static boolean fillBuffer(CharBuffer buffer) {
//        if (index >= strings.length) {
//            return (false);
//        }
        if (index >= 1) {
            return (false);
        }
        String string = strings[index++];
        for (int i = 0; i < string.length(); i++) {
            buffer.put(string.charAt(i));
        }
        return true;
    }

    private static String[] strings = {
            "ABCDEFGHIJ",
            "The product",
            "heheda",
            "Help me !"
    };


    private static void buffer1() {
        CharBuffer allocate = CharBuffer.allocate(10);
        allocate.put('a').put('b').put('d');
        CharBuffer allocate1 = CharBuffer.allocate(10);
        allocate1.put('a').put('b').put('d');

        allocate.limit(allocate.position()).position(0);
//        allocate1.limit(allocate1.position()).position(0);
//        allocate.flip();
//        allocate1.flip();


        boolean equals = allocate.equals(allocate1);
        System.out.println("equals:" + equals);


        int i = allocate.compareTo(allocate1);
        System.out.println("compareTo:" + i);

        while (allocate.hasRemaining()) {
            System.out.println("allocate: " + allocate.get());
        }
    }

    public static void createBuffer() {
        char[] mChars = new char[1000];
        CharBuffer wrap = CharBuffer.wrap(mChars);
        System.out.println("hasArray:" + wrap.hasArray());

        System.out.println("array():" + wrap.array());
        System.out.println("arrayOffset:" + wrap.arrayOffset());
    }

    public static void copyBuffer() {
        CharBuffer allocate = CharBuffer.allocate(10);
        allocate.put('a').put('b').put('d');


        System.out.println("order:" + allocate.order().toString());


        CharBuffer duplicate = allocate.duplicate();
        allocate.flip();
        while (allocate.hasRemaining()) {
            System.out.println(allocate.get());
        }
        System.out.println("------------" +allocate.remaining());

        System.out.println("position:"+allocate.position());

        CharBuffer compact = allocate.compact();
        compact.put('x');
        compact.flip();

        while (compact.hasRemaining()) {
            System.out.println(allocate.get());
        }


    }

}
