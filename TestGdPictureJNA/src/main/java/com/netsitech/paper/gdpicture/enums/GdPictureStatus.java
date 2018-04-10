package com.netsitech.paper.gdpicture.enums;

/**
 * Enum di comodo per mappare i valori della GdPicture Generata a partie dalla documentazione online
 */
public enum GdPictureStatus {

	Aborted(9, "Indicates that the method was aborted'"), //
	AccessDenied(12, "Indicates that a write operation is not allowed on the specified file'"), //
	BadTwainState(32, "Indicates that an error of state was raised by the TWAIN plugin'"), //
	Barcode1DReaderPluginNotLoaded(1100, "Can't load GdPicture.NET.9.barcode.1d.reader.dll'"), //
	Barcode1DReaderUnknownError(1101, "Unknown error reported from the 1D Barcode reader plugin'"), //
	BarcodeBarcodeLengthMustBe12(1019, "Data length invalid. (Length must be 12)'"), //
	BarcodeBarcodeLengthMustBe2(1023, "Invalid data length. (Length = 2 required)'"), //
	BarcodeBarcodeLengthMustBe5(1024, "Invalid data length. (Length = 5 required)'"), //
	BarcodeBarcodeLengthMustBe5or6or9or11(1018, "Invalid data length. (5, 6, 9, or 11 digits only)'"), //
	BarcodeBarcodeLengthMustBe8or12(1020, "Invalid data length. (8 or 12 numbers only)'"), //
	BarcodeBarcodeMustBinaryChar(1021, "Invalid Number System (only 0 and 1 are valid)'"), //
	BarcodeCanNotDetermineStart(1006, "Could not determine start character'"), //
	BarcodeCouldNotInsertStart(1009, "Could not insert start and code characters'"), //
	BarcodeDatamatrixEncoderInvalidVersion(1510, "The version provided to the DataMatrix encoder is invalid'"), //
	BarcodeDataMatrixReaderPluginNotLoaded(1200, "Can't load the DataMatrix reader dll'"), //
	BarcodeDataMatrixReaderUnknownError(1201, "Unknown error reported from the DataMatrix Barcode reader plugin'"), //
	BarcodeIllegalUPCA(1022, "Illegal UPC-A entered for conversion. Unable to convert'"), //
	BarcodeInvalidData(1011, "Invalid Data'"), //
	BarcodeInvalidDestinationSize(1012, "Destination not large enough to draw the barcode'"), //
	BarcodeInvalidLength(1001, "Data format invalid. (Invalid length)'"), //
	BarcodeInvalidManufacturerCode(1013, "Country assigning manufacturer code not found'"), //
	BarcodeInvalidStart(1002, "Data format invalid. (Invalid START character)'"), //
	BarcodeInvalidStop(1003, "Data format invalid. (Invalid STOP character)'"), //
	BarcodeLengthMustBe11or12(1026, "Data length invalid. (Length must be 11 or 12)'"), //
	BarcodeLengthMustBe12or13(1025, "Data length invalid. (Length must be 12 or 13)'"), //
	BarcodeLengthMustBe13or14(1004, "Data length invalid. (Length must be 13 or 14)'"), //
	BarcodeLengthMustBe7or8(1014, "Invalid data length. (7 or 8 numbers only)'"), //
	BarcodeLengthMustBeMultipleOf2(1015, "Data length invalid. Must be a multiple of 2'"), //
	BarcodeMustStartWith49(1017, "Invalid Country Code for JAN13 (49 required)'"), //
	BarcodeMustStartWith978orBadLength(1016, "Invalid input. Must start with 978 and be length must be 9, 10, 12, 13 characters'"), //
	BarcodeNoEncodingValueFound(1010, "Could not find encoding of a value in the formatted data'"), //
	BarcodeNoStartInCurrentCodeSet(1008, "No start character found in CurrentCodeSet'"), //
	BarcodeNotNumeric(1005, "Numeric data only'"), //
	BarcodePDF417EncoderInvalidVersion(1520, "The version provided to the PDF417 encoder is invalid'"), //
	BarcodePDF417EncoderNotByteData(1523, "The PDF417 encoder expected only byte data'"), //
	BarcodePDF417EncoderNotNumericData(1521, "The PDF417 encoder expected only numeric data'"), //
	BarcodePDF417EncoderNotTextData(1522, "The PDF417 encoder expected only alpha-numeric data'"), //
	BarcodePDF417ReaderPluginNotLoaded(1400, "Can't load GdPicture.NET.9.barcode.pdf417.reader.dll'"), //
	BarcodeQRCodeReaderPluginNotLoaded(1300, "Can't load the QR-Code reader dll'"), //
	BarcodeQrEncoderInvalidVersion(1500, "The version provided to the Qr-Code encoder is invalid'"), //
	BarcodeQrEncoderNot8BitData(1503, "The Qr-Code expected only byte data'"), //
	BarcodeQrEncoderNotAlphanumericData(1502, "The Qr-Code expected only alpha-numeric data'"), //
	BarcodeQrEncoderNotKanjiData(1504, "The Qr-Code expected only kanji data'"), //
	BarcodeQrEncoderNotNumericData(1501, "The Qr-Code expected only numeric data'"), //
	BarcodeUnknownStartType(1007, "Unknown start type in fixed type encoding'"), //
	CanNotCreateFile(41, "Indicates that the file passed as parameter to the method can not be created'"), //
	CertificateNotFound(903, "The certificate has not been found'"), //
	CertificateWrongFormat(901, "The provided certificate has wrong or unsupported format'"), //
	CertificateWrongPassword(900, "The password provided for the certificate in invalid'"), //
	CertificateWrongPrivateKey(902, "The provided certificate does not includes private key'"), //
	DocumentAnalyzerDllRequired(4000, "Can't load the GdPicture Document analyzer encoder library'"), //
	EncryptionSchemeNotSupported(2000, "The selected encryption scheme is not supported'"), //
	FileNotFound(10, "Indicates that the specified image file or metafile cannot be found'"), //
	FontFamilyNotFound(14, "Indicates that the specified font family cannot be found. Either the font family name is incorrect or the font family is not installed'"), //
	FontStyleNotFound(15, "Indicates that the specified style is not available for the specified font family'"), //
	GdiplusNotInitialized(18, "Indicates that the GDI+API is not in an initialized state. Should never appends'"), //
	GenericError(1, "Indicates that there was an error on the method call, which is identified as something other than those defined by the other elements of this enumeration'"), //
	InsufficientBuffer(5, "Indicates that a buffer specified as an argument in the API is not large enough to hold the data to be received'"), //
	InternetConnectError(101, "An error occurred during the Internet connexion'"), //
	InternetFtpGetFileError(300, "An error occurred downloading a file from the FTP server'"), //
	InternetFtpWriteFileError(301, "An error occurred writing a file to the FTP server'"), //
	InternetHttpInvalidFileLength(105, "The length of the file returned from the HTTP server is invalid or null'"), //
	InternetHttpOpenRequestError(102, "An error occurred during the HTTP open request'"), //
	InternetHttpQueryError(103, "An error occurred during the HTTP query'"), //
	InternetHttpSendRequestError(104, "An error occurred sending an HTTP request'"), //
	InternetHttpTransferError(106, "An error occurred during the HTTP transfer'"), //
	InternetHTTPWriteFileError(107, "An error occurred during the HTTP writing operation'"), //
	InternetOpenError(100, "Could not access to Internet'"), //
	InvalidBarCode(50, "Indicates that the barcode data passed as parameter to the method is invalid'"), //
	InvalidLicense(9999, "The license key provided doesn't include this feature'"), //
	InvalidParameter(2, "Indicates that one of the arguments passed to the method was not valid'"), //
	InvalidPDFHandle(63, "Indicates that the PDF handle provided is invalid or inexistant'"), //
	JBIG2PluginNotLoaded(3000, "Can't load the GdPicture JBIG2 encoder library'"), //
	NotImplemented(6, "Indicates that the method is not implemented'"), //
	NotIndexedPixelFormat(61, "Indicates that the method needs an image with an indexed pixel format'"), //
	NotTrueTypeFont(16, "Indicates that the font retrieved from an HDC or LOGFONT is not a TrueType font and cannot be used with GdPicture'"), //
	ObjectBusy(4, "Indicates that one of the arguments specified in the API is already in use in another thread'"), //
	OCRDictionaryNotFound(801, "The dictionary files needed by the GdPicture Tesseract plugin was not found on the specified path'"), //
	OCRTesseractDllRequired(800, "The GdPicture.NET.ocr.tesseract.dll library was needed or was not found on the computer'"), //
	OCRUnhandledException(802, "The GdPicture.NET.ocr.tesseract.dll raised an unhandled exception'"), //
	OK(0, "Indicates that the method was successful'"), //
	OutOfMemory(3, "Indicates that the operating system is out of memory and could not allocate memory to process the method call'"), //
	PdfBadPassword(503, "The password supplied to open the PDF was invalid'"), //
	PdfCanNotBeDecrypted(501, "The PDF can not be decrypted by GdPicture'"), //
	PdfCanNotOpenFile(504, "The PDF file can not be opened'"), //
	PdfDocumentMustBeUnencrypted(500, "The PDF must be unencrypted before performing this operation'"), //
	PdfErrorAddingImage(507, "The image has not been added to the PDF'"), //
	PdfGenericError(506, "Indicates that there was an error related to PDF manipulation, which is identified as something other than those defined by the other elements of this enumeration'"), //
	PdfInvalidContent(512, "An invalid PDF structure or content has been encountered'"), //
	PdfPasswordNeeded(502, "A password was required to open this PDF'"), //
	PdfRenderingPageError(505, "Indicates that GdPicture was not able to process the document'"), //
	PdfUnsupportedInPdfA(511, "The operation is not supported in PDF/A'"), //
	PrintingException(24, "An exception has been raised by the system during the printing process'"), //
	ProfileNotFound(21, "Indicates that the color profile required to save an image in CMYK format was not found'"), //
	PropertyNotFound(19, "Indicates that the specified property does not exist in the target'"), //
	PropertyNotSupported(20, "Indicates that the specified property is not supported by the format of the target, therefore, cannot be set'"), //
	TemplateNotFound(23, "The template was not found by the GdPicture ADR engine'"), //
	TwainError(30, "Indicates that an error was raised by the TWAIN plugin'"), //
	TwainInvalidTransferMode(36, "Indicates that the selected transfer mode is not supported by the current device'"), //
	TwainTransferCanceled(33, "Indicates that a transfer cancellation was raised by the TWAIN plugin'"), //
	TwainTransferError(34, "Indicates that an error of transfer was raised by the TWAIN plugin'"), //
	UnknownImageFormat(13, "Indicates that the specified image file format is not known'"), //
	UnsupportedGdiplusVersion(17, "Indicates that the version of GDI+ that is installed on the system is incompatible with the version needed by GdPicture'"), //
	UnsupportedImageFormat(22, "Indicates that the format of the image is not supported by the method'"), //
	UnsupportedPixelFormat(62, "Indicates that the method doesn't support the pixel format of the image'"), //
	ValueOverflow(11, "Indicates that the method performed an arithmetic operation that produced a numeric overflow'"), //
	WIAGenericError(20000, "WIA error. Use WiaGetLastError() functions for diagnosing the error'"), //
	Win32Error(7, "Indicates that the method generated a Microsoft Win32 error'"), //
	WrongGdTwainVersion(31, "Indicates that the GdPicture.NET.twain.client.dll version are invalid'"), //
	WrongState(8, "Indicates that the object is in an invalid state to satisfy the API call'"), //
	// errori custom
	UnsupportedJpgQuality(-10, "Il parametro relativo alla qualità del JPG è fuori dal range ammesso");

	private final int value;
	private final String description;

	GdPictureStatus(int value, String description) {
		this.value = value;
		this.description = description;
	}

	public int getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}

	public static GdPictureStatus translate(int value) {
		for (GdPictureStatus status : GdPictureStatus.values()) {
			if (value == status.getValue()) {
				return status;
			}
		}
		return null;
	}

	public static String getDescription(int value) {
		GdPictureStatus status = GdPictureStatus.translate(value);
		return status == null ? ("Unknown GdPicture status " + value) : status.description;
	}

	public static boolean isOk(int value) {
		return OK.getValue() == value;
	}

	public static boolean isOk(GdPictureStatus status) {
		return OK == status;
	}

}
