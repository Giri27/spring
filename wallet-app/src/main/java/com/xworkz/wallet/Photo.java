package com.xworkz.wallet;

public class Photo {
	
	private String photoType;
	private String photoSize;
	private String photoPrice;
	
	public Photo() {
		System.out.println(this.getClass().getSimpleName() +" Bean Created");
	}

	public String getPhotoType() {
		return photoType;
	}

	public void setPhotoType(String photoType) {
		this.photoType = photoType;
	}

	public String getPhotoSize() {
		return photoSize;
	}

	public void setPhotoSize(String photoSize) {
		this.photoSize = photoSize;
	}

	public String getPhotoPrice() {
		return photoPrice;
	}

	public void setPhotoPrice(String photoPrice) {
		this.photoPrice = photoPrice;
	}

	@Override
	public String toString() {
		return "Photo [photoType=" + photoType + ", photoSize=" + photoSize + ", photoPrice=" + photoPrice + "]";
	}
	
}
