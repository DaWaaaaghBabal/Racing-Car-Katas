package tddmicroexercises.textconvertor;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class HtmlTextConverterTest {
    @Test
    public void testGetFileName() {
		String testFileName = "C:\\Programmation\\Projets\\Racing-Car-Katas\\Java\\TextConverter\\src\\test\\resources\\HelloWorld";
        HtmlTextConverter converter = new HtmlTextConverter(testFileName);
        assertEquals(testFileName, converter.getFilename());
    }
    
    @Test 
    public void testSimpleTextWithoutSpecialCharacters() throws IOException {
    	String testFileName = "C:\\Programmation\\Projets\\Racing-Car-Katas\\Java\\TextConverter\\src\\test\\resources\\HelloWorld";
    	String expected = "Hello, World!<br />";
    	HtmlTextConverter converter = new HtmlTextConverter(testFileName);
        assertEquals(expected, converter.convertToHtml());
    }

    @Test 
    public void testMultilineTextWithoutSpecialCharacters() throws IOException {
    	String testFileName = "C:\\Programmation\\Projets\\Racing-Car-Katas\\Java\\TextConverter\\src\\test\\resources\\Multiline";
    	String expected = "Hello,<br />World!<br />";
    	HtmlTextConverter converter = new HtmlTextConverter(testFileName);
        assertEquals(expected, converter.convertToHtml());
    }
    
    @Test 
    public void testTextWithSpecialCharacters() throws IOException {
    	String testFileName = "C:\\Programmation\\Projets\\Racing-Car-Katas\\Java\\TextConverter\\src\\test\\resources\\SpecialCharacters";
    	String expected = "I said with a newborn&quot;s glee:<br />" + 
    			"&quot;&lt;Hello&gt;&amp;World!&quot;<br />";
    	HtmlTextConverter converter = new HtmlTextConverter(testFileName);
        assertEquals(expected, converter.convertToHtml());
    }
    
    @Test
    public void testReadFile() throws IOException {
    	String testFileName = "C:\\Programmation\\Projets\\Racing-Car-Katas\\Java\\TextConverter\\src\\test\\resources\\HelloWorld";
    	List<String> expected = new ArrayList<>();
    	expected.add("Hello, World!");
    	HtmlTextConverter converter = new HtmlTextConverter(testFileName);
    	assertEquals(expected, converter.extractTextFromFile());
    }
}
