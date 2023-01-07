package com.campingmapping.team4.spring.t4_01Member.model;

// package com.campingmapping.team4.spring.t4_01Member.model;
//
// import java.text.SimpleDateFormat;
// import java.util.Date;
//
// import javax.servlet.http.HttpSession;
//
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
//
// import com.campingmapping.team4.spring.t4_01Member.model.entity.License;
//
//
// public class LogoutBean {
// private static Logger log = LoggerFactory.getLogger(LogoutBean.class);
// HttpSession session;
//
// public LogoutBean(HttpSession session) {
// this.session = session;
// }
//
// public LogoutBean() {
// }
//
// public HttpSession getSession() {
// return session;
// }
//
// public void setSession(HttpSession session) {
// this.session = session;
// }
//
// public Integer getLogout() {
// License license = (License)session.getAttribute("license");
// String account = "";
// if (license != null) {
// account = license.getAccount();
// } else {
// account = "(未知)";
// }
// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
// log.info("使用者:" + account + "已於 " + sdf.format(new Date()) + " 登出...");
// session.invalidate();
// return 0;
// }
// }
