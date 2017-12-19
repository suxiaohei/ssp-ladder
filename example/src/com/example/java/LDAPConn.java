//package com.example.java;
//
//import com.novell.ldap.*;
//import com.novell.ldap.LDAPConnection;
//
//import java.io.UnsupportedEncodingException;
//
///**
// * Created by suxin on 17-1-6.
// */
//public class LDAPConn {
//
//    public static void main(String[] args)
//
//    {
//        int ldapPort = LDAPConnection.DEFAULT_SSL_PORT;
//        int searchScope = LDAPConnection.SCOPE_ONE;
//        int ldapVersion = LDAPConnection.LDAP_V3;
//        boolean attributeOnly = false;
//        String attrs[] = null;
//        String ldapHost = "ldap.jeejen.com";
//        String loginDN = "cn=suxin,ou=users,dc=jeejen,dc=com";
//        String password = "suxin123";
//        String searchBase = "dc=jeejen,dc=com";
//        String searchFilter = "objectClass=*";
//
//        LDAPConnection lc = new LDAPConnection(new LDAPJSSEStartTLSFactory());
//        try {
//            // connect to the server
//            lc.connect(ldapHost, ldapPort);
//            // bind to the server
//            lc.startTLS();
//            lc.bind(ldapVersion, loginDN, password.getBytes("UTF8"));
//
//            LDAPSearchResults searchResults =
//
//                    lc.search(searchBase, // container to search
//                            searchScope, // search scope
//                            searchFilter, // search filter
//                            attrs, // "1.1" returns entry name only
//                            attributeOnly); // no attributes are returned
//
//            // print out all the objects
//            while (searchResults.hasMore()) {
//                LDAPEntry nextEntry = null;
//                try {
//                    nextEntry = searchResults.next();
//                    System.out.println("\n" + nextEntry.getDN());
//                    System.out.println(nextEntry.getAttributeSet());
//                } catch (LDAPException e) {
//                    System.out.println("Error: " + e.toString());
//                    // Exception is thrown, go for next entry
//                    continue;
//                }
//            }
//
//            // disconnect with the server
//            lc.disconnect();
//
//        } catch (LDAPException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.exit(0);
//    }
//}
