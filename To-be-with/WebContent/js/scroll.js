$(document).ready( function() {		
        var jbOffset = $('header').offset();       
        $( window ).scroll( function() {
          if ( $( document ).scrollTop() > jbOffset.top ) {
        	  $('header').addClass( 'jbFixed' );            
          }
          else {
        	  $('header').removeClass( 'jbFixed' );
          }
        });
      } );

$(".site-menu js-clone-nav mx-auto d-none d-lg-block li a").click(function()
		{
			var section = $(this).attr("href");
			var scrollPosition = $(section).offset().top;
			alert(scrollPosition);
			$("body").animate({
		        scrollTop: scrollPosition
		  }, 500);
	
		}
		
)