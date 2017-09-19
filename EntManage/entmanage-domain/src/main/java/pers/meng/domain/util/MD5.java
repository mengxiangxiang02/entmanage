package pers.meng.domain.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

	// 全局数组
	private final static String[] strDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D",
			"E", "F" };

	// 返回形式为数字跟字符串
	private static String byteToArrayString(byte bByte) {
		int iRet = bByte;
		// System.out.println("iRet="+iRet);
		if (iRet < 0) {
			iRet += 256;
		}
		int iD1 = iRet / 16;
		int iD2 = iRet % 16;
		return strDigits[iD1] + strDigits[iD2];
	}

	// 转换字节数组为16进制字串
	public static String byteToString(byte[] bByte) {
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < bByte.length; i++) {
			sBuffer.append(byteToArrayString(bByte[i]));
		}
		return sBuffer.toString();
	}

	public static String sign(String strObj) {
		String resultString = "";
		try {
			if (strObj != null) {
				MessageDigest md = MessageDigest.getInstance("MD5");
				resultString = byteToString(md.digest(strObj.getBytes()));
			}
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return resultString.toUpperCase();
	}

	public static String md5(String originstr) {
		String returnString = originstr;
		if (originstr != null && !originstr.isEmpty()) {

			try {
				MessageDigest m = MessageDigest.getInstance("md5");
				m.update(originstr.getBytes("UTF8"));
				byte[] s = m.digest();
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < s.length; i++) {
					sb.append(Integer.toHexString(s[i] & 0xFF | 0x100).substring(1, 3));
				}

				returnString = sb.toString();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return returnString.toUpperCase();

	}
	public static void main(String[] args) {
		String md5=md5("1");
		System.out.println(md5);
	}
}