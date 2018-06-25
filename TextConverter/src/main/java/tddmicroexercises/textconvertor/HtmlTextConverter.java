package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HtmlTextConverter {

	private String fullFilenameWithPath;

	public HtmlTextConverter(String fullFilenameWithPath) {
		this.fullFilenameWithPath = fullFilenameWithPath;
	}

	public String convertToHtml() throws IOException {
		List<String> text = extractTextFromFile();
		StringBuffer buffer = new StringBuffer();
		for (String line : text) {
			buffer.append(StringEscapeUtils.escapeHtml(line));
			buffer.append("<br />");
		}
		return buffer.toString();
	}

	public String getFilename() {
		return this.fullFilenameWithPath;
	}

	public List<String> extractTextFromFile() throws IOException {

		List<String> text = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(fullFilenameWithPath))) {
			String line = reader.readLine();

			while (line != null) {
				text.add(line);
				line = reader.readLine();
			}
		} catch (IOException e) {
			// Just forward for now.
			throw e;
		}
		return text;
	}

}
