package com.xomic.crud.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.xomic.crud.pojo.Country;
import com.xomic.crud.pojo.MasterLanguage;
import com.xomic.crud.pojo.MasterUserType;
import com.xomic.crud.pojo.State;
import com.xomic.crud.pojo.UserMaster;
import com.xomic.crud.request.UserExperiences;
import com.xomic.crud.request.UserRequest;
import com.xomic.crud.request.ValidationUserRequest;
import com.xomic.crud.service.UserService;

@org.springframework.stereotype.Controller
public class MyController {

	@Autowired
	private UserService userService; 
	
	
	@GetMapping("/")
	public String get(Model model ) {
		System.out.println("============++++++++++=======+ " + userService.getaD() + " \t\n "+ userService.ffT());
		List<Country> countries= new ArrayList<>();
		
		
		
		countries=userService.getALLCO();
		
		
		
		List<MasterUserType> masterUserTypes=userService.getUser();
		List<MasterLanguage> languages = new ArrayList<>();
		
		languages=userService.fetchLanguage();
		
		
		model.addAttribute("masterLanguage",languages);
		System.out.println(countries);
		model.addAttribute("country",countries);
		model.addAttribute("userType",masterUserTypes);
		int index=0;
		
		  UserRequest userRequest = new UserRequest();
	      userRequest.getUserExperiences().add(new UserExperiences()); // Add an initial experience
		
		model.addAttribute("index",index);
		model.addAttribute("userRequest", userRequest);
		
		
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/save")
	public String  getFormData(@ModelAttribute UserRequest userRequest, BindingResult result,Model model ) {
		ValidationUserRequest  validationUserRequest = new ValidationUserRequest();
		validationUserRequest.validate(userRequest, result);
		System.out.println("sssssssssss"+userRequest);
		 if (result.hasErrors()) {
		     // Handle binding errors
			 //System.err.println(" sajhb");
			 List<Country> countries= new ArrayList<>();
				
				
				
				countries=userService.getALLCO();
				
				
				
				List<MasterUserType> masterUserTypes=userService.getUser();
				List<MasterLanguage> languages = new ArrayList<>();
				
				languages=userService.fetchLanguage();
				
				
				model.addAttribute("masterLanguage",languages);
				System.out.println(countries);
				model.addAttribute("country",countries);
				model.addAttribute("userType",masterUserTypes);
			 return "index";
		    }
		 
		 System.out.println("FINAL VQAL::"+userRequest);
		 userService.saveUSer(userRequest);
		 System.err.println(userRequest.getLanguageId());
		 byte[] lan=userRequest.getLanguageId();
		 System.err.println(lan.toString());
		 for(int i=0;i<lan.length;i++) {
			 System.out.println(lan[i]);
		 }

		return "redirect:/display";
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/display")
	public String displayUser(Model model) {
		List<UserMaster> masters = userService.fetALLUser();
		model.addAttribute("masters",masters);
		return "display";
	}
	@RequestMapping(method = RequestMethod.GET,value = "/delete")
	public String delete(@RequestParam int parameter , Model model) {
		System.out.println("AAAAAAA!!!!!!!!!!!!!= "+parameter);
		return "display";
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/getState")
	@ResponseBody
	public  ResponseEntity<?> getState(@RequestParam("id") short id ) {
		System.out.println("IDDIDID"+id+"type"+ id);
		List<State> state= userService.getAllStateById(id);
		String jsonCountries = new Gson().toJson(state);
		System.out.println(state);
        //response.setContentType("application/json");
		
		return ResponseEntity.ok(jsonCountries);
	}
}
