package com.fathi.aop;

import java.io.FileOutputStream;
import java.io.IOException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;

@Aspect
public class Logger {
	
	@Pointcut("execution(* withdraw(*))")
	public void withdraw() {}
	
	@Pointcut("execution(* dispose(*))")
	public void dispose() {}
	
	@Before("withdraw() || dispose()")
	public void beginTransaction(JoinPoint point) {
		System.out.println("Begin of " + point.toString());
		try {
			FileOutputStream file = new FileOutputStream("log.txt", true);
			file.write(("Begin of " + point.toString() + "\n").getBytes());
		    file.close();
	    } catch (IOException e) {
	      System.out.println("An error occurred => " + e.getMessage());
	    }
	}
	
	@After("withdraw() || dispose()")
	public void endTransaction(JoinPoint point) {
		System.out.println("End of " + point.toString());
		try {
			FileOutputStream file = new FileOutputStream("log.txt", true);
			file.write(("End of " + point.toString() + "\n").getBytes());
		    file.close();
	    } catch (IOException e) {
	      System.out.println("An error occurred => " + e.getMessage());
	    }
	}
	
	@AfterReturning("withdraw() || dispose()")
	public void successTransaction(JoinPoint point) {
		System.out.println("Success End of " + point.toString());
		try {
			FileOutputStream file = new FileOutputStream("log.txt", true);
			file.write(("Success End of " + point.toString() + "\n").getBytes());
		    file.close();
	    } catch (IOException e) {
	      System.out.println("An error occurred => " + e.getMessage());
	    }
	}
	
	@AfterThrowing("withdraw() || dispose()")
	public void failedTransaction(JoinPoint point) {
		System.out.println("Fail of " + point.toString());
		System.out.print("Method throwed an exception => ");
		try {
			FileOutputStream file = new FileOutputStream("log.txt", true);
			file.write(("Fail of " + point.toString() + "\n").getBytes());
			file.write("Method throwed an exception => ".getBytes());
		    file.close();
	    } catch (IOException e) {
	      System.out.println("An error occurred => " + e.getMessage());
	    }
	}
}
