package com.netsitech.paper.gdpicture.enums;

/**
 * Enum di comodo per gestire i valori della GdPicture
 */
public enum TagType {

	TagTypeASCII(2), //
	TagTypeByte(1), //
	TagTypeDouble(12), //
	TagTypeFloat(11), //
	TagTypeIFD(18), //
	TagTypeLong(4), //
	TagTypeLong64(16), //
	TagTypeRational(5), //
	TagTypeSByte(6), //
	TagTypeShort(3), //
	TagTypeSLong(9), //
	TagTypeSLong64(17), //
	TagTypeSRational(10), //
	TagTypeSShort(8), //
	TagTypeUndefined(7);

	private final int value;

	private TagType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static TagType valueOf(int value) {
		for (TagType t : TagType.values()) {
			if (t.getValue() == value) {
				return t;
			}
		}
		return null;
	}

}
