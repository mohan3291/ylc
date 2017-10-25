package com.ylc.util;

import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlUtils {
	
	/*public static String getAssignNumeReqXml(String numberPeerRequest,String userName,String password){
		try{
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("PEER");
		doc.appendChild(rootElement);
		Attr rootattr = doc.createAttribute("xmlns");
		rootattr.setValue("http://peer.382com.com");
		rootElement.setAttributeNode(rootattr);
		rootattr = doc.createAttribute("xmlns:xsi");
		rootattr.setValue("http://www.w3.org/2001/XMLSchema-instance");
		rootElement.setAttributeNode(rootattr);
		rootattr = doc.createAttribute("xsi:schemaLocation");
		rootattr.setValue("http://peer.382com.com ASSIGNNUM.xsd");
		rootElement.setAttributeNode(rootattr);		

		// HDR elements
		Element hdr = doc.createElement("HDR");
		rootElement.appendChild(hdr);
	
		Element user = doc.createElement("User");
		user.appendChild(doc.createTextNode(userName));
		hdr.appendChild(user);
		
		Element pass = doc.createElement("Pass");
		pass.appendChild(doc.createTextNode(password));
		hdr.appendChild(pass);

		
		Element payload = doc.createElement("Payload");
		rootElement.appendChild(payload);
		
		Element reqType = doc.createElement("REQTYPE");
	//	reqType.appendChild(doc.createTextNode(numberPeerRequest.getReqType()));			
		payload.appendChild(reqType);
		
		Element Assign = doc.createElement("Assign");					
		payload.appendChild(Assign);
		
		Element CPN = doc.createElement("CPN");	
	//	CPN.appendChild(doc.createTextNode(numberPeerRequest.getCpn()));	
		Assign.appendChild(CPN);
		
		Element FORWARD = doc.createElement("FORWARD");	
	//	FORWARD.appendChild(doc.createTextNode(numberPeerRequest.getForward()));	
		Assign.appendChild(FORWARD);	
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		String output =new String();
		StreamResult result = new StreamResult(new StringWriter());	
		transformer.transform(source, result);
		System.err.println("Request"+result.getWriter().toString());
		return result.getWriter().toString();
	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
		return null;
	}
	
	public static String getAssignNumeResponse(String respXml){
		return null;
	}
	
	public static String getChargeACreditCardXml(){
		try{
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("createTransactionRequest");
		doc.appendChild(rootElement);
		Attr rootattr = doc.createAttribute("xmlns");
		rootattr.setValue("AnetApi/xml/v1/schema/AnetApiSchema.xsd");
		rootElement.setAttributeNode(rootattr);
			

		// merchantAuthentication elements
		Element merchantAuthentication = doc.createElement("merchantAuthentication");
		rootElement.appendChild(merchantAuthentication);
	
		Element name = doc.createElement("name");
		name.appendChild(doc.createTextNode("gautebirkeli76"));
		merchantAuthentication.appendChild(name);
		
		Element transactionKey = doc.createElement("transactionKey");
		transactionKey.appendChild(doc.createTextNode("Aezion76"));
		merchantAuthentication.appendChild(transactionKey);

		
		Element refId = doc.createElement("refId");
		refId.appendChild(doc.createTextNode("123456"));
		rootElement.appendChild(refId);
		
		//transactionRequest
		Element transactionRequest = doc.createElement("transactionRequest");	
		rootElement.appendChild(transactionRequest);
	
		
		Element transactionType = doc.createElement("transactionType");		
		transactionType.appendChild(doc.createTextNode("authCaptureTransaction"));
		transactionRequest.appendChild(transactionType);
		
		Element amount = doc.createElement("amount");		
		amount.appendChild(doc.createTextNode("5"));
		transactionRequest.appendChild(amount);
		
		Element payment = doc.createElement("payment");	
		transactionRequest.appendChild(payment);
		
		Element creditCard = doc.createElement("creditCard");	
		payment.appendChild(creditCard);
		
		Element cardNumber = doc.createElement("cardNumber");		
		cardNumber.appendChild(doc.createTextNode("5424000000000015"));
		creditCard.appendChild(cardNumber);
		
		Element expirationDate = doc.createElement("expirationDate");		
		expirationDate.appendChild(doc.createTextNode("1220"));
		creditCard.appendChild(expirationDate);
		
		Element cardCode = doc.createElement("cardCode");		
		cardCode.appendChild(doc.createTextNode("999"));
		creditCard.appendChild(cardCode);
		
		
		Element order = doc.createElement("order");	
		transactionRequest.appendChild(order);
		
	
		Element invoiceNumber = doc.createElement("invoiceNumber");		
		invoiceNumber.appendChild(doc.createTextNode("INV-12345"));
		order.appendChild(invoiceNumber);
		
		Element description = doc.createElement("description");		
		description.appendChild(doc.createTextNode("Product Description"));
		order.appendChild(description);
		
		Element lineItems = doc.createElement("lineItems");	
		transactionRequest.appendChild(lineItems);
		
		Element lineItem = doc.createElement("lineItem");	
		lineItems.appendChild(lineItem);
		
	
		Element itemId = doc.createElement("itemId");		
		itemId.appendChild(doc.createTextNode("1"));
		lineItem.appendChild(itemId);
		
		Element linename = doc.createElement("name");		
		linename.appendChild(doc.createTextNode("vase"));
		lineItem.appendChild(linename);
		
		Element linedescription = doc.createElement("description");		
		linedescription.appendChild(doc.createTextNode("Cannes logo"));
		lineItem.appendChild(linedescription);
		
		Element quantity = doc.createElement("quantity");		
		quantity.appendChild(doc.createTextNode("18"));
		lineItem.appendChild(quantity);
		
		Element unitPrice = doc.createElement("unitPrice");		
		unitPrice.appendChild(doc.createTextNode("45.00"));
		lineItem.appendChild(unitPrice);
		
		Element tax = doc.createElement("tax");	
		transactionRequest.appendChild(tax);	
		
	
		Element taxAmount = doc.createElement("amount");		
		taxAmount.appendChild(doc.createTextNode("4.26"));
		tax.appendChild(taxAmount);
		
		Element taxName = doc.createElement("name");		
		taxName.appendChild(doc.createTextNode("level2 tax name"));
		tax.appendChild(taxName);
		
		Element taxDescription = doc.createElement("description");		
		taxDescription.appendChild(doc.createTextNode("duty description"));
		tax.appendChild(taxDescription);
		
		
		Element duty = doc.createElement("duty");	
		transactionRequest.appendChild(duty);	
		
	
		Element dutyAmount = doc.createElement("amount");		
		dutyAmount.appendChild(doc.createTextNode("8.55"));
		duty.appendChild(dutyAmount);
		
		Element dutyName = doc.createElement("name");		
		dutyName.appendChild(doc.createTextNode("duty name"));
		duty.appendChild(dutyName);
		
		Element dutyDescription = doc.createElement("description");		
		dutyDescription.appendChild(doc.createTextNode("duty description"));
		duty.appendChild(dutyDescription);
		
		Element shipping = doc.createElement("shipping");	
		transactionRequest.appendChild(shipping);	
		
	
		Element shippingAmount = doc.createElement("amount");		
		shippingAmount.appendChild(doc.createTextNode("4.26"));
		shipping.appendChild(shippingAmount);
		
		Element shippingName = doc.createElement("name");		
		shippingName.appendChild(doc.createTextNode("level2 tax name"));
		shipping.appendChild(shippingName);
		
		Element shippingDescription = doc.createElement("description");		
		shippingDescription.appendChild(doc.createTextNode("level2 tax"));
		shipping.appendChild(shippingDescription);
		
		Element poNumber = doc.createElement("poNumber");		
		poNumber.appendChild(doc.createTextNode("456654"));
		transactionRequest.appendChild(poNumber);
		
		Element customer = doc.createElement("customer");	
		transactionRequest.appendChild(customer);	
		
		Element id = doc.createElement("id");		
		id.appendChild(doc.createTextNode("99999456654"));
		customer.appendChild(id);
		
		Element billTo = doc.createElement("billTo");	
		transactionRequest.appendChild(billTo);	
		
	
		Element firstName = doc.createElement("firstName");		
		firstName.appendChild(doc.createTextNode("Ellen"));
		billTo.appendChild(firstName);
		
		Element lastName = doc.createElement("lastName");		
		lastName.appendChild(doc.createTextNode("xxxx"));
		billTo.appendChild(lastName);
		
		Element company = doc.createElement("company");		
		company.appendChild(doc.createTextNode("company"));
		billTo.appendChild(company);
		
		Element address = doc.createElement("address");		
		address.appendChild(doc.createTextNode("address"));
		billTo.appendChild(address);
		
		Element city = doc.createElement("city");		
		city.appendChild(doc.createTextNode("city"));
		billTo.appendChild(city);
		
		Element state = doc.createElement("state");		
		state.appendChild(doc.createTextNode("state"));
		billTo.appendChild(state);
		
		Element zip = doc.createElement("zip");		
		zip.appendChild(doc.createTextNode("zip"));
		billTo.appendChild(zip);
		
		Element country = doc.createElement("country");		
		country.appendChild(doc.createTextNode("country"));
		billTo.appendChild(country);
		
		
		Element shipTo = doc.createElement("shipTo");	
		transactionRequest.appendChild(shipTo);	
		
	
		Element shipTofirstName = doc.createElement("firstName");		
		shipTofirstName.appendChild(doc.createTextNode("Ellen"));
		shipTo.appendChild(shipTofirstName);
		
		Element shipTolastName = doc.createElement("lastName");		
		shipTolastName.appendChild(doc.createTextNode("xxxx"));
		shipTo.appendChild(shipTolastName);
		
		Element shipTocompany = doc.createElement("company");		
		shipTocompany.appendChild(doc.createTextNode("company"));
		shipTo.appendChild(shipTocompany);
		
		Element shipToaddress = doc.createElement("address");		
		shipToaddress.appendChild(doc.createTextNode("address"));
		shipTo.appendChild(shipToaddress);
		
		Element shipTocity = doc.createElement("city");		
		shipTocity.appendChild(doc.createTextNode("city"));
		shipTo.appendChild(shipTocity);
		
		Element shipTostate = doc.createElement("state");		
		shipTostate.appendChild(doc.createTextNode("state"));
		shipTo.appendChild(shipTostate);
		
		Element shipTozip = doc.createElement("zip");		
		shipTozip.appendChild(doc.createTextNode("zip"));
		shipTo.appendChild(shipTozip);
		
		Element shipTocountry = doc.createElement("country");		
		shipTocountry.appendChild(doc.createTextNode("country"));
		shipTo.appendChild(shipTocountry);
		
		Element customerIP = doc.createElement("customerIP");	
		customerIP.appendChild(doc.createTextNode("192.168.1.1"));
		transactionRequest.appendChild(customerIP);	
		
		
		// Uncomment this section for Card Present Sandbox Accounts
		// <retail><marketType>2</marketType><deviceType>1</deviceType></retail>
		
		
		Element transactionSettings = doc.createElement("transactionSettings");	
		transactionRequest.appendChild(transactionSettings);
		
		Element setting = doc.createElement("setting");	
		transactionSettings.appendChild(setting);
		
	
		Element settingName = doc.createElement("settingName");		
		settingName.appendChild(doc.createTextNode("settingName"));
		setting.appendChild(settingName);
		
		Element settingValue = doc.createElement("settingValue");		
		settingValue.appendChild(doc.createTextNode("settingValue"));
		setting.appendChild(settingValue);
		
		
		Element userFields = doc.createElement("userFields");	
		transactionRequest.appendChild(userFields);
		
		Element userField = doc.createElement("userField");	
		userFields.appendChild(userField);
		
		Element userFieldname = doc.createElement("name");		
		userFieldname.appendChild(doc.createTextNode("MerchantDefinedFieldName1"));
		userField.appendChild(userFieldname);
		
		Element userFieldvalue = doc.createElement("value");		
		userFieldvalue.appendChild(doc.createTextNode("userFieldvalue"));
		userField.appendChild(userFieldvalue);
		
		
		Element userField1 = doc.createElement("userField");	
		userFields.appendChild(userField1);
		
		Element userFieldname1 = doc.createElement("name");		
		userFieldname1.appendChild(doc.createTextNode("MerchantDefinedFieldName1"));
		userField1.appendChild(userFieldname1);
		
		Element userFieldvalue1 = doc.createElement("value");		
		userFieldvalue1.appendChild(doc.createTextNode("userFieldvalue"));
		userField1.appendChild(userFieldvalue1);	
		
	
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		String output =new String();
		StreamResult result = new StreamResult(new StringWriter());	
		transformer.transform(source, result);
		String reqXmL=result.getWriter().toString();
		//reqXmL=reqXmL.substring(54, reqXmL.length());
		//System.err.println("xmlStr"+xmlStr);
		System.err.println("Request"+reqXmL);
		
		return reqXmL;
	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
		return null;
	}

*/
}
