package com.web_services.instant_pot.dal.purchase;
import java.util.HashSet;


import java.util.HashSet;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.web_services.instant_pot.domain.customer.Customer;
import com.web_services.instant_pot.domain.partner.Partner;
import com.web_services.instant_pot.domain.product.Product;
import com.web_services.instant_pot.domain.purchase.Purchase; 

public class PurchaseDAL {
	
	public Purchase getPurchaseByID(long id) {
		Purchase purchase = new Purchase();
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    purchase = session.get(Purchase.class, id);
	    
		session.close();
		return purchase;
	}

	
	public Purchase newPurchase(Long id, Customer purchaseOwner, String purchaseDetail, String purchaseStatus,String purchasePayment) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
		Purchase purchase = new Purchase(id, purchaseOwner, purchaseDetail, purchaseStatus, purchasePayment);
		
		 
	    Transaction tx = session.beginTransaction();
	    session.save(purchase); 
	    tx.commit();
	    session.close(); 
		
	    return purchase;
	}
	

	
	public Purchase updatePurchaseDetail(Long id, String detail) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Purchase purchase = session.get(Purchase.class, id);
	    if (purchase != null) {
	    	purchase.setPurchaseDetail(detail);
	    	Transaction tx = session.beginTransaction();
	    	session.save(purchase);
		    tx.commit();
	    } 
	    session.close();
	    
	    return purchase;
	}
		
	
	
	public Purchase updatePurchaseStatus(Long id, String status) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Purchase purchase = session.get(Purchase.class, id);
	    if (purchase != null) {
	    	purchase.setPurchaseDetail(status);
	    	Transaction tx = session.beginTransaction();
	    	session.save(purchase);
		    tx.commit();
	    } 
	    session.close();
	    
	    return purchase;
	}



	


}
