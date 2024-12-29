package org.example;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        new java.lang.ProcessBuilder("bash", "-c", "open -a Calculator").start();

    }
}
