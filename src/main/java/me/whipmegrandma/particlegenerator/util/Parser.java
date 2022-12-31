package me.whipmegrandma.particlegenerator.util;

public class Parser {

	public static Float parseFloat(String string) {
		try {
			return Float.parseFloat(string);
		} catch (Throwable t) {
		}

		return null;
	}
}
