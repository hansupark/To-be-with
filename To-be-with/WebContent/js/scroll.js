$( document ).ready( function() {		
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