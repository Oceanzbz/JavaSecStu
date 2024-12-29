package com.ocean;

import java.io.IOException;

public class zbz {
    public String cmd;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) throws IOException {
        this.cmd = cmd;
        Runtime.getRuntime().exec(this.cmd);
    }
}
