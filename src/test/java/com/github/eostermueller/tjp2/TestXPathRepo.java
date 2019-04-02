package com.github.eostermueller.tjp2;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.github.eostermueller.tjp2.Controller;
import com.github.eostermueller.tjp2.PlaybackRepository;

public class TestXPathRepo {
	PlaybackRepository repo = new PlaybackRepository();
	private static String RESPONSE_01 = "<response>foo-bar-hello-world</response>";
	private static String RESPONSE_02 = "<response>other</response>";
	private static String RESPONSE_03 = "<response>otherMessage</response>";

	@Before
	public void setup() {
		
		repo.add("/foo/bar/hello/world", RESPONSE_01);
		repo.add("/foo/other", RESPONSE_02);
		repo.add("/foo/otherMessage", RESPONSE_03);
		
	}
	
	@Test
	public void canFindResponseForThisRequest() throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {
		String input_01 = "<foo><bar><hello><world/></hello></bar></foo>";
		String resp = repo.getResponse( input_01 );
		assertEquals(RESPONSE_01,resp);
	}
	
	@Test
	public void canFindResponseForOtherRequest() throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {
		String input_02 = "<foo><other/></foo>";
		String resp = repo.getResponse( input_02 );
		assertEquals(RESPONSE_02,resp);
	}
	@Test
	public void canFindResponseForOtherMessageRequest() throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {
		String input_03 = "<foo><otherMessage/></foo>";
		String resp = repo.getResponse( input_03 );
		assertEquals(RESPONSE_03,resp);
	}
	@Test
	public void canFindResponse_domCache() throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {
		String input_01 = "<foo><bar><hello><world/></hello></bar></foo>";
		Controller.getConfig().setXPathImplementation( new Integer(1));
		String resp = repo.getResponse(input_01);
		assertEquals(RESPONSE_01,resp);
	}
	@Test
	public void canFindResponse_responseCache() throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {
		String input_01 = "<foo><bar><hello><world/></hello></bar></foo>";
		Controller.getConfig().setXPathImplementation( new Integer(1));
		String resp = repo.getResponse(input_01);
		assertEquals(RESPONSE_01,resp);
	}

}
