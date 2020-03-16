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

import in.nit.model.OrderMethod;
import in.nit.model.ShipmentType;
import in.nit.service.IOrderMethodService;
import in.nit.util.OrderMethodUtil;
import in.nit.view.OrderMethodExcelView;
import in.nit.view.OrderMethodPdfView;
import in.nit.view.ShipmentTypeExcelView;
import in.nit.view.ShipmentTypePdfView;
@Controller
@RequestMapping("/order")
public class OrderMethodController {
	@Autowired
	private IOrderMethodService service;
	@Autowired
	private OrderMethodUtil util;
	@Autowired
	private ServletContext context;
	
	@RequestMapping("/register")
	public String ShowRegPage(Model model) {
		//form backing object
		model.addAttribute("orderMethod", new OrderMethod());
		return "OrderMethodRegister";
	}
	 @RequestMapping(value ="/save",method = RequestMethod.POST )
		public String saveOrderMethod(@ModelAttribute OrderMethod orderMethod,Model model) {
			Integer id=null;
			String msg=null;
			model.addAttribute("orderMethod", new OrderMethod());
			id=service.saveOrderMethod(orderMethod);
			model.addAttribute("orderMethod", new OrderMethod());
			if(id==0)
				msg="OrderMethod IS NOT SAVED";
			else
				msg="OrderMethod '"+id+"' IS SAVED";
			model.addAttribute("message",msg);
			return "OrderMethodRegister";
		}
	      @RequestMapping("/all")
	      public String getAllOrderMethod(Model model) {
	    	  List<OrderMethod> list=service.getAllOrderMethod();
	    	  model.addAttribute("list", list);
	    	  return "OrderMethodData";
	      }
	      @RequestMapping("/delete")
	      public String deleteOrerMethod(@RequestParam("id")Integer id,Model model) {
	    	  service.deleteOrderMethod(id);
	    	  String msg="OrderMethod '"+id+"' Deleted";
	    	  model.addAttribute("message", msg);
	    	  //fetch data from db
	    	  List<OrderMethod> list=service.getAllOrderMethod();
	    	  model.addAttribute("list", list);
	    	  return "OrderMethodData";
	      }
	      @RequestMapping("/edit")
	      public String getOneOrderMethod(@RequestParam("id")Integer id,Model model) {
	    	  OrderMethod om=service.getOneOrderMethod(id);
	    	  model.addAttribute("orderMethod", om);
	    	  return "OrderMethodEdit";
	      }
	      @RequestMapping(value = "/update" ,method = RequestMethod.POST)
	      public String updateOrderMethod(@ModelAttribute OrderMethod orderMethod,Model model) {
	    	  service.updateOrderMethod(orderMethod);;
	    	  String msg="OrderMethod '"+orderMethod.getOrderMId()+"' is updated";
	    	  model.addAttribute("message",msg);
	    	  List<OrderMethod> list=service.getAllOrderMethod();
	    	  model.addAttribute("list", list);
	    	  return "OrderMethodData";
	      }
	      @RequestMapping("/view")
	      public String showOneOrder(@RequestParam("id")Integer id,Model model) {
	    	  OrderMethod om=service.getOneOrderMethod(id);
	    	  model.addAttribute("ob", om);
	    	  return "OrderMethodView";
	      }
	      @RequestMapping("/excel")
	      public ModelAndView showExcel(@RequestParam(value = "id",required = false)Integer id) {
	    	  ModelAndView mav=new ModelAndView();
	    	  //set view to mav
	    	  mav.setView(new OrderMethodExcelView());
	    	  if(id==null) {
	    		  //fetching data from database
	    		  List<OrderMethod> list=service.getAllOrderMethod();
	    		  //set model to mav
	    		  mav.addObject("list",list);
	    	  }else {
	    		  //get One row
	    		  OrderMethod om=service.getOneOrderMethod(id);
	    		  //set model to mav
	    		  mav.addObject("list", Arrays.asList(om));
	    	  }
	    	  return mav;
	      }
	      @RequestMapping("/pdf")
	      public ModelAndView showPdf(@RequestParam(value = "id",required = false)Integer id ) {
	    	  ModelAndView mav=new ModelAndView();
	    	  //set view to mav
	    	  mav.setView(new OrderMethodPdfView());
	    	  if(id==null) {
	    		  //fetching data from database
	    		  List<OrderMethod> list=service.getAllOrderMethod();
	    		  //set model to mav
	    		  mav.addObject("list",list);
	    	  }else {
	    		  //get One row
	    		  OrderMethod om=service.getOneOrderMethod(id);
	    		  //set model to mav
	    		  mav.addObject("list", Arrays.asList(om));
	    	  }
	    	  return mav;
	      }
	      @RequestMapping("/charts")
	      public String showCharts() {
	    	  //get modes and mode-counts
	    	  List<Object[]> data=service.getOrderMethodTypeCount();
	    	  //get RealPath
	    	  String path=context.getRealPath("/");
	    	  //invoke the util methods
	    	  util.generatePie(path, data);
	    	  util.generateBar(path, data);
	    	  return "OrderMethodCharts";
	    	  
	      }

}
