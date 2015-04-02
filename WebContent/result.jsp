<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.io.UnsupportedEncodingException" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.util.Map" %>
<%@ page import="org.apache.commons.*" %>


<jsp:directive.page import="org.jsoup.*" />
<jsp:directive.page import="org.jsoup.helper.*" />
<jsp:directive.page import="org.jsoup.nodes.*" />
<jsp:directive.page import="org.jsoup.select.*" />
<jsp:directive.page import="org.jsoup.nodes.*" />
<jsp:directive.page import="org.jsoup.safety.*" />

<%@ page import="java.io.*" %>
<%@ page import="java.lang.*" %>

<%!
	String escapeHtml(String source) {
	    Document doc = Jsoup.parseBodyFragment(source);
	    Elements elements = doc.select("b");
	    for (Element element : elements) {
	        element.replaceWith(new TextNode(element.toString(),""));
	    }
	    return Jsoup.clean(doc.body().toString(), new Whitelist().addTags("a").addAttributes("a", "href", "name", "rel", "target"));
	    }
    
  %>
  
<%! 
String strName;
String strName1;
Elements con1;
String url1;
%>

<html class="full" lang="en">
<head>
<meta charset="utf-8">
<style>
  @font-face { font-family: Sukhumvit; src: url('fonts/SukhumvitSet.ttc'); } 
  Sukhumvit {
    font-family: Sukhumvit
  }
  .well1 {
   background-color: rgba(245, 245, 245, 0.4);
     border-radius: 10px;

}
</style>

  <title>Identity</title>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/the-big-picture.css" rel="stylesheet">


<!-- JS -->
 <script type="text/javascript" src="js/jquery.min.js"></script>
 <script type="text/javascript" src="js/bootstrap.min.js"></script>
 <script type="text/javascript" src="js/scripts.js"></script>
 <script src="js/form-validator/jquery.form-validator.min.js"></script>
 <script src="js/jquery.js"></script>
 <script src="/waypoints/lib/noframework.waypoints.min.js"></script>
 


</head>
<body>

	<!--NavBar-->
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="home.jsp">IDENTITY</a>
    </div>

    <div class="navbar-collapse collapse" id="bs-example-navbar-collapse-2" aria-expanded="false" style="height: 1px;">
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left" role="search" name="frmAdd" method="post" action="result.jsp">
        <div class="form-group inner-addon left-addon">
        	<i class="glyphicon glyphicon-search"></i>
          <input type="text" class="form-control" name="searchname" placeholder="ชื่อจริง นามสกุล">
     	  <input type="text" class="form-control" name="searchname1" placeholder="Firstname Lastname">
        </div>
        <button type="submit" class="btn btn-default">Search</button>
      </form>
            <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Link</a></li>
      </ul>
    </div>
  </div>
</nav>

<!--Navbar -->
<div class="container well1">
		<!-- First Row -->
		<div class="bs-docs-section">

		        <div class="row">
		          <div class="col-lg-12">
		            <div class="page-header">
		              <h1 id="nav"><strong>
		              <!-- Code Java Execute -->
		              	<% 
		              	request.setCharacterEncoding("UTF-8");
		              	response.setContentType("text/html;charset=UTF-8");
		              		strName = request.getParameter("searchname");
		              		out.println(strName);
		              	%> </strong>ยินดีต้อนรับ</h1>
		            </div>
		          </div>
		        </div>
		        <div class="row">

		         <!-- Profile Picture -->
		         <div class="col-lg-4">
		         	<div class="well2 bs-component ">
		          		<form class="form-horizontal">
 						 <fieldset>
		            		<legend class="text-center">Profile Picture</legend>
				              <div class="form-group">
							      <a href="#" class="thumbnail">
							      	<%
							      	 int count1 = 0;
							      	 int countin;
							      		strName1 = request.getParameter("searchname1");
							      	 while(count1 <=1){
							      		countin = 0;
			    		        	  String google = "http://www.google.co.th/search?q=";
			    		        	  String userAgent = "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)";
			    		      			org.jsoup.select.Elements links = Jsoup.connect(google+strName1).userAgent(userAgent).ignoreHttpErrors(true).ignoreContentType(true).timeout(5000).get().select("li.g>h3>a");//URLEncoder.encode(search, charset)).userAgent(userAgent).get().select("li.g>h3>a");
			    		      			for (org.jsoup.nodes.Element link : links) {
			    		      				if(countin == 10) break;
			    		      				countin++;
			    		      				try{
			    		      				 
			    		      				   
			    		      				String title = link.text();
			    		      			    String url = link.absUrl("href"); // Google returns URLs in format "http://www.google.com/url?q=<url>&sa=U&ei=<someKey>".
			    		      			    url = URLDecoder.decode(url.substring(url.indexOf('=') + 1, url.indexOf('&')), "UTF-8");
										
			    		      			    if (!url.startsWith("http")) {
			    		      			        continue; // Ads/news/etc.
			    		      			    }
			    		      			    	//========================
			    		      			    	if(url.contains("facebook")){	
			    		      			    		if(!url.contains("public")){
					    		      				    if(title.toLowerCase().contains(strName1.toLowerCase())){
					    		      				    	//if(org.apache.commons.lang3.StringUtils.containsIgnoreCase(strName1, title)){
					    		      				    		
					    		      				    	//out.println(org.apache.commons.lang3.StringUtils.containsIgnoreCase(strName1, title));
					    		      				    	 url = url.substring(url.lastIndexOf("/")+1); 
					    		      				    	out.println(title + "<br>");
					    		      				    	//out.println(strName1 + "<br>");
					    		      				    		out.println(url);
					    		      				    	Document doc;
								    		        			// need http protocol
								    		        		//	doc = Jsoup.connect("http://fbpages.aspgodz.com/api/rest/pageslikedbyuserid/"+url).userAgent("Safari").timeout(0).get();
								    							//con1 = doc.select("body");
								    						   // out.println(con1.toString());
								    						   out.println("<img src=\"https://graph.facebook.com/"+url+"/picture?type=large\" alt=\"Generic placeholder thumbnail\" height=\"250\" width=\"250\">");
																url1 = url;
								    						   count1++;
								    						 //  out.println(count1);
								    						 //  out.println(countin);
								    						  break;
					    		      				    }
			    		      				    }    
			    		      			    }
			    		      			    
			    		      			    
			    		      			} catch (IOException e) {
			    		      				e.printStackTrace();
			    		      			}
			    		      					}
			    		      			strName1 = request.getParameter("searchname");
			    		      			count1++;
							      	 }
			    		      							      	%>
							      
							      
							      
							          
							         
							      </a>
							   </div>
								 <div class="caption center-block">
							         <h3 class="text-center">Photo Albums</h3>
							         
							         <p>
							            <a href="https://www.facebook.com/<% out.println(url1); %>/photos" class="btn btn-primary center-block" role="button">
							               See More
							            </a> 
							           </p>
							      </div>
						</fieldset>
					</form>
				</div>
		        </div>


		          <div class="col-lg-4">
		          	<div class="well21 bs-component">
		          		<form class="form-horizontal">
 						 <fieldset>
		            		<legend class="text-center">Contact info</legend>
		            			<div class="well31 bs-component">
			       				 <div class="form-group">
						    		 <div class="col-lg-12">
							    		 	<p>
										  
										  Blank
							      	</div>
							      </div>
							</div>
					    
						</form>
 					 </fieldset>
 				 </div>	
 				 <div class="well21 bs-component">
		          		<form class="form-horizontal">
 						 <fieldset>
		            		<legend class="text-center">Works/Acheivement</legend>
		            			<div class="well31 bs-component">
			       				 <div class="form-group">
						    		 <div class="col-lg-12">
							    		 	<p>
										  
										  Blank
							      	</div>
							      </div>
							</div>
					    
						</form>
 					 </fieldset>
 				 </div>	
				</div> 
		          <div class="col-lg-4">
		            	<div class="well2 bs-component">
		          		<form class="form-horizontal">
 						 <fieldset>
		            		<legend class="text-center">Interests</legend>
		       					<div class="well3 bs-component">
		       					 <div class="form-group">
					    		          <div class="col-lg-12">
										Blank

						      		</div>
								</div>
							</div>
					    
						</form>
 					 </fieldset>
 				 </div>		          </div>
		        </div>
		        <div class="row">
		          <div class="col-lg-12">
						
					    <div class="col-lg-6">
		            			<div class="well2 bs-component">
		          		<form class="form-horizontal">
 						 <fieldset>
		            		<legend class="text-center">News</legend>
		       					<div class="well3 bs-component">
		       					 <div class="form-group">
					    		          <div class="col-lg-12">
										<%
									 	request.setCharacterEncoding("UTF-8");
						              	response.setContentType("text/html;charset=UTF-8");
						              	String[] arr = strName.split(" ");
						              	String query1 = arr[0].trim();
						        		String query2 = arr[1].trim();
						        		String google1 = "http://www.google.co.th/search?q=";
						        		String search = "%22"+URLEncoder.encode(strName, "UTF-8")+"%22"+"&num=100";
						        		//out.println(search);
						        		String em="%22";
						        		String charset = "UTF-8";
						        		String userAgent1 = "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)";
						        		
						        		org.jsoup.select.Elements links1 = Jsoup.connect(google1+search).userAgent(userAgent1).ignoreHttpErrors(true).ignoreContentType(true).timeout(5000).get().select("li.g>h3>a");//URLEncoder.encode(search, charset)).userAgent(userAgent).get().select("li.g>h3>a");
//						        		
						        		int count = 1;
						        		
						        		for (org.jsoup.nodes.Element link : links1) {
						        			
						        			try{
						        			 
						        			   
						        			String title = link.text();
						        		    String url = link.absUrl("href"); // Google returns URLs in format "http://www.google.com/url?q=<url>&sa=U&ei=<someKey>".
						        		//   url = URLDecoder.decode(url.substring(url.indexOf('=') + 1, url.indexOf('&')), "UTF-8");

						        		    if (!url.startsWith("http")) {
						        		        continue; // Ads/news/etc.
						        		    }
						        		    	//========================
						        			    if(url.indexOf("tag") != -1){
						        			    }
						        			    else if(url.indexOf("search") != -1){
						        			    }	 else if(url.indexOf("facebook") != -1){
						        			    }else{
						        		          
						        		    
						        				    //----==================
						        			    	out.println("<br>");
						        				    out.println("Title: " + title);
						        				    out.println("URL: <a href=\""+url+"\" target=\"_blank\">Link"+count+" </a>");
						        				    count++;
						        		
						        					Document doc2 = Jsoup.connect(url).ignoreHttpErrors(true).ignoreContentType(true).timeout(0).get();
						        				 //   Elements con = doc2.select("p:contains(strName),span:contains(strName)");
						        				    Elements con = doc2.select("p:contains("+query1+" "+query2+"),span:contains("+query1+" "+query2+")");
						        					   
						        				 //   out.println("<p>"+escapeHtml(con.toString())+"</p> <hr>");
						        				    out.println("<p>"+escapeHtml(con.text())+"</p> <hr>");

						        				    
						        		    }
						        		    
						        		} catch (IOException e) {
						        			e.printStackTrace();
						        		}
						        				}
						        				count--;
						        				out.println(count);
						        						
										%>
										  	</div>
									</div>
					   		</div>
						</form>
 					 </fieldset>
 				 </div>
							
					    </div>	
					    <div class="col-lg-6">
		           			 	<div class="well2 bs-component">
				          		<form class="form-horizontal">
		 						 <fieldset>
				            		<legend class="text-center">Etc.</legend>
				       				 <div class="well3 bs-component">
				       					 <div class="form-group">
					    		        	  <div class="col-lg-12">
					    		        	  
					    		        	  <%
					    		        	  
					    		        	  %>
								      	</div>
									</div>
							  </div>  
						</form>
 					 </fieldset>
 				 </div>
					    </div>	

					</div>

		          </div>

	</div>
	
	Copy right by PurikuO
</div>
<nav class="navbar navbar-default navbar-bottom" role="navigation">
	    <!-- <nav class="navbar navbar-default navbar-bottom2" role="navigation"> -->
    <!-- fixed or non fixed -->
      <ul class="nav navbar-nav">
        <li>
          <a>
          </a>
        </li>
        <li>
          <a href="#">FAQ</a>
        </li>
        <li>
          <a href="#">About</a>
        </li>
        <li>
          <a href="report">Report</a>
        </li>
        <li>
          <a href="#">Privacy</a>
        </li>
        <li>
          <a href="#">Term of use</a>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right ">
        <li>
          <a href="#top">Back to top</a>
        </li>
        <li>
          <a></a>
        </li>
      </ul></nav>



</body>
</html>