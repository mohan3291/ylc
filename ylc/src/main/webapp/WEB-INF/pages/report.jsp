<%

response.setContentType("application/pdf");
response.setHeader("content-disposition","attachment; filename="+"Report.pdf");
//What ever u write inside this JSP file will be exported as pdf file when you send request and response to this page
%>

<h1>Hellow World</h1>