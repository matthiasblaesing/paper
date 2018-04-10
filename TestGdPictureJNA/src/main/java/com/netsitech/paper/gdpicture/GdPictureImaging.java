package com.netsitech.paper.gdpicture;

import java.io.File;

import com.netsitech.paper.gdpicture.enums.DocumentFormat;
import com.netsitech.paper.gdpicture.enums.GdPictureStatus;
import com.sun.jna.platform.win32.OaIdl.SAFEARRAY;
import com.sun.jna.platform.win32.OaIdlUtil;
import com.sun.jna.platform.win32.Variant;
import com.sun.jna.platform.win32.Variant.VARIANT;
import com.sun.jna.platform.win32.WTypes;
import com.sun.jna.platform.win32.COM.COMLateBindingObject;
import com.sun.jna.ptr.IntByReference;

public class GdPictureImaging extends COMLateBindingObject {

	private VARIANT imageId = null;

	public GdPictureImaging(String version) {
		super("GdPicture" + version + ".GdPictureImaging", false);
	}

	public VARIANT getImageId() {
		return imageId;
	}

	public GdPictureStatus getStatus() {
		VARIANT status = this.invoke("GetStat");
		return GdPictureStatus.translate(status.intValue());
	}

	private void checkStatus(VARIANT status) throws GdPictureException {
		checkStatus(status.intValue(), null);
	}

	private void checkStatus(VARIANT status, String userMessage) throws GdPictureException {
		checkStatus(status.intValue(), userMessage);
	}

	private void checkStatus(int status, String userMessage) throws GdPictureException {
		if (!GdPictureStatus.isOk(status)) {
			throw new GdPictureException(status, userMessage);
		}
	}

	private void checkStatus(GdPictureStatus status) throws GdPictureException {
		checkStatus(status, null);
	}

	private void checkStatus(GdPictureStatus status, String userMessage) throws GdPictureException {
		if (!GdPictureStatus.isOk(status)) {
			throw new GdPictureException(status, userMessage);
		}
	}

	public void loadImage(byte[] image) throws GdPictureException {
		loadImage(image, null);
	}

	public void loadImage(byte[] image, DocumentFormat format) throws GdPictureException {
		try (SAFEARRAY safeArray = SAFEARRAY.createSafeArray(new WTypes.VARTYPE(Variant.VT_UI1), image.length)) {
			for (int i = 0; i < image.length; i++) {
				safeArray.putElement(image[i], i);
			}
			if (format != null) {
				imageId = this.invoke("CreateGdPictureImageFromByteArray", new VARIANT(safeArray), new VARIANT(format.getValue()));
			} else {
				imageId = this.invoke("CreateGdPictureImageFromByteArray", new VARIANT(safeArray));
			}
			if (imageId.intValue() == 0) {
				throw new GdPictureException(getStatus());
			}
		}
	}

	public void loadImage(File image) throws GdPictureException {
		imageId = this.invoke("CreateGdPictureImageFromFile", new VARIANT(image.getAbsolutePath()));
		if (imageId.intValue() == 0) {
			throw new GdPictureException(getStatus());
		}
	}

	// public byte[] getAsTIFF(TiffCompression compression) throws GdPictureException {
	// return getAs(DocumentFormat.DocumentFormatTIFF, compression.getValue());
	// }
	//
	// public byte[] getAsTIFF() throws GdPictureException {
	// return getAsTIFF(TiffCompression.TiffCompressionNONE);
	// }
	//
	// /**
	// * Return image as standard FAX CCITT Group 4 image
	// */
	// public byte[] getAsTIFF_G4() throws GdPictureException {
	// return getAsTIFF(TiffCompression.TiffCompressionCCITT4);
	// }

	public byte[] getAs(DocumentFormat imageFormat, int encoderParameter) throws GdPictureException {

		SAFEARRAY safeArray = SAFEARRAY.createSafeArray(new WTypes.VARTYPE(Variant.VT_UI1), 1);
		VARIANT dataInOut = new VARIANT();
		dataInOut.setValue(/* Variant.VT_BYREF | */ Variant.VT_ARRAY, safeArray);

		IntByReference length = new IntByReference();
		VARIANT lengthInOut = new VARIANT();
		lengthInOut.setValue(Variant.VT_BYREF | Variant.VT_INT, length);

		VARIANT status = this.invoke("SaveAsByteArray", new VARIANT[] { imageId, dataInOut, lengthInOut, new VARIANT(imageFormat.getValue()), new VARIANT(encoderParameter) });
		checkStatus(status);

		return (byte[]) OaIdlUtil.toPrimitiveArray(safeArray, false);
	}

	public void saveAsBMP(File destination) throws GdPictureException {
		VARIANT status = this.invoke("SaveAsBMP", new VARIANT[] { imageId, new VARIANT(destination.getAbsolutePath()) });
		checkStatus(status);
	}

	public void saveAsTiff(File destination, int compression) throws GdPictureException {
		VARIANT status = this.invoke("SaveAsTIFF", new VARIANT[] { imageId, new VARIANT(destination.getAbsolutePath()), new VARIANT(compression) });
		checkStatus(status);
	}

	private void releaseImage(VARIANT imageId) throws GdPictureException {
		if (imageId != null && imageId.intValue() > 0) {
			VARIANT status = this.invoke("ReleaseGdPictureImage", imageId);
			checkStatus(status);
		}
	}

	public void releaseImage() {
		try {
			if (imageId != null) {
				releaseImage(imageId);
				imageId = null;
			}
		} catch (Exception e) {
			System.err.println("Ignorato errore release immagine " + imageId + "(" + e.toString() + ")");
		}
	}

	public void close() {
		releaseImage();
		this.invoke("Dispose");
	}

}
