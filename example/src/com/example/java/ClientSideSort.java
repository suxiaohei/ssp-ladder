//package com.example.java;
//
///**
// * Created by suxin on 17-1-9.
// */
//
//import com.novell.ldap.*;
//import com.novell.ldap.LDAPConnection;
//
//import java.io.UnsupportedEncodingException;
//import java.util.Arrays;
//import java.util.Enumeration;
//import java.util.Iterator;
//import java.util.Set;
//import java.util.TreeSet;
//
//public class ClientSideSort {
//
//    public static void main(String[] args) {
//        int ldapPort = LDAPConnection.DEFAULT_PORT;
//        int searchScope = LDAPConnection.SCOPE_ONE;
//        int ldapVersion = LDAPConnection.LDAP_V3;
//
//        String ldapHost = "ldap.jeejen.com";
//        String loginDN = "cn=suxin,ou=users,dc=jeejen,dc=com";
//        String password = "suxin123";
//        String searchBase = "dc=jeejen,dc=com";
//        String searchFilter = "objectClass=*";
//
//        LDAPConnection conn = new LDAPConnection();
//
//        try {
//
//            // connect to the server
//            conn.connect(ldapHost, ldapPort);
//            // bind to the server
//            conn.bind(ldapVersion, loginDN, password.getBytes("UTF8"));
//            LDAPSearchResults searchResults =
//                    conn.search(searchBase,
//                            searchScope,
//                            searchFilter,
//                            new String[]{"cn", "uid", "sn"},//attributes
//                            false);       // return attrs and values
//
//
//
//
//            /* sortedResults will sort the entries according to the natural
//             * ordering of LDAPEntry (by distiguished name).
//             */
//
//            TreeSet sortedResults = new TreeSet();
//            while (searchResults.hasMore()) {
//                try {
//                    sortedResults.add(searchResults.next());
//                } catch (LDAPException e) {
//                    System.out.println("Error: " + e.toString());
//                    // Exception is thrown, go for next entry
//                    continue;
//                }
//            }
//            // print the sorted results
//            System.out.println("\n" +
//                    "****************************\n" +
//                    "Search results sorted by DN:\n" +
//                    "****************************");
//            Iterator i = sortedResults.iterator();
//            while (i.hasNext()) {
//                printEntry((LDAPEntry) i.next());
//            }
//
//            /* resort the results an an array using a specific comparator */
//            String namesToSortBy[] = {"sn", "uid", "cn"};
//            boolean sortAscending[] = {true, false, true};
//            LDAPCompareAttrNames myComparator = new LDAPCompareAttrNames(
//                    namesToSortBy, sortAscending);
//            Object sortedSpecial[] = sortedResults.toArray();
//            Arrays.sort(sortedSpecial, myComparator);
//            // print the re-sorted results
//            System.out.println("\n" +
//                    "*****************************************************\n" +
//                    "Search results sorted by sn, uid(Descending), and cn:\n" +
//                    "*****************************************************");
//            for (int j = 0; j < sortedSpecial.length; j++) {
//                printEntry((LDAPEntry) sortedSpecial[j]);
//            }
//            // disconnect with the server
//            conn.disconnect();
//        } catch (LDAPException e) {
//            System.out.println("Error: " + e.toString());
//        } catch (UnsupportedEncodingException e) {
//            System.out.println("Error: " + e.toString());
//        }
//        System.exit(0);
//
//    }
//
//
//    /**
//     * Prints the DN and attributes in an LDAPEntry to System.out.
//     * <p>
//     * This method used TreeSet to sort the attributes by name.
//     */
//
//    public static void printEntry(LDAPEntry entry) {
//
//        /* To print an entry,
//
//         *   -- Loop through all the attributes
//
//         *   -- Loop through all the attribute values
//
//         */
//
//
//        System.out.println(entry.getDN());
//
//        System.out.println("\tAttributes: ");
//
//
//        LDAPAttributeSet attributeSet = entry.getAttributeSet();
//
//        Set sortedAttributes = new TreeSet(attributeSet);
//
//        Iterator allAttributes = sortedAttributes.iterator();
//
//
//        while (allAttributes.hasNext()) {
//
//            LDAPAttribute attribute =
//
//                    (LDAPAttribute) allAttributes.next();
//
//            String attributeName = attribute.getName();
//
//
//            System.out.println("\t\t" + attributeName);
//
//
//            Enumeration allValues = attribute.getStringValues();
//
//
//            if (allValues != null) {
//
//                while (allValues.hasMoreElements()) {
//
//                    String Value = (String) allValues.nextElement();
//
//                    System.out.println("\t\t\t" + Value);
//
//                }
//
//            }
//
//        }
//
//        return;
//
//    }
//
//}
