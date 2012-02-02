package com.ks.code.core.web.util;

public class StringUtils {
	/**
	 * ���ڿ� �ڸ���
	 * 
	 * @param str
	 * @param len
	 * @param strTail
	 * @return
	 */
	public static String cutString(String str, int len, String strTail) {
		if (str == null)
			return null;
		int srcLen = str.getBytes().length;
		if (srcLen < len)
			return str;
		String tmpTail = strTail;
		if (strTail == null)
			tmpTail = "";
		int tailLen = tmpTail.getBytes().length;
		if (tailLen > len)
			return "";
		char a;
		int i = 0;
		int realLen = 0;
		for (i = 0; i < len - tailLen && realLen < len - tailLen; i++) {
			a = str.charAt(i);
			if ((a & 0xFF00) == 0)
				realLen += 1;
			else
				realLen += 2;
		}
		while ((str.substring(0, i)).getBytes().length > len - tailLen) {
			i--;
		}
		return str.substring(0, i) + tmpTail;
	}

	/**
	 * ���ڿ� ġȯ( <br> )
	 * 
	 * @param content
	 * @return
	 */
	public static String changeEnterToBR(String content) {
		int length = content.length();
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < length; ++i) {
			String comp = content.substring(i, i + 1);
			if ("\r".compareTo(comp) == 0) {
				comp = content.substring(++i, i + 1);
				if ("\n".compareTo(comp) == 0) {
					buffer.append("<br />\r");
				} else {
					buffer.append("\r");
				}
			}

			buffer.append(comp);
		}
		return buffer.toString();
	}

	public static String HTML(String s) {
		String html;
		html = replace(s, "&", "&amp;");
		html = replace(html, "<", "&lt;");
		html = replace(html, ">", "&gt;");
		html = replace(html, " ", "&nbsp;");
		html = replace(html, "\n", "<br />");
		html = replace(html, "\t", "&nbsp;&nbsp;");
		html = replace(html, "\"", "&quot;");
		return html;
	}
	
	public static String htmlByTag(String s) {
		String html;
		html = replace(s, "<", "&lt;");
		html = replace(html, ">", "&gt;");
		return html;
	}

	public static String replace(String src, String oldstr, String newstr) {
		if (src == null) {
			return null;
		}

		StringBuffer dest = new StringBuffer("");
		int len = oldstr.length();
		int srclen = src.length();
		int pos = 0;
		int oldpos = 0;

		while ((pos = src.indexOf(oldstr, oldpos)) >= 0) {
			dest.append(src.substring(oldpos, pos));
			dest.append(newstr);
			oldpos = pos + len;
		}

		if (oldpos < srclen) {
			dest.append(src.substring(oldpos, srclen));

		}
		return dest.toString();
	}

	/**
	 * �ʱ� ��Ʈ�� ���� �� ����
	 * 
	 * @param str
	 *            �񱳰�
	 * @param value
	 *            �⺻��
	 * @return
	 */
	public static String defaultValue(String str, String value) {
		if (str == null || str.equals("") || str.equals("null")
				|| str == "null") {
			str = value;
		}
		return str;
	}

	/**
	 * �ʱ� ��Ʈ�� ���� �� ���� ("")
	 * 
	 * @param str
	 *            �񱳰�
	 * @param value
	 *            �⺻��
	 * @return
	 */
	public static String defaultValue(String str) {
		if (str == null || str.equals("") || str.equals("null")
				|| str == "null") {
			str = "";
		}
		return str;
	}

	public static String getGender(String num) {
		String gender = "";
		if (num.equals("1")) {
			gender = "M";
		} else if (num.equals("2")) {
			gender = "F";
		}
		return gender;
	}
}
