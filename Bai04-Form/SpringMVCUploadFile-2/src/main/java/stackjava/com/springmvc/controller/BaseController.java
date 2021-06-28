package stackjava.com.springmvc.controller;

import java.io.File;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import stackjava.com.springmvc.model.Customer;
import stackjava.com.springmvc.model.MyFile;
import stackjava.com.springmvc.service.BaseService;

@Controller

public class BaseController {
	BaseService baseService = new BaseService();
	@RequestMapping("/")
	public String index(Model model, Customer customer) {
		model.addAttribute("myFile", new MyFile());
		model.addAttribute("customer", new Customer());
		return "index";
	}
	@RequestMapping("/view")
	public String index(Model model) {
		model.addAttribute("customers",baseService.findAll());
		return "view";
	}
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String uploadFile(MyFile myFile, Customer customer) {
		try {
			MultipartFile multipartFile = myFile.getMultipartFile();
			String fileName = multipartFile.getOriginalFilename();
			File file = new File("D:/files", fileName);
			customer.setAvatar(fileName);
			baseService.save(customer);
			multipartFile.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "view";
	}

}
