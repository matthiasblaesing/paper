package com.netsitech.paper.gdpicture.enums;

/**
 * Enum di comodo per gestire i valori della GdPicture
 */
public enum Barcode1DReaderType {

	Barcode1DReaderADD2(1048576), //
	Barcode1DReaderADD5(524288), //
	Barcode1DReaderBcdMatrix(128), //
	Barcode1DReaderCode128(4096), //
	Barcode1DReaderCode39(32), //
	Barcode1DReaderCODE93(16384), //
	Barcode1DReaderCodeabar(64), //
	Barcode1DReaderDataLogic2of5(256), //
	Barcode1DReaderEAN13(32768), //
	Barcode1DReaderEAN8(131072), //
	Barcode1DReaderIata2of5(8), //
	Barcode1DReaderIndustrial2of5(1), //
	Barcode1DReaderInterleaved2of5(4), //
	Barcode1DReaderInverted2of5(2), //
	Barcode1DReaderMatrix2of5(16), //
	Barcode1DReaderNone(0), //
	Barcode1DReaderUPCA(65536), //
	Barcode1DReaderUPCE(262144);

	private int value;

	private Barcode1DReaderType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
