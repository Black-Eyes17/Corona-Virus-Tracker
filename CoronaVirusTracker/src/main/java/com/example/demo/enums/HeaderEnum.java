package com.example.demo.enums;

import java.util.HashMap;
import java.util.Map;

public final class HeaderEnum {
	public static enum ConfirmedCoronaCaseEnum {
		// identifier(codeNumIdentif, header)
		ProvinceOrStreet("PS", "Province/State"),
			CountryOrRegion("CR", "Country/Region");

		private static Map<String, ConfirmedCoronaCaseEnum> numToCodeMapping;
		private static Map<String, ConfirmedCoronaCaseEnum> codeToNumMapping;

		private static void codeToNumInitMapping() {
			ConfirmedCoronaCaseEnum.codeToNumMapping = new HashMap<String, ConfirmedCoronaCaseEnum>();
			for (ConfirmedCoronaCaseEnum mv : ConfirmedCoronaCaseEnum.values()) {
				ConfirmedCoronaCaseEnum.codeToNumMapping.put(mv.header, mv);
			}
		}

		public static ConfirmedCoronaCaseEnum getCodeNumIdentif(String s) {
			if (ConfirmedCoronaCaseEnum.codeToNumMapping == null) {
				ConfirmedCoronaCaseEnum.codeToNumInitMapping();
			}
			return ConfirmedCoronaCaseEnum.codeToNumMapping.get(s);
		}

		public static ConfirmedCoronaCaseEnum getHeader(String i) {
			if (ConfirmedCoronaCaseEnum.numToCodeMapping == null) {
				ConfirmedCoronaCaseEnum.numToCodeInitMapping();
			}
			return ConfirmedCoronaCaseEnum.numToCodeMapping.get(i);
		}

		private static void numToCodeInitMapping() {
			ConfirmedCoronaCaseEnum.numToCodeMapping = new HashMap<String, ConfirmedCoronaCaseEnum>();
			for (ConfirmedCoronaCaseEnum mv : ConfirmedCoronaCaseEnum.values()) {
				ConfirmedCoronaCaseEnum.numToCodeMapping.put(mv.codeNumIdentif, mv);
			}
		}

		private String codeNumIdentif;

		private String header;

		private ConfirmedCoronaCaseEnum(String codeNumIdentif, String header) {
			this.codeNumIdentif = codeNumIdentif;
			this.header = header;
		}

		public String getCodeNumIdentif() {
			return codeNumIdentif;
		}

		public String getHeader() {
			return header;
		}
	}
}
