package ch.heigvd.quaris.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Home redirection to swagger api documentation 
 */
@Controller
public class HomeController {
	@RequestMapping(value = "/")
	@ResponseBody
	public String index() {
		return "<h1>Quaris</h1> <p>Quaris does not have a frontend, please use the API</p>";
	}
}
