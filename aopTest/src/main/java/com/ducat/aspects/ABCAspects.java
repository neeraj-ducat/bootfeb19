package com.ducat.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ABCAspects {

	
	//pointcut to identify a() method of ABC
	@Pointcut("execution(* com.ducat.beans.ABC.a(..))")
	public void pc1() {}
	
	//pointcut to identify b() method of ABC
	@Pointcut("execution(* com.ducat.beans.ABC.b(..))")
	public void pc2() {}
	
	//pointcut to identify c() method of ABC
	@Pointcut("execution(* com.ducat.beans.ABC.c(..))")
	public void pc3() {}

	
	//Advices are defined
	@Before("pc1() || pc3()")
	public void doBefore(JoinPoint jp)
	{
		System.out.println("Before advice is applied on "
	+jp.getSignature().getName()+"() method.");
	}
	
	/*@AfterReturning(pointcut="pc2()",returning="rvalue")
	public void doAfter(JoinPoint jp,String rvalue)
	{
		String mname=jp.getSignature().getName()+"()";
		System.out.println("After advice is applied on "
	+mname);
		System.out.println(rvalue+" is returned by "+mname);
		rvalue="failure";
		System.out.println("Return value is changed to failure by the advice.");
		System.out.println("after advice is completed.");
	}*/
	
	@Around("pc2()")
	public Object doPreAndPostProcessing(ProceedingJoinPoint jp)
	{
		Object rvalue="default";
		String mname=jp.getSignature().getName()+"()";
		System.out.println("Around advice is applied on "
	+mname);
		//Getting the intercepted method invoked
		try {
		rvalue=jp.proceed();
		System.out.println(rvalue+" is returned by "+mname);
		rvalue="failure";
		System.out.println("Return value is changed to failure by the advice.");
		System.out.println("around advice is completed.");
		}catch(Throwable e)
		{
			System.out.println(e);
		}
		return rvalue;
	}

	@AfterThrowing(pointcut="pc3()",throwing="err")
	public void errorHandler(JoinPoint jp, Exception err) throws Exception
	{
	System.out.println("Throws advice is applied on "+
	jp.getSignature().getName()+"() method because "
			+err+" occurred.");	
	}

}
