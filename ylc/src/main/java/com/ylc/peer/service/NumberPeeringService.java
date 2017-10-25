package com.ylc.peer.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.xml.sax.InputSource;

import com.ylc.peer.assignnum.request.model.PEER;

@Service
public class NumberPeeringService {
	

	
	@Value("${ylc.numberpeering.url}")
	private String url;
	
	@Value("${ylc.numberpeering.user}")
	private String userName;
	
	
	@Value("${ylc.numberpeering.password}")
	private String password;
	
	
	public com.ylc.peer.assignnum.response.model.PEER getAssigNum(PEER peer) throws JAXBException{
		  System.err.println("numberpeering>>>>>>>>>>>>>>>###############"+url);
		  peer.getHDR().setPass(password);
		  peer.getHDR().setUser(userName);
		  String reqXml=marshal(peer);
	      System.err.println("reqXml>>>>>>>>>>>>>>>###############"+reqXml);
		  RestTemplate restTemplate = new RestTemplate();	
		
		  String respXml="";
		  respXml =restTemplate.postForObject(url,reqXml,String.class);		  
	      System.err.println("respXml>>>>>>>>>>>>>>>##########"+respXml);
	     com.ylc.peer.assignnum.response.model.PEER peerResp=unmarshal(respXml);
	     
		  return peerResp;
	}
	
	
	public com.ylc.peer.listaval.response.model.PEER listAvailableNumbers(com.ylc.peer.listaval.request.model.PEER peer) throws JAXBException{
		  System.err.println("numberpeering>>>>>>>>>>>>>>>###############"+url);
		  peer.getHDR().setPass(password);
		  peer.getHDR().setUser(userName);
		  String reqXml=marshal(peer);
	      System.err.println("listAvailableNumbers reqXml>>>>>>>>>>>>>>>###############"+reqXml);
		  RestTemplate restTemplate = new RestTemplate();	
		
		  String respXml="";
		  respXml =restTemplate.postForObject(url,reqXml,String.class);		  
	      System.err.println("listAvailableNumbers respXml>>>>>>>>>>>>>>>##########"+respXml);
	      com.ylc.peer.listaval.response.model.PEER peerResp=unmarshalListVal(respXml);
	     
		  return peerResp;
	}
	  private String marshal(PEER peer) throws JAXBException{    
			JAXBContext jaxbContext = JAXBContext.newInstance(PEER.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();		
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StreamResult result = new StreamResult(new StringWriter());	
			jaxbMarshaller.marshal(peer,result);
			System.err.println("Request XMLLLLLLLLLL"+result.getWriter().toString());    	
	    	return result.getWriter().toString();
	    	
	    }
	    
	    private com.ylc.peer.assignnum.response.model.PEER unmarshal(String respXML) throws JAXBException{    
	    	JAXBContext jaxbContext = JAXBContext.newInstance(com.ylc.peer.assignnum.response.model.PEER.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			InputSource inputSource = new InputSource(new java.io.StringReader(respXML.trim()));	
			InputStream stream = new ByteArrayInputStream(respXML.trim().getBytes(StandardCharsets.UTF_8));
			com.ylc.peer.assignnum.response.model.PEER peerRes = (com.ylc.peer.assignnum.response.model.PEER) jaxbUnmarshaller.unmarshal(stream);
			System.err.println("##############################"+peerRes);
			System.err.println("##############################"+peerRes.getHDR().getSTATUS());
	    	return peerRes;
	    	
	    }
	    
	
    private String marshal(com.ylc.peer.listaval.request.model.PEER peer) throws JAXBException{    
		JAXBContext jaxbContext = JAXBContext.newInstance(com.ylc.peer.listaval.request.model.PEER.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();		
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StreamResult result = new StreamResult(new StringWriter());	
		jaxbMarshaller.marshal(peer,result);
		System.err.println("Request XMLLLLLLLLLL"+result.getWriter().toString());    	
    	return result.getWriter().toString();
    	
    }
    
    private com.ylc.peer.listaval.response.model.PEER unmarshalListVal(String respXML) throws JAXBException{    
    	JAXBContext jaxbContext = JAXBContext.newInstance(com.ylc.peer.listaval.response.model.PEER.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		InputSource inputSource = new InputSource(new java.io.StringReader(respXML.trim()));	
		InputStream stream = new ByteArrayInputStream(respXML.trim().getBytes(StandardCharsets.UTF_8));
		com.ylc.peer.listaval.response.model.PEER peerRes = (com.ylc.peer.listaval.response.model.PEER) jaxbUnmarshaller.unmarshal(stream);
		System.err.println("##############################"+peerRes);
		System.err.println("##############################"+peerRes.getHDR().getSTATUS());
    	return peerRes;
    	
    }

}
