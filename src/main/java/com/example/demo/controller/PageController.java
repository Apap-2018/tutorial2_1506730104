package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	/**
	@RequestMapping("/viral2jari")
	public String index() {
		return "viral";
	}
	
	@RequestMapping("/viral")
	public String viral() {
		return "viral";
	}
	
	@RequestMapping("/viral")
	public String index() {
		return "viral2jari";
	}
	*/
	
	/**
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name") String name, Model model){
		model.addAttribute("name", name);
		return "challenge";
	}
	*/
	
	/**
	@RequestMapping("viral/challenge")
	public String challenge(@RequestParam(value = "name") String name, Model model){
		model.addAttribute("name", name);
		return "challenge";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name", required = false) String name, Model model){
		model.addAttribute("name", name);
		return "challenge";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name", required = false, defaultValue = "kiki") String name, Model model){
		model.addAttribute("name", name);
		return "challenge";
	}
	*/
	
	@RequestMapping(value = {"/challenge", "challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model){
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}
	
	/**
	@RequestMapping(value = {"challenge/{name}"})
	public String challengePath(@PathVariable String name, Model model){
		model.addAttribute("name", name);
		return "challenge";
	}
	*/
	
	@RequestMapping("/generator")
	public String generator(@RequestParam(value="a") int a, @RequestParam(value="b") int b, Model m){
		String results = "hm";	
		int i = a;
		int j = b;
		while(i > 1) {
			results += "m";
			i--;
		}
		String temp = results;
		while (j > 1) {
			results += " " + temp;
			j--;
		}	
		m.addAttribute("results", results);
		m.addAttribute("a", a);
		m.addAttribute("b", b);
		return "generator";
	}
}
