package com.ace.explore.cloud;

import org.junit.Test;
import sun.misc.Unsafe;
import sun.misc.VM;
import sun.misc.Version;

import java.nio.charset.Charset;

/**
 * Created by zhangwanli on 2018/6/5.
 */
public class CharsetTest {

    @Test
    public void charsets() {
        Charset charsetUTF8 = Charset.forName("utf-8");
        Charset gbk = Charset.forName("GBK");
        System.out.println(charsetUTF8);
        System.out.println(gbk);
    }

    public static void main(String[] args) {
        boolean syntax = VM.allowArraySyntax();
        Version.println();
        Unsafe unsafe = Unsafe.getUnsafe();
        System.out.println("zzzzz");
    }

}
