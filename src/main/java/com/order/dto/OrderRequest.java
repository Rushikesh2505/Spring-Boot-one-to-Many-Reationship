package com.order.dto;

import com.order.entity.Orders;

public class OrderRequest {
	private Orders orders;

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "OrderRequest [orders=" + orders + "]";
	}

	
}
