package org.example;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.Base64;
import java.util.Base64.Encoder;
public class test {
    public static void main(String[] args) {
        byte[] buffer = null;
        String filepath = "/Users/ocean/Cybersecurity/Java_project/FastjsonStu/target/test-classes/org/example/EvilClass.class";
        try {
            FileInputStream fis = new FileInputStream(filepath);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while((n = fis.read(b))!=-1) {
                bos.write(b,0,n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        }catch(Exception e) {
            e.printStackTrace();
        }
        Encoder encoder = Base64.getEncoder();
        String value = encoder.encodeToString(buffer);
        System.out.println(value);
    }
}
