package com.dentist.webapp;

import java.io.IOException;
import java.util.Locale;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dentist.domain.UserAuthentication;
import com.dentist.util.CalendarEventHandler;
import com.dentist.util.EmailGenerator;
import com.dentist.util.EmailStructure;
import com.dentist.webapp.SessionHandler;
import com.dentist.service.UserServiceInterface;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

	private static final Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	ServletContext servletContext;
	@Autowired
	private AuthenticationSuccessHandler successHandler;
	@Autowired
	private SessionRegistry sessionRegistry;
	@Autowired
	private CalendarEventHandler calendarEventHandler;
	@Autowired
	private UserServiceInterface userServiceInterface;
	@Autowired
	private EmailGenerator emailSender;
	@Autowired
	private EmailStructure emailStructure;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String loginForm(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is " + locale.toString());
		model.addAttribute("serverTime",new DateTime().toString());
		return "login";

	}

	@RequestMapping(value = "/process", method = RequestMethod.POST)
	public String Customlogin(HttpServletRequest request, HttpServletResponse response,Model model,@RequestParam String email,@RequestParam String password)
			throws IOException, ServletException {

		UserAuthentication userAuth = userServiceInterface.getUserAuthenticationInfoByEmail(email);
		if (userAuth != null) {
			if (userAuth.getUserPwd().equals(password)) {
				SessionHandler.handleSession(sessionRegistry, successHandler, request, response, userAuth);
				return null;
			}
		} 
		model.addAttribute("serverTime",new DateTime().toString());
		return "login";
	}

}
