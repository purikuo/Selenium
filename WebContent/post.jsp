<html>
<head>
	<title>ThaiCreate.Com JSP Tutorial</title>
</head>
<body>
	
	<%	
		String strName = request.getParameter("txtName");
		String strEmail = request.getParameter("txtEmail");
		
		out.println("Name : " + strName);
		out.println("<br>");		
		out.println("Email : " + strEmail);
		out.println("<br>");	
		
		String strchkBox1 = request.getParameter("chkBox1");
		String strchkBox2 = request.getParameter("chkBox2");
		out.println("chkBox1 : " + strchkBox1);
		out.println("<br>");		
		out.println("chkBox2 : " + strchkBox2);
		out.println("<br>");	
		
		String strradioOption = request.getParameter("radioOption");
		out.println("radioOption : " + strradioOption);
		out.println("<br>");
		
		String strselItem = request.getParameter("selItem");		
		out.println("selItem : " + strselItem);
		out.println("<br>");
	%>
</body>
</html>
