package com.netsitech.paper;

import java.io.File;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.netsitech.paper.gdpicture.GdPictureImaging;
import com.netsitech.paper.gdpicture.GdPictureLicenseManager;
import com.netsitech.paper.gdpicture.enums.DocumentFormat;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Ole32;

public class MainTest {

	public static void main(String[] args) {
		System.out.println("init");
		Ole32.INSTANCE.CoInitializeEx(Pointer.NULL, Ole32.COINIT_MULTITHREADED);
		try {
			System.out.println("start");

			String version = "14";
			GdPictureLicenseManager oLicenseManager = new GdPictureLicenseManager(version);
			oLicenseManager.registerKEY(""); // TODO put your key here

			GdPictureImaging gdp = new GdPictureImaging(version);

			try {

				byte[] input = getResourceAsByteArray("img.bmp");
				gdp.loadImage(input, null);
				System.out.println("loadImage ok");

				byte[] bmp = gdp.getAs(DocumentFormat.DocumentFormatJPEG, 25);
				System.out.println("getAs ok");

				saveImageForManualCheck(bmp, "getAsBMP.jpg");
				gdp.releaseImage();
				System.out.println("releaseImage ok");

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				gdp.close();
			}

			System.out.println("end");
		} finally {
			Ole32.INSTANCE.CoUninitialize();
		}
		System.out.println("post-end");
	}

	private static byte[] getResourceAsByteArray(String name) {
		try {
			try (InputStream is = MainTest.class.getResourceAsStream("/" + name)) {
				return IOUtils.toByteArray(is);
			}
		} catch (Exception e) {
			throw new RuntimeException("Error loading resource " + name, e);
		}
	}

	private static void saveImageForManualCheck(byte[] data, String name) {
		File f = new File(getTmpDir() + File.separator + name);
		try {
			FileUtils.writeByteArrayToFile(f, data);
			System.out.println("Saved tmp file " + f.getAbsolutePath());
		} catch (Exception e) {
			throw new RuntimeException("Unable to save image " + f.getAbsolutePath(), e);
		}
	}

	static File tmpdir = null;

	static synchronized File getTmpDir() {
		if (tmpdir == null) {
			try {
				tmpdir = new File("dest");
				tmpdir.mkdirs();
				tmpdir.mkdir();
				System.out.println("Temp directory created: " + tmpdir.getAbsolutePath());
			} catch (Exception e) {
				throw new RuntimeException("Error creating temp directory", e);
			}
		}
		return tmpdir;
	}

}
