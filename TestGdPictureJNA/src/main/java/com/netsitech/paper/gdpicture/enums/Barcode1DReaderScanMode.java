package com.netsitech.paper.gdpicture.enums;

/**
 * Enum di comodo per gestire i valori della GdPicture
 */
public enum Barcode1DReaderScanMode {

	BestQuality(1), //
	BestSpeed(0);

	private int value;

	private Barcode1DReaderScanMode(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
