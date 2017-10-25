package com.ylc.authorize.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.xml.sax.InputSource;

import com.ylc.authorize.model.ANetApiRequest;
import com.ylc.authorize.model.ANetApiResponse;
import com.ylc.authorize.model.CreateCustomerProfileRequest;
import com.ylc.authorize.model.CreateCustomerProfileResponse;
import com.ylc.authorize.model.CreateTransactionRequest;
import com.ylc.authorize.model.CreateTransactionResponse;
import com.ylc.authorize.model.CustomerPaymentProfileMaskedType;
import com.ylc.authorize.model.GetCustomerProfileRequest;
import com.ylc.authorize.model.GetCustomerProfileResponse;
import com.ylc.authorize.model.MerchantAuthenticationType;
import com.ylc.authorize.model.ObjectFactory;
import com.ylc.authorize.model.UpdateCustomerPaymentProfileRequest;
import com.ylc.authorize.model.UpdateCustomerPaymentProfileResponse;
import com.ylc.model.CreditCard;
import com.ylc.model.PaymentProfile;

@Service
public class AuthorizeNetService {
	
	@Value("${ylc.authorize.url}")
	private String url;

	@Value("${ylc.authorize.user}")
	private String userName;

	@Value("${ylc.authorize.password}")
	private String password;
	
	public CreateTransactionResponse chargeCreditCard(CreateTransactionRequest createTransactionRequest) throws JAXBException{

		createTransactionRequest.getMerchantAuthentication().setTransactionKey(password);
		createTransactionRequest.getMerchantAuthentication().setName(userName);
		String reqXml=marshal(createTransactionRequest,CreateTransactionRequest.class);
		System.err.println("reqXml>>>>>>>>>>>>>>>"+reqXml);
		System.err.println("url>>>>>>>>>>>>>>>"+url);
		HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.TEXT_XML);
		HttpEntity<String> entity = new HttpEntity<String>(reqXml,headers);
		RestTemplate restTemplate = new RestTemplate();		
	   ResponseEntity<String> result=restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
	 
	   String body = result.getBody();
	   MediaType contentType = result.getHeaders().getContentType();
	   HttpStatus statusCode = result.getStatusCode();  
	   
	    System.err.println("resXML>>>>>>>>>>>>>>>"+result);
	    System.err.println("body>>>>>>>>>>>>>>>::::"+body);
	    System.err.println("statusCode>>>>>>>>>>>>>>>::::"+statusCode);
	    System.err.println("statusCode>>>>>>>>>>>>>>>::::"+statusCode.getReasonPhrase());
	    System.err.println("contentType>>>>>>>>>>>>>>>::::"+contentType);
	 //   System.err.println("resXML>>>>>>>>>>>>>>>"+resXML);
	    return (CreateTransactionResponse)unmarshal(body,CreateTransactionResponse.class);

	}
	
/*	public CreateCustomerProfileResponse createCustomerProfiles(CreateCustomerProfileRequest createCustomerProfileRequest) throws JAXBException{

		createCustomerProfileRequest.getMerchantAuthentication().setTransactionKey(password);
		createCustomerProfileRequest.getMerchantAuthentication().setName(userName);
		String reqXml=marshal(createCustomerProfileRequest,CreateCustomerProfileRequest.class);
		System.err.println("reqXml>>>>>>>>>>>>>>>"+reqXml);
		System.err.println("url>>>>>>>>>>>>>>>"+url);
		HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.TEXT_XML);
		HttpEntity<String> entity = new HttpEntity<String>(reqXml,headers);
		RestTemplate restTemplate = new RestTemplate();		
	   ResponseEntity<String> result=restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
	 
	   String body = result.getBody();
	   MediaType contentType = result.getHeaders().getContentType();
	   HttpStatus statusCode = result.getStatusCode();  
	   
	    System.err.println("resXML>>>>>>>>>>>>>>>"+result);
	    System.err.println("body>>>>>>>>>>>>>>>::::"+body);
	    System.err.println("statusCode>>>>>>>>>>>>>>>::::"+statusCode);
	    System.err.println("statusCode>>>>>>>>>>>>>>>::::"+statusCode.getReasonPhrase());
	    System.err.println("contentType>>>>>>>>>>>>>>>::::"+contentType);	
	    return (CreateCustomerProfileResponse) unmarshal(body,CreateCustomerProfileResponse.class);

	}
	
	
	public GetCustomerProfileResponse getCustomerProfiles(GetCustomerProfileRequest getCustomerProfileRequest) throws JAXBException{

		getCustomerProfileRequest.getMerchantAuthentication().setTransactionKey(password);
		getCustomerProfileRequest.getMerchantAuthentication().setName(userName);
		String reqXml=marshal(getCustomerProfileRequest,GetCustomerProfileRequest.class);
		System.err.println("reqXml>>>>>>>>>>>>>>>"+reqXml);
		System.err.println("url>>>>>>>>>>>>>>>"+url);
		HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.TEXT_XML);
		HttpEntity<String> entity = new HttpEntity<String>(reqXml,headers);
		RestTemplate restTemplate = new RestTemplate();		
	   ResponseEntity<String> result=restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
	 
	   String body = result.getBody();
	   MediaType contentType = result.getHeaders().getContentType();
	   HttpStatus statusCode = result.getStatusCode();  
	   
	    System.err.println("resXML>>>>>>>>>>>>>>>"+result);
	    System.err.println("body>>>>>>>>>>>>>>>::::"+body);
	    System.err.println("statusCode>>>>>>>>>>>>>>>::::"+statusCode);
	    System.err.println("statusCode>>>>>>>>>>>>>>>::::"+statusCode.getReasonPhrase());
	    System.err.println("contentType>>>>>>>>>>>>>>>::::"+contentType);	
	    return (GetCustomerProfileResponse) unmarshal(body,GetCustomerProfileResponse.class);

	}
	
	public UpdateCustomerPaymentProfileResponse updateCustomerPaymentProfiles(UpdateCustomerPaymentProfileRequest updateCustomerPaymentProfileRequest) throws JAXBException{

		updateCustomerPaymentProfileRequest.getMerchantAuthentication().setTransactionKey(password);
		updateCustomerPaymentProfileRequest.getMerchantAuthentication().setName(userName);
		String reqXml=marshal(updateCustomerPaymentProfileRequest,UpdateCustomerPaymentProfileRequest.class);
		System.err.println("reqXml>>>>>>>>>>>>>>>"+reqXml);
		System.err.println("url>>>>>>>>>>>>>>>"+url);
		HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.TEXT_XML);
		HttpEntity<String> entity = new HttpEntity<String>(reqXml,headers);
		RestTemplate restTemplate = new RestTemplate();		
	    ResponseEntity<String> result=restTemplate.exchange(url, HttpMethod.POST, entity, String.class);	 
	   String body = result.getBody();
	   MediaType contentType = result.getHeaders().getContentType();
	   HttpStatus statusCode = result.getStatusCode();  	   
	    System.err.println("resXML>>>>>>>>>>>>>>>"+result);
	    System.err.println("body>>>>>>>>>>>>>>>::::"+body);
	    System.err.println("statusCode>>>>>>>>>>>>>>>::::"+statusCode);
	    System.err.println("statusCode>>>>>>>>>>>>>>>::::"+statusCode.getReasonPhrase());
	    System.err.println("contentType>>>>>>>>>>>>>>>::::"+contentType);	
	    return (UpdateCustomerPaymentProfileResponse) unmarshal(body,UpdateCustomerPaymentProfileResponse.class);

	}*/
	public PaymentProfile getdetailsForProfile(String paymentGatewayId){
		PaymentProfile paymentProfile=new PaymentProfile();
		CreditCard cc=new CreditCard();
    	ObjectFactory objectFactory=new ObjectFactory();
		MerchantAuthenticationType merchantAuthenticationType=objectFactory.createMerchantAuthenticationType();		
		GetCustomerProfileRequest getCustomerProfileRequest=objectFactory.createGetCustomerProfileRequest();
		getCustomerProfileRequest.setMerchantAuthentication(merchantAuthenticationType);
		getCustomerProfileRequest.setCustomerProfileId(paymentGatewayId);	
	
		try {
			GetCustomerProfileResponse getCustomerProfileResponse=(GetCustomerProfileResponse)callPaymentService(getCustomerProfileRequest,GetCustomerProfileRequest.class,GetCustomerProfileResponse.class);
			if(getCustomerProfileResponse!=null){
				List<CustomerPaymentProfileMaskedType> ppList=getCustomerProfileResponse.getProfile().getPaymentProfiles();
				for(CustomerPaymentProfileMaskedType pProfile :ppList){
					paymentProfile.setPaymentProfileID(pProfile.getCustomerPaymentProfileId());
					cc.setLast4Digits(pProfile.getPayment().getCreditCard().getCardNumber());
					cc.setCardNumber(pProfile.getPayment().getCreditCard().getCardNumber());
					cc.setExp(pProfile.getPayment().getCreditCard().getExpirationDate());
					cc.setCardType(pProfile.getPayment().getCreditCard().getCardType());
					paymentProfile.setCreditCard(cc);
				}
			}
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return paymentProfile;
	
	}
	public ANetApiResponse callPaymentService(ANetApiRequest anetApiRequest,Class requestClass,Class respClass)throws JAXBException{		
		anetApiRequest.getMerchantAuthentication().setTransactionKey(password);
		anetApiRequest.getMerchantAuthentication().setName(userName);
		String reqXml=marshal(anetApiRequest,requestClass);
		System.err.println("reqXml>>>>>>>>>>>>>>>"+reqXml);
		System.err.println("url>>>>>>>>>>>>>>>"+url);
		HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.TEXT_XML);
		HttpEntity<String> entity = new HttpEntity<String>(reqXml,headers);
		RestTemplate restTemplate = new RestTemplate();		
	   ResponseEntity<String> result=restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
	 
	   String body = result.getBody();
	   MediaType contentType = result.getHeaders().getContentType();
	   HttpStatus statusCode = result.getStatusCode();  
	   
	    System.err.println("resXML>>>>>>>>>>>>>>>"+result);
	    System.err.println("body>>>>>>>>>>>>>>>::::"+body);
	    System.err.println("statusCode>>>>>>>>>>>>>>>::::"+statusCode);
	    System.err.println("statusCode>>>>>>>>>>>>>>>::::"+statusCode.getReasonPhrase());
	    System.err.println("contentType>>>>>>>>>>>>>>>::::"+contentType);	
	    return  unmarshal(body,respClass);
		
	}
	
	
	 private String marshal(ANetApiRequest anetApiRequest,Class requestClass) throws JAXBException{    
			JAXBContext jaxbContext = JAXBContext.newInstance(requestClass);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();		
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StreamResult result = new StreamResult(new StringWriter());	
			jaxbMarshaller.marshal(anetApiRequest,result);
			System.err.println("Request XMLLLLLLLLLL"+result.getWriter().toString());    	
	    	return result.getWriter().toString().trim();
	    	
	    }
	    
	    private ANetApiResponse unmarshal(String resXML,Class respClass) throws JAXBException{    
	    	JAXBContext jaxbContext = JAXBContext.newInstance(respClass);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		//	InputSource inputSource = new InputSource(new java.io.StringReader(resXML.trim()));	
			InputStream stream = new ByteArrayInputStream(resXML.trim().getBytes(StandardCharsets.UTF_8));
			ANetApiResponse anetApiResponse = (ANetApiResponse) jaxbUnmarshaller.unmarshal(stream);
			System.err.println("##############################"+anetApiResponse);
			System.err.println("getMessages().getResultCode()>>>"+anetApiResponse.getMessages().getResultCode());
	    	return anetApiResponse;
	    	
	    }
	


}
