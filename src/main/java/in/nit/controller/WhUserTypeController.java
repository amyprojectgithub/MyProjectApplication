package in.nit.controller;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.ShipmentType;
import in.nit.model.WhUserType;
import in.nit.model.WhUserType;
import in.nit.service.IWhUserTypeService;
import in.nit.util.WhUserTypeUtil;
import in.nit.view.WhUserTypeExcelView;
import in.nit.view.WhUserTypePdfView;
@Controller
@RequestMapping("/whuser")
public class WhUserTypeController {
	@Autowired
	private IWhUserTypeService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private WhUserTypeUtil util;
	
	@RequestMapping("/register")
	public String showRegPage(Model model) {
		model.addAttribute("whUserType", new WhUserType());
		return "WhUserTypeRegister";
	}
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String saveWhUser(@ModelAttribute WhUserType user,Model model) {
		Integer id=0;
		String msg=null;
		model.addAttribute("whUserType", new WhUserType());
		id=service.saveWhUserType(user);
		if(id==0)
			msg="WhUserType is  not saved";
		else
			msg="WhUserType '"+id+"' is saved";
		model.addAttribute("message", msg);
		return "WhUserTypeRegister";
	}
	@RequestMapping("/all")
	public String getAllWhUser(Model model) {
		List<WhUserType> list=service.getAllWhUserType();
		model.addAttribute("list", list);
		return "WhUserTypeData";
	}
	@RequestMapping("/delete")
	public String DeleteWhUserType(@RequestParam("id")Integer id,Model model) {
		String msg=null;
		service.deleteWhUserType(id);
		msg="WhUserType '"+id+"' is deleted";
		model.addAttribute("message", msg);
		List<WhUserType> list=service.getAllWhUserType();
		model.addAttribute("list", list);
		return "WhUserTypeData";
	}
	
	 @RequestMapping("/edit")
     public String getOneWhUserType(@RequestParam("id")Integer id,Model model) {
   	  WhUserType wt=service.getOneWhUserType(id);
   	  model.addAttribute("whUserType", wt);
   	  return "WhUserTypeEdit";
     }
     @RequestMapping(value = "/update" ,method = RequestMethod.POST)
     public String updateWhUserType(@ModelAttribute WhUserType whUserType,Model model) {
   	  service.updateWhUserType(whUserType);
   	  String msg="WhUserType '"+whUserType.getWhUserId()+"' is updated";
   	  model.addAttribute("message",msg);
   	  List<WhUserType> list=service.getAllWhUserType();
   	  model.addAttribute("list", list);
   	  return "WhUserTypeData";
     }
     @RequestMapping("/view")
     public String showOneshipment(@RequestParam("id")Integer id,Model model) {
   	  WhUserType wt=service.getOneWhUserType(id);
   	  model.addAttribute("ob", wt);
   	  return "WhUserTypeView";
     }
     @RequestMapping("/excel")
     public ModelAndView showExcel(@RequestParam(value = "id",required = false)Integer id) {
   	  ModelAndView mav=new ModelAndView();
   	  //set view to mav
   	  mav.setView(new WhUserTypeExcelView());
   	  if(id==null) {
   		  //fetching data from database
   		  List<WhUserType> list=service.getAllWhUserType();
   		  //set model to mav
   		  mav.addObject("list",list);
   	  }else {
   		  //get One row
   		  WhUserType wt=service.getOneWhUserType(id);
   		  //set model to mav
   		  mav.addObject("list", Arrays.asList(wt));
   	  }
   	  return mav;
     }
     @RequestMapping("/pdf")
     public ModelAndView shoePdf(@RequestParam(value = "id",required = false)Integer id ) {
   	  ModelAndView mav=new ModelAndView();
   	  //set view to mav
   	  mav.setView(new WhUserTypePdfView());
   	  if(id==null) {
   		  //fetching data from database
   		  List<WhUserType> list=service.getAllWhUserType();
   		  //set model to mav
   		  mav.addObject("list",list);
   	  }else {
   		  //get One row
   		  WhUserType wt=service.getOneWhUserType(id);
   		  //set model to mav
   		  mav.addObject("list", Arrays.asList(wt));
   	  }
   	  return mav;
     }
     @RequestMapping("/charts")
     public String showCharts() {
   	  //get modes and mode-counts
   	  List<Object[]> data=service.getWhUserTypeCount();
   	  //get RealPath
   	  String path=context.getRealPath("/");
   	  //invoke the util methods
   	  util.generatePie(path, data);
   	  util.generateBar(path, data);
   	  return "WhUserTypeCharts";
   	  
     }

}
