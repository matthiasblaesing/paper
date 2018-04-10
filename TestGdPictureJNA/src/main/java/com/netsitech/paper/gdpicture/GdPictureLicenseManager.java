package com.netsitech.paper.gdpicture;

import com.sun.jna.platform.win32.Variant.VARIANT;
import com.sun.jna.platform.win32.COM.COMLateBindingObject;

public class GdPictureLicenseManager extends COMLateBindingObject {

	public GdPictureLicenseManager(String version) {
		super("GdPicture" + version + ".LicenseManager", false);
	}

	public void registerKEY(String key) {
		this.invoke("RegisterKEY", new VARIANT(key));
	}

}
