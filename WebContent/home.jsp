<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <meta equiv="Content-Type" content="text/html; charset=TIS-620">

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
}
textarea {
   font-size: 80pt;
   font-family: Arial;
} 
 </style>

<!-- Start WOWSlider.com HEAD section -->
<link rel="stylesheet" type="text/css" href="engine1/style.css" />
<script type="text/javascript" src="engine1/jquery.js"></script>
<!-- End WOWSlider.com HEAD section -->

  <title>Identity-Home page</title>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/the-big-picture.css" rel="stylesheet">
<link href="css/half-slider.css" rel="stylesheet">


<!-- JS -->
 <script type="text/javascript" src="js/jquery.min.js"></script>
 <script type="text/javascript" src="js/bootstrap.min.js"></script>
 <script type="text/javascript" src="js/scripts.js"></script>
 <script src="js/form-validator/jquery.form-validator.min.js"></script>
 <script src="js/jquery.js"></script>
     <script src="js/bootstrap.min.js"></script>



</head>
<body>

	<!--NavBar-->
<nav class="navbar1 navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="./home.jsp">IDENTITY</a>
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





<!--Content-->

<div class="container well1">
<div class="jumbotron well1">

<!-- Start WOWSlider.com BODY section --> <!-- add to the <body> of your page -->
  <div id="wowslider-container1">
  <div class="ws_images"><ul>
    <li><img src="data1/images/screen_shot_25580322_at_10.35.52.png" alt="Picture1" title="Picture1" id="wows1_0"/></li>
    <li><a href="http://wowslider.com"><img src="data1/images/1a8efe1.jpg" alt="image carousel" title="Picture2" id="wows1_1"/></a></li>
    <li><img src="data1/images/final.jpg" alt="Picture3" title="Picture3" id="wows1_2"/></li>
  </ul></div>
  <div class="ws_bullets"><div>
    <a href="#" title="Picture1"><span><img src="data1/tooltips/screen_shot_25580322_at_10.35.52.png" alt="Picture1"/>1</span></a>
    <a href="#" title="Picture2"><span><img src="data1/tooltips/1a8efe1.jpg" alt="Picture2"/>2</span></a>
    <a href="#" title="Picture3"><span><img src="data1/tooltips/final.jpg" alt="Picture3"/>3</span></a>
  </div></div><div class="ws_script" style="position:absolute;left:-99%"><a href="http://wowslider.com/vi">javascript slider</a> by WOWSlider.com v7.7m</div>
  <div class="ws_shadow"></div>
  </div>  
  <script type="text/javascript" src="engine1/wowslider.js"></script>
  <script type="text/javascript" src="engine1/script.js"></script>
  <!-- End WOWSlider.com BODY section -->

  <h1>Welcome to IDENTITY</h1>
  <p>   เว็ปไซต์นี้ เป็นการรวบรวม ข้อมูลจากเว็ปไซต์บนอินเตอร์เน็ต เพื่อนำมาทำเป็นประวัติส่วนตัวของบุคคลนั้น ในรูปแบบที่เรียบง่าย และ สวยงาม
    </p>
  <p><a class="btn btn-primary btn-lg">Learn more</a></p>
</div>
</div>




<!--Navbar bottom-->
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
      </ul>
  </nav>

</body>
</html>