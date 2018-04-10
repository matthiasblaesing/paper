package com.netsitech.paper.gdpicture;

import java.io.File;

import com.netsitech.paper.gdpicture.enums.DocumentFormat;
import com.netsitech.paper.gdpicture.enums.GdPictureStatus;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.OaIdl.SAFEARRAY;
import com.sun.jna.platform.win32.Variant;
import com.sun.jna.platform.win32.Variant.VARIANT;
import com.sun.jna.platform.win32.WTypes;
import com.sun.jna.platform.win32.COM.COMLateBindingObject;
import com.sun.jna.platform.win32.WTypes.VARTYPE;
import com.sun.jna.platform.win32.WinDef.PVOID;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

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
            // Initialize SAFEARRAY as input
            SAFEARRAY safeArray = SAFEARRAY.createSafeArray(new WTypes.VARTYPE(Variant.VT_UI1), 1);
            try {
                // This is a hack to work around a limit in the definition
                // of VARIANT in JNA - a SAFEARRAY ByRef is not correctly
                // handled.
                //
                // Initialize a VARIANT
                VARIANT dataInOut = new VARIANT();
                // Get a Pointer to the SAFEARRAY structure (**SAFEARRAY)
                PointerByReference pbr = new PointerByReference(safeArray.getPointer());
                // First ensure the value reaches the VARIANT structure by
                // using the generic VT_BYREF marker
                dataInOut.setValue(new VARTYPE(Variant.VT_BYREF), new PVOID(pbr.getPointer()));
                // Now override the type to make the library accept it
                dataInOut.setVarType((short) (Variant.VT_BYREF | Variant.VT_ARRAY | Variant.VT_UI1));

                IntByReference length = new IntByReference();
                VARIANT lengthInOut = new VARIANT();
                lengthInOut.setValue(Variant.VT_BYREF | Variant.VT_INT, length);

                System.out.println(pbr.getPointer() + " - " + pbr.getValue());

                VARIANT status = this.invoke("SaveAsByteArray", new VARIANT[]{imageId, dataInOut, lengthInOut, new VARIANT(imageFormat.getValue()), new VARIANT(encoderParameter)});
                checkStatus(status);

                if (!pbr.getValue().equals(safeArray.getPointer())) {
                    // The library returned a new array - we need to destroy
                    // the old one and wrap the new one
                    safeArray.destroy();
                    safeArray = new SAFEARRAY(pbr.getValue());
                }
                System.out.println(pbr.getPointer() + " - " + pbr.getValue());

                // After the call the safeArray structure needs to be
                // manually updated as JNA can't determine that the structure
                // needs to be updated
                safeArray.read();

                // Access the raw data of the safearray. As it is one 
                // dimensional the backing memory can read linearly
                Pointer pointer = safeArray.accessData();
                try {
                    return pointer.getByteArray(0, safeArray.getUBound(0) - safeArray.getLBound(0) + 1);
                } finally {
                    // accessData locks the array and would prevent destructing it.
                    safeArray.unaccessData();
                }
            } finally {
                // destroy the SAFEARRAY after use
                if (safeArray != null) {
                    safeArray.destroy();
                }
            }
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
