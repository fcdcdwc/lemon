/*
package com.fcdcdwc.lemon.common.aop;

import com.fcdcdwc.lemon.common.annotation.LockTransaction;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

*/
/**
 * @author liyandi
 * @program: lemon
 * @description: Redisson实现事务锁切面
 * @date 2022-06-28 15:25:55
 *//*

@Aspect
public class RequestLockAspect implements Ordered {

	*/
/*private static final Logger log = LoggerFactory.getLogger(RequestLockAspect.class);
	private static final ThreadLocal<RLock> threadLocal = new ThreadLocal<RLock>();

	@Autowired
	private RedissonClient redisson;
	public static final long WAITTIME=15L;//分布式锁超时时间

	*//*
*/
/*@PointCut注解表示表示横切点，哪些方法需要被横切*//*
*/
/*
	*//*
*/
/*切点表达式*//*
*/
/*
	@Pointcut("@annotation(lockTransaction)")
	public  void print(LockTransaction lockTransaction) {}

	*//*
*/
/*@Before注解表示在具体的方法之前执行*//*
*/
/*
	@Before("print(lock)")
	public void before(JoinPoint joinPoint, LockTransaction lockTransaction) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		String className=signature.getMethod().getDeclaringClass().getName();
		String key = lock.key();
		String prefix = lock.prefix();
		if(StrUtil.isBlank(prefix)){
			prefix=className+"-"+method.getName();
		}
		key=getLockKey(joinPoint,signature,key);
		if(StrUtil.isNotBlank(key)) {
			String redissonKey=prefix + "." + key;
			redissonKey=redissonKey.intern();
			RLock rLock = redisson.getLock(redissonKey);
			try {
				//最多等待5秒,30秒后自动释放锁
				boolean b = rLock.tryLock(WAITTIME,30L,TimeUnit.SECONDS);
				if(!b){
					throw new SelfException("当前接口有多个线程访问！访问没有释放！,请稍后再试了！");
				}
				threadLocal.set(rLock);
			} catch (InterruptedException e) {
				e.printStackTrace();
				release();
			}
		}
	}

	private String getLockKey(JoinPoint joinPoint,MethodSignature signature,String key){
		if(SU.isNotBlank(key)){
			Object[] args = joinPoint.getArgs();
			int argsSize=args.length;
			//解析key p0....    #name.property
			String keyNumberStr=null;
			if(key.startsWith("p")&&key.length()==2&&isNumeric(keyNumberStr=key.substring(1))){
				Integer keyNumber=null;
				if((keyNumber=Integer.valueOf(keyNumberStr))>(argsSize-1)){
					log.error("key的参数index大于的传入的参数index");
				}else{
					Object objects=args[keyNumber];
					String keyValue=getObjectKeyValue(objects);
					return keyValue;
				}
			}else if(key.startsWith("#")){
				String keyStr=key.substring(1);
				String[] keyStrArrays=keyStr.split("\\.");
				String paramName=keyStrArrays[0];
				String paramProperty=keyStrArrays[1];
				String[] parameterNames = signature.getParameterNames();
				int index=-1;
				for (int i = 0; i < parameterNames.length; i++) {
					if(paramName.equals(parameterNames[i])){
						index=i;
						break;
					}
				}
				if(index!=-1){
					Object object=args[index];
					Class<?> clazz=object.getClass();
					try {
						Method propertyMethod=clazz.getMethod("get" + firstUpper(paramProperty));
						Object value=propertyMethod.invoke(object);
						String keyValue=getObjectKeyValue(value);
						return keyValue;
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		}
		return null;
	}

	private String getObjectKeyValue(Object objects){
		return objects.toString();
	}
	public static boolean isNumeric(String str){
		for (int i = str.length();--i>=0;){
			if (!Character.isDigit(str.charAt(i))){
				return false;
			}
		}
		return true;
	}

	*//*
*/
/*@After注解表示在方法执行之后执行*//*
*/
/*
	@After("print(lock)")
	public void after(JoinPoint joinPoint,Lock lock) {
	}


	//下面两个方法必定会进一个方法
	@AfterThrowing(value = "print(lock)",throwing = "exception")
	public void doAfterThrowingAdvice(JoinPoint joinPoint,Lock lock,Throwable exception){
		release();
	}

	*//*
*/
/*@AfterReturning注解用于获取方法的返回值*//*
*/
/*
	@AfterReturning(pointcut = "print(lock)", returning = "object")
	public void getAfterReturn(Object object,Lock lock) {
		release();
	}
	private void release(){
		RLock rLock = threadLocal.get();
		if(rLock!=null) {
			if(rLock.isHeldByCurrentThread()) {
				rLock.unlock();
				threadLocal.remove();
			}
		}
	}

	@Override
	public int getOrder() {
		return 1;
	}*//*

}
*/
