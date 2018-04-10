package com.netsitech.paper.gdpicture.enums;

/**
 * Enum di comodo per gestire i valori della GdPicture
 */
public enum BarcodeDataMatrixReaderScanMode {

	BestQuality(1), //
	BestSpeed(0);

	private int value;

	private BarcodeDataMatrixReaderScanMode(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
