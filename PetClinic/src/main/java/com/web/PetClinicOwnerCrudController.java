package com.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.Owner;
import com.service.PetClinicService;

@Controller
public class PetClinicOwnerCrudController {

	@Autowired
	PetClinicService petClinicService;
	
	@RequestMapping(value="/owners/new",method=RequestMethod.GET)
	public String newOwner() {
		return "newOwner";
	}
	
	@ModelAttribute
	public Owner initModel() {
		return new Owner();
	}
	
	@RequestMapping(value="/owners/new",method=RequestMethod.POST)
	public String handlerFormSubmit(@ModelAttribute @Valid Owner owner,BindingResult result,RedirectAttributes redirectAttribute) {
		if(result.hasErrors()) {
			return "newOwner";
		}
		petClinicService.createOwner(owner);
		redirectAttribute.addFlashAttribute("message", "Add new owner with"+owner.getId());
		return "redirect:/owners";
	}
	
	@RequestMapping(value="/owners/update/{id}",method=RequestMethod.GET)
	public String loadUpdateOwner(@PathVariable Long id,ModelMap model) {
		Owner owner=petClinicService.findOwner(id);
		model.put("owner", owner);
		return "editOwner";
	}
	
	@RequestMapping(value="/owners/update/{id}",method=RequestMethod.POST)
	public String handlerUpdateFormSubmit(@ModelAttribute Owner owner,RedirectAttributes redirectAttribute) {
		petClinicService.updateOwner(owner);
		redirectAttribute.addFlashAttribute("message", "Updated with"+owner.getId());
		return "redirect:/owners";
	}
	
	@RequestMapping(value="/owners/delete/{id}",method=RequestMethod.GET)
	public String loadDeleteOwner(@PathVariable Long id,ModelMap model) {
		Owner owner=petClinicService.findOwner(id);
		model.put("owner", owner);
		return "deleteOwner";
	}
	
	@RequestMapping(value="/owners/delete/{id}",method=RequestMethod.POST)
	public String handlerDeleteFormSubmit(@PathVariable Long id) {
		petClinicService.deleteOwner(id);
		return "owners";
	}
}
