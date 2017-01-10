package com.example.java;

/**
 * Created by suxin on 17-1-9.
 */

import com.novell.ldap.*;
import com.novell.ldap.LDAPConnection;

import java.security.Security;

import java.io.UnsupportedEncodingException;

public class SSLConnection {

    public static void main(String[] args)  {

        int ldapPort = LDAPConnection.DEFAULT_SSL_PORT;
        int ldapVersion = LDAPConnection.LDAP_V3;
        String ldapHost = "ldap.jeejen.com";
        String loginDN = "cn=suxin,ou=users,dc=jeejen,dc=com";
        String password = "suxin123";
//        String path = "/home/suxin/server_ks";
        String path = "/home/suxin/server_ks";
        LDAPSocketFactory ssf;

        try {
            // Dynamically set JSSE as a security provider
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            // Dynamically set the property that JSSE uses to identify
            // the keystore that holds trusted root certificates
            System.setProperty("javax.net.ssl.trustStore", path);
            ssf = new LDAPJSSESecureSocketFactory();
            // Set the socket factory as the default for all future connections
            LDAPConnection.setSocketFactory(ssf);
            // Note: the socket factory can also be passed in as a parameter
            // to the constructor to set it for this connection only.
            LDAPConnection lc = new LDAPConnection();
            // connect to the server
            lc.connect(ldapHost, ldapPort);
            // authenticate to the server
            lc.bind(ldapVersion, loginDN, password.getBytes("UTF8"));
            // at this point you are connected with a secure connection
            System.out.println("Successful SSL bind with server.");
            lc.disconnect();
        } catch (LDAPException e) {
            System.out.println("Error: " + e.toString());
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error: " + e.toString());
        }
    }
}
