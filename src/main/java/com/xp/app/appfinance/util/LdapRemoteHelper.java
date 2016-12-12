/*
 * Copyright (c) 2012-2013, Lucky Air Company Ltd,.
 *
 * All rights reserved.
 */
package com.xp.app.appfinance.util;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class LdapRemoteHelper {

	private static DirContext ctx;

	public static DirContext getCtx(String username,String password) {

		String host = "10.2.1.72"; 
		String domain ="HNA.NET";
		String port = "389";
		String user = username + "@" + domain;
		String url = new String("ldap://" + host + ":" + port);
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.SECURITY_AUTHENTICATION,"simple");
		env.put(Context.SECURITY_PRINCIPAL,user);
		env.put(Context.SECURITY_CREDENTIALS,password);
		env.put(Context.PROVIDER_URL,url);
		DirContext ctx=null;
		try {
			ctx = new InitialDirContext(env);
		} catch (NamingException err) {
			ctx=null;
		}
		return ctx;
	}
	
	public static boolean authenticate(String usr, String pwd) {
		boolean success = false;
		DirContext ctx = null;
		try {
			ctx = LdapRemoteHelper.getCtx(usr,pwd);			
			if(ctx!=null){
				ctx.close();
				success = true;
			}
		} catch (Exception ex) {
			try {
				if (ctx != null) {
					ctx.close();
				}
			} catch (NamingException namingException) {
				namingException.printStackTrace();
			}
		} 
		return success;
	}
	
	public static void main(String[] args) {
		System.out.println(authenticate("xf-dong1",""));
	}
}
