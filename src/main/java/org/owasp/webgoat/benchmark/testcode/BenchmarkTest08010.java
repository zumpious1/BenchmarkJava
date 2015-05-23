/**
* OWASP WebGoat Benchmark Edition (WBE) v1.1
*
* This file is part of the Open Web Application Security Project (OWASP)
* WebGoat Benchmark Edition (WBE) project. For details, please see
* <a href="https://www.owasp.org/index.php/WBE">https://www.owasp.org/index.php/WBE</a>.
*
* The WBE is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The WBE is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details
*
* @author Dave Wichers <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08010")
public class BenchmarkTest08010 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format(java.util.Locale.US,"notfoo",obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a80491 = param; //assign
		StringBuilder b80491 = new StringBuilder(a80491);  // stick in stringbuilder
		b80491.append(" SafeStuff"); // append some safe content
		b80491.replace(b80491.length()-"Chars".length(),b80491.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map80491 = new java.util.HashMap<String,Object>();
		map80491.put("key80491", b80491.toString()); // put in a collection
		String c80491 = (String)map80491.get("key80491"); // get it back out
		String d80491 = c80491.substring(0,c80491.length()-1); // extract most of it
		String e80491 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d80491.getBytes() ) )); // B64 encode and decode it
		String f80491 = e80491.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f80491); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass