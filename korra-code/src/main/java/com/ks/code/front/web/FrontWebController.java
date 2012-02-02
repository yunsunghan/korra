package com.ks.code.front.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/front")
@Controller
public class FrontWebController {

	@RequestMapping(value="/about", method = RequestMethod.GET)
	public void about(Model uiModel){
	} 
	@RequestMapping(value="/pricingnsignup", method = RequestMethod.GET)
	public void pricingnsignup(Model uiModel){
	} 
	@RequestMapping(value="/help", method = RequestMethod.GET)
	public void help(Model uiModel){
	} 
}
