import com.sun.org.apache.xalan.internal.xsltc.DOM;
import com.sun.org.apache.xalan.internal.xsltc.TransletException;
import com.sun.org.apache.xalan.internal.xsltc.runtime.AbstractTranslet;
import com.sun.org.apache.xml.internal.dtm.DTMAxisIterator;
import com.sun.org.apache.xml.internal.serializer.SerializationHandler;

import java.io.*;
public class Exp extends AbstractTranslet{
    public Exp() throws Exception {

        try {
            BufferedReader br = null;

            Process p = Runtime.getRuntime().exec("open -a Calculator");
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
                System.out.println(sb);
            }
            File file = new File("result.txt");

            if(!file.exists()){
                file.createNewFile();
            }


            FileWriter fileWritter = new FileWriter(file.getName(),true);
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            bufferWritter.write(sb.toString());
            bufferWritter.close();
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    @Override
    public void transform(DOM document, SerializationHandler[] handlers) throws TransletException {

    }

    @Override
    public void transform(DOM document, DTMAxisIterator iterator, SerializationHandler handler) throws TransletException {

    }
}
