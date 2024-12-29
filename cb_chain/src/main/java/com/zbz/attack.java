package com.zbz;

import java.io.IOException;

public class attack {
    public static void main(String[] args) {
        try {
            Runtime.getRuntime().exec("open -a Calculator");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
