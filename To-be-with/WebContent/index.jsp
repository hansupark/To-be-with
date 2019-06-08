<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "vo.*" %> <!-- /* 로그인 구현 완료시 다시 수정하기 */ -->
<%@ page import = "service.*" %>    
<%@ page import = "controller.HttpUtil" %>
<!DOCTYPE html>
<html>
<%
	HttpUtil.Login(request, response);
	int loginUserNum = (int) session.getAttribute("LoginUserNum");
	UserVo vo = new UserVo();
	vo.setUserNum(loginUserNum);
	vo = UserService.getInstance().selectUser_byUserNum(vo);	
%>
  <head>
    <title>Travalers &mdash; Colorlib Website Template</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,700,900|Display+Playfair:200,300,400,700"> 
    <link rel="stylesheet" href="fonts/icomoon/style.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/jquery-ui.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mediaelement@4.2.7/build/mediaelementplayer.min.css">
    <link rel="stylesheet" href="css/aos.css">
    <link rel="stylesheet" href="css/style.css">    
  </head>
  <body>
  
  <div class="site-wrap">
	<a href = "userLogout.do">로그아웃</a>
    <div class="site-mobile-menu">
      <div class="site-mobile-menu-header">
        <div class="site-mobile-menu-close mt-3">
          <span class="icon-close2 js-menu-toggle"></span>
        </div>
      </div>
      <div class="site-mobile-menu-body"></div>
    </div>
    
    <header class="site-navbar py-1" role="banner">

      <div class="container">
        <div class="row align-items-center">
          
          <div class="col-6 col-xl-2" >
            <h1 class="mb-0"><a href="index.jsp" class="text-black h2 mb-0">To Be With</a></h1> <!-- href에서 jsp로 -->
          </div>
          <div class="col-10 col-md-8 d-none d-xl-block">
            <nav class="site-navigation position-relative text-right text-lg-center" role="navigation">

              <ul class="site-menu js-clone-nav mx-auto d-none d-lg-block">                   
                <li><a href="#section0">Home</a></li>
                <li><a href="#section1">To be With</a></li>
                <li><a href="#section2">Services</a></li>
                <li><a href="#section3">Testimonial</a></li>
                <li><a href="#section4">About us</a></li>              
                <!-- <li><a href="booking.html">Book Online</a></li> -->
              </ul>
            </nav>
          </div>

          <div class="col-6 col-xl-2 text-right">
            <div class="d-none d-xl-inline-block">
              <ul class="site-menu js-clone-nav ml-auto list-unstyled d-flex text-right mb-0" data-class="social">
                <li>
                  <a href="#" class="pl-0 pr-3 text-black"><span class="icon-tripadvisor"></span></a>
                </li>
                <li>
                  <a href="profile.jsp" class="pl-3 pr-3 text-black"><%=vo.getName()%></a>
                </li>                
                
              </ul>
            </div>

            <div class="d-inline-block d-xl-none ml-md-0 mr-auto py-3" style="position: relative; top: 3px;"><a href="#" class="site-menu-toggle js-menu-toggle text-black"><span class="icon-menu h3"></span></a></div>

          </div>

        </div>
      </div>
      
    </header>

    <div class="slide-one-item home-slider owl-carousel" id = "section0">
      
      <div class="site-blocks-cover overlay" style="background-image: url(images/hero_bg_1.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">
        <div class="container">
          <div class="row align-items-center justify-content-center text-center">

            <div class="col-md-8" data-aos="fade-up" data-aos-delay="400">
              
              <h1 class="text-white font-weight-light">MAKE YOUR OWN SPECIAL TRAVEL EXPERIENCE.</h1>
              <p class="mb-5">To-Be-With와 함께 당신만의 특별한 여행경험을 만들고, 다같이 공유 해보세요!</p>
              <p><a href="#" class="btn btn-primary py-3 px-5 text-white">To Be With!</a></p>

            </div>
          </div>
        </div>
      </div>  

      <div class="site-blocks-cover overlay" style="background-image: url(images/hero_bg_2.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">
        <div class="container">
          <div class="row align-items-center justify-content-center text-center">

            <div class="col-md-8" data-aos="fade-up" data-aos-delay="400">
              <h1 class="text-white font-weight-light">FIND ACCOMPANY TO TRAVEL WITH YOU</h1>
              <p class="mb-5">To-Be-With와 함께, 여행을 같이할 동료를 구해보세요!</p>
              <p><a href="#" class="btn btn-primary py-3 px-5 text-white">To Be With!</a></p>
            </div>
          </div>
        </div>
      </div>
      
      <div class="site-blocks-cover overlay" style="background-image: url(images/hero_bg_3.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">
        <div class="container">
          <div class="row align-items-center justify-content-center text-center">

            <div class="col-md-8" data-aos="fade-up" data-aos-delay="400">
              <h1 class="text-white font-weight-light">Travel Information</h1>
              <p class="mb-5">To-Be-With가 여행정보를 드립니다!</p>
              <p><a href="#" class="btn btn-primary py-3 px-5 text-white">To Be With!</a></p>
            </div>
          </div>
        </div>
      </div>    

    </div>


    <div class="site-section">
      
      <div class="container overlap-section">
        <div class="row" id = "section1">
          <div class="col-md-6 col-lg-4 mb-4 mb-lg-0">
            <a href="#" class="unit-1 text-center">
              <img src="images/img_2.jpg" alt="Image" class="img-fluid">
              <div class="unit-1-text">
                <h3 class="unit-1-heading">Write Down Your Experience</h3>
              </div>
            </a>
          </div>
          <div class="col-md-6 col-lg-4 mb-4 mb-lg-0">
            <a href="search.jsp" class="unit-1 text-center">
              <img src="images/img_1.jpg" alt="Image" class="img-fluid">
              <div class="unit-1-text">
                <h3 class="unit-1-heading">Find Your Travel Partners</h3>
              </div>
            </a>
          </div>
          
          <div class="col-md-6 col-lg-4 mb-4 mb-lg-0">
            <a href="abouttravel.html" class="unit-1 text-center"> 
              <img src="images/img_3.jpg" alt="Image" class="img-fluid">
              <div class="unit-1-text">
                <h3 class="unit-1-heading">Travel Information</h3>
              </div>
            </a>
          </div>                   
        </div>
      </div>
    
    </div>


    <div class="site-section" id = "section2">
      <div class="container">
      	<div class="row justify-content-center mb-5">
          <div class="col-md-7">
            <h2 class="font-weight-light text-black text-center">Services</h2>
          </div>
        </div>
        <div class="row align-items-stretch">
          <div class="col-md-6 col-lg-4 mb-4 mb-lg-0">
            <div class="unit-4 d-flex">
              <div class="unit-4-icon mr-4"><span class="text-primary flaticon-airplane"></span></div>
              <div>
                <h3>Travel Experience Share</h3>
                <p>당신의 여행을 공유해보세요. 그리고 다른 사람들의 여행을 읽어보세요.</p>
                <p><a href="#">Learn More</a></p>
              </div>
            </div>
          </div>
          <div class="col-md-6 col-lg-4 mb-4 mb-lg-0">
            <div class="unit-4 d-flex">
              <div class="unit-4-icon mr-4"><span class="text-primary flaticon-ship"></span></div>
              <div>
                <h3>Travel Partners Search</h3>
                <p>같이 여행할 동료를 구해보세요. 당신의 여행을 더 즐겁게 만들어요.</p>
                <p><a href="#">Learn More</a></p>
              </div>
            </div>
          </div>
          <div class="col-md-6 col-lg-4 mb-4 mb-lg-0">
            <div class="unit-4 d-flex">
              <div class="unit-4-icon mr-4"><span class="text-primary flaticon-ship"></span></div>
              <div>
                <h3>Another Additional Functions</h3>
                <p>다른 기능들도 사용해보세요. 다양한 기능들이 여러분의 여행을 책임집니다.</p>
                <p><a href="#">Learn More</a></p>
              </div>
            </div>
          </div>           
        </div>
      </div>
    </div>
	
	<div class="site-section" id = "section3">
      <div class="container">
        <div class="row justify-content-center mb-5">
          <div class="col-md-7 text-center">
            <h2 class="font-weight-light text-black">Testiomals</h2>
            <p class="color-black-opacity-5">See Our Daily News &amp; Updates</p>
          </div>
        </div>
        <div class="row mb-3 align-items-stretch">
          <div class="col-md-6 col-lg-6 mb-4 mb-lg-4">
            <div class="h-entry">
              <img src="images/hero_bg_1.jpg" alt="Image" class="img-fluid">
              <h2 class="font-size-regular"><a href="#">How to Plan Your Vacation</a></h2>
              <div class="meta mb-4">by Theresa Winston <span class="mx-2">&bullet;</span> Jan 18, 2019 at 2:00 pm <span class="mx-2">&bullet;</span> <a href="#">News</a></div>
              <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus eligendi nobis ea maiores sapiente veritatis reprehenderit suscipit quaerat rerum voluptatibus a eius.</p>
            </div> 
          </div>
          <div class="col-md-6 col-lg-6 mb-4 mb-lg-4">
            <div class="h-entry">
              <img src="images/hero_bg_2.jpg" alt="Image" class="img-fluid">
              <h2 class="font-size-regular"><a href="#">How to Plan Your Vacation</a></h2>
              <div class="meta mb-4">by Theresa Winston <span class="mx-2">&bullet;</span> Jan 18, 2019 at 2:00 pm <span class="mx-2">&bullet;</span> <a href="#">News</a></div>
              <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus eligendi nobis ea maiores sapiente veritatis reprehenderit suscipit quaerat rerum voluptatibus a eius.</p>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-12 text-center">
            <a href="#" class="btn btn-outline-primary border-2 py-3 px-5">View All Blog Posts</a>
          </div>
        </div>
      </div>
    </div>
    
    <div class="site-section block-13 bg-light" id = "section4">

    <div class="container">
   	
        <div class="row justify-content-center mb-5">
          <div class="col-md-7">
            <h2 class="font-weight-light text-black text-center">About us</h2>
          </div>
        </div>

        <div class="nonloop-block-13 owl-carousel">

          <div class="item">
            <div class="container">
              <div class="row">
                <div class="col-lg-6 mb-5">
                  <img src="images/img_1.jpg" alt="Image" class="img-md-fluid">
                </div>
                <div class="overlap-left col-lg-6 bg-white p-md-5 align-self-center">
                  <p class="text-black lead">&ldquo;2017038098 소프트웨어학과 박한수 &rdquo;</p>
                  <p class="">&mdash; <em>박한수</em>, <a href="#">Developer</a></p>
                </div>
              </div>
            </div>
          </div>

          <div class="item">
            <div class="container">
              <div class="row">
                <div class="col-lg-6 mb-5">
                  <img src="images/img_2.jpg" alt="Image" class="img-md-fluid">
                </div>
                <div class="overlap-left col-lg-6 bg-white p-md-5 align-self-center">
                  <p class="text-black lead">&ldquo;2017038106 소프트웨어학과 권용균 &rdquo;</p>
                  <p class="">&mdash; <em>권용균</em>, <a href="#">Developer</a></p>
                </div>
              </div>
            </div>
          </div>

          <div class="item">
            <div class="container">
              <div class="row">
                <div class="col-lg-6 mb-5">
                  <img src="images/img_4.jpg" alt="Image" class="img-md-fluid">
                </div>
                <div class="overlap-left col-lg-6 bg-white p-md-5 align-self-center">
                  <p class="text-black lead">&ldquo;2016039011 소프트웨어학과 홍주미 &rdquo;</p>
                  <p class="">&mdash; <em>홍주미</em>, <a href="#">Developer</a></p>
                </div>
              </div>
            </div>
          </div>

        </div>
      </div>
    </div>
    
    <footer class="site-footer">
      <div class="container">
        <div class="row">
          
          
          
          
        </div>
        
      </div>
    </footer>
  </div>

  <script src="js/jquery-3.3.1.min.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/jquery.countdown.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/bootstrap-datepicker.min.js"></script>
  <script src="js/aos.js"></script>
  <script src="js/main.js"></script>
  <script src="js/slick.min.js"></script>
  <script src="js/scroll.js"></script>
    
  </body>
</html>
