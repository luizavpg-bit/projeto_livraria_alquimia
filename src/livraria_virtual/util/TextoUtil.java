package livraria_virtual.util;

import java.text.Normalizer;

public class TextoUtil {

		public static String normalizar(String texto) {

		if (texto == null) {
			return "";
		}

		String semAcento = Normalizer.normalize(texto, Normalizer.Form.NFD);
		semAcento = semAcento.replaceAll("\\p{InCombiningDiacriticalMarks}", "");

		return semAcento.toLowerCase().trim();
	}
}