package com.banhang.model;

import java.util.ArrayList;
import java.util.List;

public class SetGioHang {

	private int orderNum;

	private TaiKhoan customerInfo;

	private final List<GioHang> cartLines = new ArrayList<GioHang>();

	public SetGioHang() {

	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public TaiKhoan getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(TaiKhoan customerInfo) {
		this.customerInfo = customerInfo;
	}

	public List<GioHang> getCartLines() {
		return this.cartLines;
	}

	private GioHang findLineByCode(String code) {
		for (GioHang line : this.cartLines) {
			if (line.getProductInfo().getId().equals(code)) {
				return line;
			}
		}
		return null;
	}

	public void addProduct(HangHoa productInfo, int quantity) {
		GioHang line = this.findLineByCode(productInfo.getId());

		if (line == null) {
			line = new GioHang();
			line.setQuantity(0);
			line.setProductInfo(productInfo);
			this.cartLines.add(line);
		}
		int newQuantity = line.getQuantity() + quantity;
		if (newQuantity <= 0) {
			this.cartLines.remove(line);
		} else {
			line.setQuantity(newQuantity);
		}
	}

	public void validate() {

	}

	public void updateProduct(String code, int quantity) {
		GioHang line = this.findLineByCode(code);

		if (line != null) {
			if (quantity <= 0) {
				this.cartLines.remove(line);
			} else {
				line.setQuantity(quantity);
			}
		}
	}

	public void removeProduct(HangHoa productInfo) {
		GioHang line = this.findLineByCode(productInfo.getId());
		if (line != null) {
			this.cartLines.remove(line);
		}
	}

	public boolean isEmpty() {
		return this.cartLines.isEmpty();
	}

	
	public int getQuantityTotal() {
		int quantity = 0;
		for (GioHang line : this.cartLines) {
			quantity += line.getQuantity();
		}
		return quantity;
	}

	public double getAmountTotal() {
		double total = 0;
		for (GioHang line : this.cartLines) {
			total += line.getAmount();
		}
		return total;
	}

	public void updateQuantity(SetGioHang cartForm) {
		if (cartForm != null) {
			List<GioHang> lines = cartForm.getCartLines();
			for (GioHang line : lines) {
				this.updateProduct(line.getProductInfo().getId(), line.getQuantity());
			}
		}

	}

}
