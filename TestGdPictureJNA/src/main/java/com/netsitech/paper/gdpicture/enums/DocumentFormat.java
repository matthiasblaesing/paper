package com.netsitech.paper.gdpicture.enums;

/**
 * Enum di comodo per gestire i valori della GdPicture
 */
public enum DocumentFormat {

	DocumentFormatBMP(2), //
	DocumentFormatCUT(28), //
	DocumentFormatDDS(31), //
	DocumentFormatDICOM(41), //
	DocumentFormatEMF(10), //
	DocumentFormatEXIF(9), //
	DocumentFormatEXR(34), //
	DocumentFormatFAXG3(8), //
	DocumentFormatGIF(5), //
	DocumentFormatHDR(32), //
	DocumentFormatICO(1), //
	DocumentFormatIFF(14), //
	DocumentFormatJ2K(35), //
	DocumentFormatJBIG(37), //
	DocumentFormatJBIG2(100), //
	DocumentFormatJNG(12), //
	DocumentFormatJP2(36), //
	DocumentFormatJPEG(4), //
	DocumentFormatKOALA(13), //
	DocumentFormatMemoryBMP(500), //
	DocumentFormatMNG(15), //
	DocumentFormatPBM(18), //
	DocumentFormatPBMRAW(19), //
	DocumentFormatPCD(16), //
	DocumentFormatPCX(17), //
	DocumentFormatPDF(1000), //
	DocumentFormatPFM(20), //
	DocumentFormatPGM(21), //
	DocumentFormatPGMRAW(22), //
	DocumentFormatPICT(38), //
	DocumentFormatPNG(6), //
	DocumentFormatPPM(23), //
	DocumentFormatPPMRAW(24), //
	DocumentFormatPSD(27), //
	DocumentFormatRAS(25), //
	DocumentFormatRAW(39), //
	DocumentFormatSGI(33), //
	DocumentFormatSVG(1001), //
	DocumentFormatTARGA(26), //
	DocumentFormatTIFF(7), //
	DocumentFormatTXT(1002), //
	DocumentFormatUNKNOWN(0), //
	DocumentFormatWBMP(3), //
	DocumentFormatWEBP(40), //
	DocumentFormatWMF(11), //
	DocumentFormatXBM(29), //
	DocumentFormatXPM(30); //

	private final int value;

	private DocumentFormat(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
