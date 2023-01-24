// package com.campingmapping.team4.spring.utils.config;

// import java.util.HashSet;
// import java.util.Set;

// import org.aspectj.lang.JoinPoint;
// import org.aspectj.lang.annotation.Aspect;
// import org.aspectj.lang.annotation.Before;
// import org.aspectj.lang.annotation.Pointcut;
// import org.aspectj.lang.reflect.MethodSignature;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.EnableAspectJAutoProxy;
// import org.springframework.stereotype.Component;
// import org.springframework.web.bind.annotation.RequestMapping;

// @Configuration
// @EnableAspectJAutoProxy
// public class AOPConfig {

// @Aspect
// @Component
// public class AuthAspect {

// private Set<String> authPaths = new HashSet<>();

// @Pointcut("execution(public * *(..)) &&
// @annotation(org.springframework.security.access.prepost.PreAuthorize)")
// public void checkAuth() {
// }

// @Before("checkAuth()")
// public void beforeCheckAuth(JoinPoint joinPoint) {
// // 在這裡取得路徑
// String path = ((MethodSignature)
// joinPoint.getSignature()).getMethod().getAnnotation(RequestMapping.class)
// .value()[0];

// System.out.println(path);

// authPaths.add(path);
// }

// public Set<String> getAuthPaths() {
// return authPaths;
// }
// }

// }