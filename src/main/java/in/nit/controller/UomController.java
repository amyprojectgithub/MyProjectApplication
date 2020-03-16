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
import in.nit.model.Uom;
import in.nit.service.IUomService;
import in.nit.util.UomUtil;
import in.nit.view.ShipmentTypeExcelView;
import in.nit.view.ShipmentTypePdfView;
import in.nit.view.UomExcelView;
import in.nit.view.UomPdfView;

@Controller
@RequestMapping("/uom")
public class UomController {
	@Autowired
	private IUomService service;
	@Autowired
	private UomUtil util;
	@Autowired
	private ServletContext context;
	@RequestMapping("/register")
	public String showRegPage(Model model) {
		model.addAttribute("uom",new Uom());
		return "UomRegister";
	}
	@RequestMapping(value = "/save",method =RequestMethod.POST)
	public String saveUom(@ModelAttribute Uom unit,Model model) {
		Integer id=0;
		String msg=null;
		model.addAttribute("uom",new Uom());
	    id=service.saveUom(unit);
		if(id==0)
			msg="Uom is not saved";
		else
			msg="Uom '"+id+"' is saved";
		model.addAttribute("message", msg);
		return "UomRegister";		
	}
	@RequestMapping("/all")
	public String getAllUom(Model model) {
		List<Uom> list=service.getAllUom();
		model.addAttribute("list", list);
		return "UomData";
		
	}
	@RequestMapping("/delete")
	public String deleteUom(@RequestParam("sid")Integer id,Model model) {
		String msg=null;
		service.deleteUom(id);
		msg="Uom '"+id+"' is deleted";
		model.addAttribute("message", msg);
		List<Uom> list=service.getAllUom();
		model.addAttribute("list", list);
	    return "UomData";
	}
	@RequestMapping("/edit")
	public String getOneUom(@RequestParam("sid")Integer id,Model model) {
		Uom ob=service.getOneUom(id);
		model.addAttribute("uom", ob);
		return "UomEdit";
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUom(@ModelAttribute Uom uom,Model model) {
		service.updateUom(uom);
		String msg="Uom '"+uom.getUomId()+"' is updated";
		model.addAttribute("message", msg);
		List<Uom> list=service.getAllUom();
		model.addAttribute("list", list);
		return "UomData";
	}
	@RequestMapping("/view")
	public String showOneUom(@RequestParam("sid")Integer id,Model model) {
		Uom u=service.getOneUom(id);
		model.addAttribute("ob", u);
		return "UomView";
	}
	  @RequestMapping("/excel")
      public ModelAndView showExcel(@RequestParam(value = "id",required = false)Integer id) {
    	  ModelAndView mav=new ModelAndView();
    	  //set view to mav
    	  mav.setView(new UomExcelView());
    	  if(id==null) {
    		  //fetching data from database
    		  List<Uom> list=service.getAllUom();
    		  //set model to mav
    		  mav.addObject("list",list);
    	  }else {
    		  //get One row
    		  Uom u=service.getOneUom(id);
    		  //set model to mav
    		  mav.addObject("list", Arrays.asList(u));
    	  }
    	  return mav;
      }
	   @RequestMapping("/pdf")
	      public ModelAndView shoePdf(@RequestParam(value = "id",required = false)Integer id ) {
	    	  ModelAndView mav=new ModelAndView();
	    	  //set view to mav
	    	  mav.setView(new UomPdfView());
	    	  if(id==null) {
	    		  //fetching data from database
	    		  List<Uom> list=service.getAllUom();
	    		  //set model to mav
	    		  mav.addObject("list",list);
	    	  }else {
	    		  //get One row
	    		  Uom u=service.getOneUom(id);
	    		  //set model to mav
	    		  mav.addObject("list", Arrays.asList(u));
	    	  }
	    	  return mav;
	      }
	   @RequestMapping("/charts")
	      public String showCharts() {
	    	  //get modes and mode-counts
	    	  List<Object[]> data=service.getUomTypeCount();
	    	  //get RealPath
	    	  String path=context.getRealPath("/");
	    	  //invoke the util methods
	    	  util.generatePie(path, data);
	    	  util.generateBar(path, data);
	    	  return "UomCharts";
	    	  
	      }

}
