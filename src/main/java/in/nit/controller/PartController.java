package in.nit.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.Part;
import in.nit.service.IOrderMethodService;
import in.nit.service.IPartService;
import in.nit.service.IUomService;
import in.nit.util.CommonUtil;
import in.nit.view.PartExcelView;
import in.nit.view.PartPdfView;

@Controller
@RequestMapping("/part")
public class PartController {
	@Autowired
	private IPartService service;
	@Autowired
	private IUomService uomService;
	@Autowired
	private IOrderMethodService orderMethodService;
	private void commonUi(Model model) {
		List<Object[]> list=uomService.getUomIdAndModel();
		//convert list to map
		Map<Integer, String> map=CommonUtil.convert(list);
		model.addAttribute("uomMap", map);		
		
		List<Object[]> omSaleList=orderMethodService.getOrderMethodIdAndCode("sale");
		//convert list to map
		Map<Integer, String> omSaleMap=CommonUtil.convert(omSaleList);
		model.addAttribute("omSaleMap", omSaleMap);
	}
	@RequestMapping("/register")
	public String showRegPage(Model model) {
		model.addAttribute("part",new Part());
		commonUi(model);
		return "PartRegister";
	}
	
	@RequestMapping(value = "/save",method =RequestMethod.POST)
	public String savePart(@ModelAttribute Part part,Model model) {
		Integer id=0;
		String msg=null;
		model.addAttribute("part",new Part());
	    id=service.savePart(part);
		if(id==0)
			msg="Part is not saved";
		else
			msg="Part '"+id+"' is saved";
		model.addAttribute("message", msg);
		commonUi(model);
		return "PartRegister";		
	}
	@RequestMapping("/all")
	public String getAllPart(Model model) {
		List<Part> list=service.getAllPart();
		model.addAttribute("list", list);
		return "PartData";
		
	}
	@RequestMapping("/delete")
	public String deletePart(@RequestParam("sid")Integer id,Model model) {
		String msg=null;
		service.deletePart(id);
		msg="Part '"+id+"' is deleted";
		model.addAttribute("message", msg);
		List<Part> list=service.getAllPart();
		model.addAttribute("list", list);
	    return "PartData";
	}
	@RequestMapping("/edit")
	public String getOnePart(@RequestParam("sid")Integer id,Model model) {
		Part ob=service.getOnePart(id);
		model.addAttribute("part", ob);
		commonUi(model);
		return "PartEdit";
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePart(@ModelAttribute Part part,Model model) {
		service.updatePart(part);
		String msg="Part '"+part.getPartId()+"' is updated";
		model.addAttribute("message", msg);
		List<Part> list=service.getAllPart();
		model.addAttribute("list", list);
		return "PartData";
	}
	@RequestMapping("/view")
	public String showOnePart(@RequestParam("sid")Integer id,Model model) {
		Part p=service.getOnePart(id);
		model.addAttribute("ob", p);
		commonUi(model);
		return "PartView";
	}
	  @RequestMapping("/excel")
      public ModelAndView showExcel(@RequestParam(value = "id",required = false)Integer id) {
    	  ModelAndView mav=new ModelAndView();
    	  //set view to mav
    	  mav.setView(new PartExcelView());
    	  if(id==null) {
    		  //fetching data from database
    		  List<Part> list=service.getAllPart();
    		  //set model to mav
    		  mav.addObject("list",list);
    	  }else {
    		  //get One row
    		  Part p=service.getOnePart(id);
    		  //set model to mav
    		  mav.addObject("list", Arrays.asList(p));
    	  }
    	  return mav;
      }
	   @RequestMapping("/pdf")
	      public ModelAndView showPdf(@RequestParam(value = "id",required = false)Integer id ) {
	    	  ModelAndView mav=new ModelAndView();
	    	  //set view to mav
	    	  mav.setView(new PartPdfView());
	    	  if(id==null) {
	    		  //fetching data from database
	    		  List<Part> list=service.getAllPart();
	    		  //set model to mav
	    		  mav.addObject("list",list);
	    	  }else {
	    		  //get One row
	    		  Part p=service.getOnePart(id);
	    		  //set model to mav
	    		  mav.addObject("list", Arrays.asList(p));
	    	  }
	    	  return mav;
	      }
}
