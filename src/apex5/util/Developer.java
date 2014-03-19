package apex5.util;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

public final class Developer {

	public static void PrintAllFonts() {
		// Many thanks to Zetcode for this utility code
		GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		Font[] fonts = ge.getAllFonts();

		for (int i = 0; i < fonts.length; i++) {

			System.out.print(fonts[i].getFontName() + " : ");
			System.out.println(fonts[i].getFamily());
		}
	}
}
