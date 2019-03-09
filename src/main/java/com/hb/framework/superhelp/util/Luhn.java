/**
 * 
 */
package com.hb.framework.superhelp.util;

/**
 * @author 产品组 Nov 28, 2015
 * 
 */
public abstract class Luhn {
	public Luhn() {
	}

	private static String getDigitsOnly(String s) {
		StringBuffer digitsOnly = new StringBuffer();

		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				digitsOnly.append(c);
			}
		}

		return digitsOnly.toString();
	}

	public static String getLuhnIdStr(String LuhnNbr) {
		String digitsOnly = getDigitsOnly(LuhnNbr);
		if (48 != digitsOnly.charAt(digitsOnly.length() - 1)) {
			return null;
		} else {
			int sum = 0;
			boolean digit = false;
			boolean addend = false;
			boolean timesTwo = false;

			int modulus;
			for (modulus = digitsOnly.length() - 1; modulus >= 0; --modulus) {
				int var8 = Integer.parseInt(digitsOnly.substring(modulus,
						modulus + 1));
				int var9;
				if (timesTwo) {
					var9 = var8 * 2;
					if (var9 > 9) {
						var9 -= 9;
					}
				} else {
					var9 = var8;
				}

				sum += var9;
				timesTwo = !timesTwo;
			}

			modulus = sum % 10;
			StringBuffer sb = new StringBuffer();
			if (modulus == 0) {
				return digitsOnly;
			} else {
				return sb.append(digitsOnly.substring(0, LuhnNbr.length() - 1))
						.append(10 - modulus).toString();
			}
		}
	}

	public static void main(String[] args) {
	}
}