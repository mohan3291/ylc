'use strict';

/**
 * CarController
 * @constructor
 */
var guestPayCtrl = function($scope, $http,$location) {
	
	$scope.fetchDashboardData = function() {
		alert("Suresh");
		/*
		$scope.tabCounter=1;
	//	alert( $('.myMenuList li').length);
		
		//$scope.button-previous.hide();
		 $('#form_wizard_1').find('.button-previous').hide();
		 $('#form_wizard_1').find('.button-submit').hide();
		 $('.help-block-fname').hide();
		 $('.help-block-lname').hide();
		 $('.help-block-bop').hide();
		$('.myMenuList li:nth-child(1)').addClass('active');
		 $('#form_wizard_1').find('.progress-bar').css({width: '20%'});
		$scope.showtab1=true;
		$scope.showtab11=false;
		$scope.showtab2=false;
		$scope.showtab3=false;
		$scope.errortab3=false;
		$scope.showtab4=false;
		$scope.showtab5=false;
		$http.get('quickpay/paymetDetails').success(function(pd){
        	$scope.paymentDetails = pd;
        });
		
	*/}
	$scope.savePayment = function(paymentDetails) {
		 $http.post('quickpay/savePaymetDetails', paymentDetails).success(function(pd){
			$scope.paymentDetails = pd;
       });
	}
	$scope.continuePayTab1=function(paymentDetails){
		alert("Suresh");
			$scope.showtab1=false;
			$scope.showtab11=false;
			$scope.showtab2=false;
			$scope.showtab3=false;
			$scope.errortab3=false;
			$scope.showtab4=false;
			$scope.showtab5=false;
			 $http.post('quickpay/getInMate', paymentDetails).success(function(inmates){
		        if(inmates.length==0){
		        	 $scope.showtab11=true;
		         }
		         else{
		        	 $scope.showtab2=true;
		        	 $scope.inmatesList=inmates;
		        	 $('#form_wizard_1').find('.progress-bar').css({
		                 width: '40%'
		             });
		        	 $('.myMenuList li:nth-child(2)').addClass('active');
		        	 $('.myMenuList li:nth-child(1)').addClass('done');
		         }
		       });
			}
	
	$scope.change=function(){
		//alert("change()");
	
	}
	
	$scope.addInmate=function(paymentDetails){
		$scope.showtab1=false;
		$scope.showtab11=false;
		$scope.showtab2=false;
		$scope.showtab3=false;
		$scope.errortab3=false;
		$scope.showtab4=false;
		$scope.showtab5=false;
		 $http.post('quickpay/saveInMate', paymentDetails).success(function(inmates){
	         if(inmates.length==0){
	        	 $scope.showtab11=true;
         }
	         else{
	        	 $scope.showtab2=true;
	        	 $scope.inmatesList=inmates;
	         }
	       });
	}
	$scope.continuePayTab2=function(selectBox){
		 $('#form_wizard_1').find('.progress-bar').css({
             width: '60%'
         });
    	 $('.myMenuList li:nth-child(3)').addClass('active');
    	 $('.myMenuList li:nth-child(2)').addClass('done');
		//alert(selectBox);
		$scope.showtab1=false;
		$scope.showtab11=false;
		$scope.showtab2=false;
		$scope.showtab3=true;
		$scope.errortab3=false;
		$scope.showtab4=false;
		$scope.showtab5=false;
	}
	
	

	$scope.backTab2=function(){
		 $('#form_wizard_1').find('.progress-bar').css({
            width: '20%'
        });
		 $('.myMenuList li:nth-child(1)').removeClass('done');
		 $('.myMenuList li:nth-child(2)').removeClass('active');
		 $('.myMenuList li:nth-child(1)').addClass('active');
		 
		$scope.showtab1=true;
		$scope.showtab11=false;
		$scope.showtab2=false;
		$scope.showtab3=false;
		$scope.showtab4=false;
		$scope.showtab5=false;
	}
	
	$scope.backTab3=function(){
		 $('#form_wizard_1').find('.progress-bar').css({
             width: '40%'
         });
    	 $('.myMenuList li:nth-child(2)').addClass('active');
    	 $('.myMenuList li:nth-child(3)').removeClass('active');
		$scope.showtab1=false;
		$scope.showtab11=false;
		$scope.showtab2=true;
		$scope.showtab3=false;
		$scope.showtab4=false;
		$scope.showtab5=false;
	}
	
	$scope.continuePayTab3=function(){
		//alert($scope.paymentDetails.amount);
		
		if(($scope.paymentDetails.amount!=null)){
			//alert($scope.paymentDetails.amount);
		 $('#form_wizard_1').find('.progress-bar').css({
             width: '80%'
         });
    	 $('.myMenuList li:nth-child(4)').addClass('active');
    	 $('.myMenuList li:nth-child(3)').addClass('done');
	
    	 $scope.showtab1=false;
		$scope.showtab11=false;
		$scope.showtab2=false;
		$scope.showtab3=false;
		$scope.showtab4=true;
		$scope.showtab5=false;
		}else{
			alert("No pay");
			$scope.errortab3=true;
			$scope.showtab3=true;
		}
			
	}
	$scope.backTab4=function(){
		 $('#form_wizard_1').find('.progress-bar').css({width: '60%'});
		 $('.myMenuList li:nth-child(3)').removeClass('done');
		 $('.myMenuList li:nth-child(3)').addClass('active');
    	 $('.myMenuList li:nth-child(4)').removeClass('active');
		$scope.showtab1=false;
		$scope.showtab11=false;
		
		$scope.errortab3=false;
		$scope.showtab2=false;
		$scope.showtab3=true;
		$scope.showtab4=false;
		$scope.showtab5=false;
		
	}
	$scope.continuePayTab4=function(){
		 $('#form_wizard_1').find('.progress-bar').css({width: '100%'});
    	 $('.myMenuList li:nth-child(5)').addClass('active');
    	 $('.myMenuList li:nth-child(4)').addClass('done');
		
		$scope.showtab1=false;
		$scope.showtab2=false;
		$scope.showtab3=false;
		$scope.showtab4=false;
		$scope.showtab5=true;
		
	}
	$scope.backTab5=function(){
		$scope.showtab1=false;
		$scope.showtab2=false;
		$scope.showtab3=false;
		$scope.showtab4=true;
		$scope.showtab5=false;
		
	}
	
	$scope.submitPayment=function(paymentDetails){
		$scope.showtab1=false;
		$scope.showtab11=false;
		$scope.showtab2=false;
		$scope.showtab3=false;
		$scope.showtab4=false;
		$scope.showtab5=true;
		 $http.post('quickpay/submitPayment', paymentDetails).success(function(data){
	      //  alert(data);
	       });
		 $location.path("/dashboard");
	}

	$scope.fetchDashboardData();
};