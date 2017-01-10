package com.example.java;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.UUID;

/**
 * Created by suxin on 17-1-6.
 */
public class LDAPConnection {

    public static void main(String[] args) {
        String url = "ldaps://ldap.jeejen.com:636/";
        String domain = "dc=jeejen,dc=com";
        String user = "cn=suxin,ou=users";
        String password = "suxin123";
        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory"); // LDAP 工厂
        env.put(Context.SECURITY_AUTHENTICATION, "simple"); // LDAP访问安全级别
        env.put(Context.PROVIDER_URL, url);
        env.put(Context.SECURITY_PRINCIPAL, user+","+domain); //  填DN
        env.put(Context.SECURITY_CREDENTIALS, password); // AD Password
        env.put("java.naming.ldap.attributes.binary", "objectSid objectGUID");
        LdapContext ldapCtx = null;
        try {
            ldapCtx = new InitialLdapContext(env , null);
            queryGroup(ldapCtx);
            //queryUser(ldapCtx);
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            if(ldapCtx != null) {
                try {
                    ldapCtx.close();
                } catch (NamingException e) {
                }
            }
        }
    }

    private static void queryGroup(LdapContext ldapCtx) throws NamingException {
        SearchControls searchCtls = new SearchControls();
        searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        String searchFilter = "objectClass=organizationalUnit";
        String searchBase = "ou=myDeptSubDept,ou=myDept,dc=DS-66,dc=com";
        String returnedAtts[] = {"distinguishedName", "objectGUID", "name"};
        searchCtls.setReturningAttributes(returnedAtts);
        NamingEnumeration<SearchResult> answer = ldapCtx.search(searchBase, searchFilter, searchCtls);
        while (answer.hasMoreElements()) {
            SearchResult sr = answer.next();
            Attributes Attrs = sr.getAttributes();
            if (Attrs != null) {
                NamingEnumeration<?> ne = Attrs.getAll();
                while(ne.hasMore()) {
                    Attribute Attr = (Attribute)ne.next();
                    String name = Attr.getID();
                    Enumeration<?> values = Attr.getAll();
                    if (values != null) { // 迭代
                        while (values.hasMoreElements()) {
                            String value = "";
                            if("objectGUID".equals(name)) {
                                value = UUID.nameUUIDFromBytes((byte[]) values.nextElement()).toString();
                            } else {
                                value = (String)values.nextElement();
                            }
                            System.out.println(name + " " + value);
                        }
                    }
                }
                System.out.println("=====================");
            }
        }

    }

}
