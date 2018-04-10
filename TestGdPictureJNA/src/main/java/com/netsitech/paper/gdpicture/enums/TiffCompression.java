package com.netsitech.paper.gdpicture.enums;

/**
 * Enum di comodo per gestire i valori della GdPicture
 */
public enum TiffCompression {

	TiffCompressionADOBEDEFLATE(8), // Deflate compression,as recognized by Adobe
	TiffCompressionAUTO(65536), // Uses CCITT4 compression for bitonal image and LZW for others. TiffCompressionAUTO allows to mix compression in a multipage tiff document
	TiffCompressionCCITT3(3), // CCITT Group 3 fax encoding
	TiffCompressionCCITT4(4), // CCITT Group 4 fax encoding
	TiffCompressionCCITTRLEW(32771), // #1 w/ word alignment
	TiffCompressionDEFLATE(32946), // Deflate compression
	TiffCompressionJPEG(7), // %JPEG DCT compression
	TiffCompressionLZW(5), // Lempel-Ziv and Welch
	TiffCompressionNEXT(32766), // NeXT 2-bit RLE
	TiffCompressionNONE(1), // No compression
	TiffCompressionOJPEG(6), // !6.0 JPEG
	TiffCompressionPACKBITS(32773), // Macintosh RLE
	TiffCompressionRLE(2), // CCITT modified Huffman RLE
	TiffCompressionTHUNDERSCAN(32809), // ThunderScan RLE
	TiffCompressionUnknown(0); // Unknown compression

	private final int value;

	private TiffCompression(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static TiffCompression valueOf(int value) {
		for (TiffCompression t : TiffCompression.values()) {
			if (t.getValue() == value) {
				return t;
			}
		}
		return null;
	}
}
