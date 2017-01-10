package com.example.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by suxin on 17-1-6.
 */
public class JDBCLdap {
    public static void main(String[] args) throws Exception {
        Class.forName("com.octetstring.jdbcLdap.sql.JdbcLdapDriver");
        String ldapConnectString = "jdbc:ldaps://ldap.jeejen.com:636/o=teemlink,c=cn?SEARCH_SCOPE:=subTreeScope";
        Connection con = DriverManager.getConnection(ldapConnectString, "cn=Manager,o=teemlink,c=cn", "secret");

        String sql = "SELECT * FROM ou=develop,o=teemlink,c=cn";

        Statement sta = con.createStatement();
        ResultSet rs = sta.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }

        if (con != null)
            con.close();
    }
}
