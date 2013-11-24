package com.cebul.jez.useful;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.cebul.jez.entity.Produkty;

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart implements Serializable
{
	private List<Produkty> items;
	
	public ShoppingCart()
	{
		this.items = new ArrayList<Produkty>();
	}
	
	public void addItem(Produkty i)
	{
		items.add(i);
	}
	public Produkty removeItem(int index)
	{
		return items.remove(index);
	}
	public List<Produkty> getItems() {
		return items;
	}

	public void setItems(List<Produkty> items) {
		this.items = items;
	}
	
	
}
