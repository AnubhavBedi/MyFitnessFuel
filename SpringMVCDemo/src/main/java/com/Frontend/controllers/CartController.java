package com.Frontend.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.onlineshop.dao.Cartdao;
import com.onlineshop.dao.Itemdao;
import com.onlineshop.dao.Productdao;
import com.onlineshop.dao.Userdao;
import com.onlineshop.models.Address;
import com.onlineshop.models.Cart;
import com.onlineshop.models.Item;


@Controller
public class CartController {
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	Cartdao cartDao;
	
	@Autowired
	Itemdao itemDao;
	
	@Autowired
	Productdao productDao;
	
	@Autowired
	Userdao userDao;
	
	@RequestMapping(value="/addToCart/{pid}",method=RequestMethod.GET)
	public String addToCart(@PathVariable("pid")int proId){
	
		
	System.out.println("I m into addToCart method");
	Principal principal = request.getUserPrincipal();
	String email=principal.getName();
	System.out.println("Email : "+email+" "+proId);
	
	Cart obj=cartDao.getCartByCustomer(email);
	if(obj==null){
		System.out.println("No Cart");
		
		Cart cartObj=new Cart();
		cartObj.setCustomerId(email);
		
		
		Item it=new Item();
		it.setCart(cartObj);
		it.setCustomerId(email);
		it.setPrice(productDao.getProductById(proId).getPrice());
		it.setQuantity(1);
		it.setProduct(productDao.getProductById(proId));
		
		List<Item> itemList=new ArrayList<Item>();
		itemList.add(it);
		
		cartObj.setItems(itemList);

		cartDao.addCart(cartObj);
		
	}
	else {
		System.out.println("Cart already present");
		
		Cart cartObj=cartDao.getCartByCustomer(email);
		Item itemObj=itemDao.getItemByProductIdAndCustomerId(proId, email);
		if(itemObj==null){
			System.out.println("Item not present in cart");
			Item items =new Item();
			items.setCart(cartObj);
			items.setCustomerId(email);
			items.setPrice(productDao.getProductById(proId).getPrice());
			items.setQuantity(1);
			items.setProduct(productDao.getProductById(proId));
			itemDao.addItem(items);
			
		}
		else {}
		
	}
	
	return "redirect:viewCart?uEmail="+email;
	
}
	@RequestMapping(value="/addToCart/viewCart",method=RequestMethod.GET)
	 public ModelAndView addcart (@RequestParam("uEmail")String uEmail){
		
		ModelAndView mv=new ModelAndView("ViewCart");
		Cart cartObj=cartDao.getCartByCustomer(uEmail);
		System.out.println("Cart Obj : "+cartObj );
		
		List<Item> items=itemDao.getItemsListByCart(cartObj.getCartId());
		for(Item item:items){
			System.out.println(item);
		}
		
		mv.addObject("itemsList",items);
		return mv;
		
		
		
	}
	
	@RequestMapping(value="/addToCart/deleteItem/{itemId}",method=RequestMethod.GET)
	public ModelAndView deleteItemFromCart(@PathVariable("itemId")int itemId){
		
		Principal p=request.getUserPrincipal();
		String email=p.getName();
		Cart cartObj=cartDao.getCartByCustomer(email);
		int cartId=cartObj.getCartId();
		
		itemDao.deleteItem(itemId);
		
		List<Item> items=itemDao.getItemsListByCart(cartObj.getCartId());
		ModelAndView mv=new ModelAndView("ViewCart");
		mv.addObject("itemsList",items);
		return mv;
	
	}
	@RequestMapping(value="/addToCart/increaseQuantity/{itemId}",method=RequestMethod.GET)
	public ModelAndView increaseQuantity(@PathVariable("itemId")int itemId){
		
		Principal p=request.getUserPrincipal();
		String email=p.getName();
		Cart cartObj=cartDao.getCartByCustomer(email);
		int cartId=cartObj.getCartId();
		
		itemDao.increaseQuantity(itemId);
		
		List<Item> items=itemDao.getItemsListByCart(cartObj.getCartId());
		ModelAndView mv=new ModelAndView("ViewCart");
		mv.addObject("itemsList",items);
		return mv;
	}
	
	@RequestMapping(value="/addToCart/decreaseQuantity/{itemId}",method=RequestMethod.GET)
	public ModelAndView decreaseQuantity(@PathVariable("itemId")int itemId){
		
		Principal p=request.getUserPrincipal();
		String email=p.getName();
		Cart cartObj=cartDao.getCartByCustomer(email);
		int cartId=cartObj.getCartId();
		
		itemDao.decreaseQuantity(itemId);
		
		List<Item> items=itemDao.getItemsListByCart(cartObj.getCartId());
		ModelAndView mv=new ModelAndView("ViewCart");
		mv.addObject("itemsList",items);
		return mv;
	}
	
	
	
	
	@RequestMapping(value="/addToCart/placeOrder",method=RequestMethod.GET)	
	public ModelAndView placeOrder(){
		
		String email=request.getUserPrincipal().getName();
		
		List<Address> addressList=userDao.getAllAddressForUser(email);
		if(addressList.size()==0){
			ModelAndView mv=new ModelAndView("Address");
			mv.addObject("addressObj",new Address());
			return mv;
		}
		else {
			ModelAndView mv=new ModelAndView("ViewAddress");
			mv.addObject("addressList",addressList);
			return mv;
		}
		
	}
}
