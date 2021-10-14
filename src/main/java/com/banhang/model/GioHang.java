package com.banhang.model;


public class GioHang {
	private HangHoa productInfo;
	private int quantity;

	public GioHang() {
		this.quantity = 0;
	}

	public HangHoa getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(HangHoa productInfo) {
		this.productInfo = productInfo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getAmount() {
		return this.productInfo.getGia() * this.quantity;
	}
}
