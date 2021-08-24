package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Product;
import com.google.gson.Gson;

@Controller
@RequestMapping(value="/emp")
public class HomeController
{
	@GetMapping("/")
	@ResponseBody
    public String test()
    {
       return "This is my Index Page";
    }
	
	@GetMapping("/view")
	@ResponseBody
    public String view()
    {
		List<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		Gson gson=new Gson();
       return gson.toJson(list);
    }
	
	@GetMapping("/products")
	@ResponseBody
    public ModelAndView viewProduct()
    {
		ModelAndView mav = new ModelAndView();	
		mav.setViewName("index");
		mav.addObject("p",new Product(1515, "ecec", 849));
		return mav;
    }
	
	@PostMapping("/create")
	@ResponseBody
    public String create()
    {
       return "This is my create Page";
    }
	
	@PutMapping("/update")
	@ResponseBody
    public String update()
    {
       return "This is my update Page";
    }
	
	@DeleteMapping("/delete")
	@ResponseBody
    public String delete()
    {
       return "This is my delete Page";
    }
	
	 
}