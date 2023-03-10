package com.example.demo.Controller;

import com.example.demo.Entities.Profile;
import com.example.demo.Entities.User;
import com.example.demo.Repository.MealRepository;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
	//@Autowired
	//PasswordEncoder encoder;
	@Autowired
	private MealRepository mealRepository;
	@Autowired
	private UserService userService;

	//@GetMapping("/")
	//public String homePage(){
	//	return"home";
	//}
	@GetMapping("/")
	public String loginPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}

	@PostMapping("/added")
	public String register(@ModelAttribute User user, Model model) {
		model.addAttribute("user", user);
		//user.setPassword(encoder.encode(user.getPassword()));
		userService.addUser(user);

		return "profile";
	}

	@GetMapping("/login")
	public String Login(Model model){
		User user=new User();
		 model.addAttribute("user",user);
		return "login";
		}
		//@PostMapping("/dologin")
	//	public String dologin(HttpSession session, @RequestParam String userName,@RequestParam String password ) {
           // User user=userService.findByUsername(userName);

			//User userName1 = userService.findByUserName(user.getUserName());
			//User password1 = userService.findByPassword(user.getPassword());

			//if (userName1 !=null){
			//	model.addAttribute("userName",userName1.getUserName());
			//	model.addAttribute("password",password1.getPassword());
				//return "profile";
		//	*//*} else {
			//	return "redirect:/login";
 		//	}*/

		//}




}
