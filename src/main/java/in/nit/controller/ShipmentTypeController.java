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
import in.nit.service.IShipmentTypeService;
import in.nit.util.ShipmentTypeUtil;
import in.nit.view.ShipmentTypeExcelView;
import in.nit.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {
	@Autowired
	private IShipmentTypeService service;
	@Autowired
	private ShipmentTypeUtil util;
	@Autowired
	private ServletContext context;

	@RequestMapping("/register")
	public String showRegPage(Model model) {
		model.addAttribute("shipmentType", new ShipmentType());
		return "ShipmentTypeRegister";
	}
      @RequestMapping(value ="/save",method = RequestMethod.POST )
	public String saveShipment(@ModelAttribute ShipmentType shipmentType,Model model) {
		Integer id=null;
		String msg=null;
		model.addAttribute("shipmentType", new ShipmentType());
		id=service.saveShipmentType(shipmentType);
		model.addAttribute("shipmentType", new ShipmentType());
		if(id==0)
			msg="SHIPMENT-TYPE IS NOT SAVED";
		else
			msg="SHIPMENT-TYPE '"+id+"' IS SAVED";
		model.addAttribute("message",msg);
		return "ShipmentTypeRegister";
	}
      @RequestMapping("/all")
      public String getAllShipment(Model model) {
    	  List<ShipmentType> list=service.getAllShipment();
    	  model.addAttribute("list", list);
    	  return "ShipmentTypeData";
      }
      @RequestMapping("/delete")
      public String deleteShipmentType(@RequestParam("sid")Integer id,Model model) {
    	  service.deleteShipmentType(id);
    	  String msg="ShipmentType '"+id+"' Deleted";
    	  model.addAttribute("message", msg);
    	  //fetch data from db
    	  List<ShipmentType> list=service.getAllShipment();
    	  model.addAttribute("list", list);
    	  return "ShipmentTypeData";
      }
      @RequestMapping("/edit")
      public String getOneShipmentType(@RequestParam("sid")Integer id,Model model) {
    	  ShipmentType st=service.getOneShipmentType(id);
    	  model.addAttribute("shipmentType", st);
    	  return "ShipmentTypeEdit";
      }
      @RequestMapping(value = "/update" ,method = RequestMethod.POST)
      public String updateShipmentType(@ModelAttribute ShipmentType shipmentType,Model model) {
    	  service.updateShipmentType(shipmentType);
    	  String msg="ShimentType '"+shipmentType.getShipId()+"' is updated";
    	  model.addAttribute("message",msg);
    	  List<ShipmentType> list=service.getAllShipment();
    	  model.addAttribute("list", list);
    	  return "ShipmentTypeData";
      }
      @RequestMapping("/view")
      public String showOneshipment(@RequestParam("sid")Integer id,Model model) {
    	  ShipmentType st=service.getOneShipmentType(id);
    	  model.addAttribute("ob", st);
    	  return "ShipmentTypeView";
      }
      @RequestMapping("/excel")
      public ModelAndView showExcel(@RequestParam(value = "sid",required = false)Integer id) {
    	  ModelAndView mav=new ModelAndView();
    	  //set view to mav
    	  mav.setView(new ShipmentTypeExcelView());
    	  if(id==null) {
    		  //fetching data from database
    		  List<ShipmentType> list=service.getAllShipment();
    		  //set model to mav
    		  mav.addObject("list",list);
    	  }else {
    		  //get One row
    		  ShipmentType st=service.getOneShipmentType(id);
    		  //set model to mav
    		  mav.addObject("list", Arrays.asList(st));
    	  }
    	  return mav;
      }
      @RequestMapping("/pdf")
      public ModelAndView shoePdf(@RequestParam(value = "sid",required = false)Integer id ) {
    	  ModelAndView mav=new ModelAndView();
    	  //set view to mav
    	  mav.setView(new ShipmentTypePdfView());
    	  if(id==null) {
    		  //fetching data from database
    		  List<ShipmentType> list=service.getAllShipment();
    		  //set model to mav
    		  mav.addObject("list",list);
    	  }else {
    		  //get One row
    		  ShipmentType st=service.getOneShipmentType(id);
    		  //set model to mav
    		  mav.addObject("list", Arrays.asList(st));
    	  }
    	  return mav;
      }
      @RequestMapping("/charts")
      public String showCharts() {
    	  //get modes and mode-counts
    	  List<Object[]> data=service.getShipmentModeCount();
    	  //get RealPath
    	  String path=context.getRealPath("/");
    	  //invoke the util methods
    	  util.generatePie(path, data);
    	  util.generateBar(path, data);
    	  return "ShipmentTypeCharts";
    	  
      }
}
