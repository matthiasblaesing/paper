package com.netsitech.paper.gdpicture.enums;

/**
 * Enum di comodo per gestire i valori della GdPicture
 */
public enum InterpolationMode {

	Invalid(-1), //
	Default(0), //
	Low(1), //
	High(2), //
	Bilinear(3), //
	Bicubic(4), //
	NearestNeighbor(5), //
	HighQualityBilinear(6), //
	HighQualityBicubic(7);

	private final int value;

	private InterpolationMode(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
