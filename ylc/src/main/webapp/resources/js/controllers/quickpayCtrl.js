'use strict';

/**
 * CarController
 * @constructor
 */
var quickpayCtrl = function($scope, $http,$location) {
	
	$( ".account" ).removeClass( "active" );
	$( ".dashboard" ).removeClass( "active" );
	$( ".invoice" ).removeClass( "active" );
	$( ".numbers" ).removeClass( "active" );
	$( ".call" ).removeClass( "active" );
	$( ".quickpay" ).addClass( "active" );
	$( ".aselect" ).removeClass( "selected" );
	$( ".dselect" ).removeClass( "selected" );
	$( ".iselect" ).removeClass( "selected" );
	$( ".nselect" ).removeClass( "selected" );
	$( ".cselect" ).removeClass( "selected" );
	$( ".qselect" ).addClass( "selected" );
	
	$scope.onlyNumbers = /^\d+$/;
	$scope.fetchDashboardData = function() {
		$scope.tabCounter=1;
	//	alert( $('.myMenuList li').length);
		
		//$scope.button-previous.hide();
		 /*$('#form_wizard_1').find('.button-previous').hide();
		 $('#form_wizard_1').find('.button-submit').hide();*/
		 /*$('.help-block-fname').hide();
		 $('.help-block-lname').hide();
		 $('.help-block-bop').hide();*/
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
        	$http.get('account/getStates').success(function(states){
        		$scope.stateList = states;	
        		for(var var1 in states){
        			if(states[var1].stateID===$scope.paymentDetails.stateID){
        				$scope.aState=states[var1];
        				$scope.paymentDetails.stateID=states[var1].stateID
        				break;
        			}
        		}
        	});
        	$http.get('managelines/getFacilities?facId=All').success(function(facilities){
    			$scope.facilityLocs = facilities;
    	    });
         	
         	$http.get('account/getCountry').success(function(country){
        			$scope.countryList = country;
        			//alert($scope.accountDetails.countryID);
        			for(var var1 in country){
            			if(country[var1].countryID===$scope.paymentDetails.countryID){
            				$scope.acountry=country[var1];
            				$scope.paymentDetails.countryID=country[var1].countryID
            				break;
            			}
        			}
        	});
        });
		/*$http.get('account/getStates').success(function(states){
			
			$scope.stateList = states;	
			for(var var1 in states){
				alert(states[var1].stateName);
				alert(accountDetails.stateID);
				if(states[var1].stateID===accountDetails.stateID){
					break;
				}
			}
			
			$scope.aState=states[1];
			     });*/
		/*$http.get('account/getCountry').success(function(country){
			//	alert(states);     	
				$scope.countryList = country;
				$scope.acountry=country[1];
				 });*/
		
	}
	$scope.savePayment = function(paymentDetails) {
		 $http.post('quickpay/savePaymetDetails', paymentDetails).success(function(paymentRes){
			 //$scope.paymentDetails = pd;
			$scope.showtab1=false;
			$scope.showtab2=false;
			$scope.showtab3=false;
	
			if(paymentRes.statusCode==='0'){
					//("reddy");
					 $scope.orderConfMessgae=paymentRes.statusMessage;
					 $('#form_wizard_1').find('.progress-bar').css({width: '100%'});
					 $scope.showtab5=false;
					 $scope.showtab4=false;
					 $scope.showCompleteTab=true;
					 $('.myMenuList li:nth-child(4)').addClass('done');
			    	 $('.myMenuList li:nth-child(5)').addClass('done');
					 
					 
				 }
				 else{
					 alert(paymentRes.statusMessage);
					 $('#form_wizard_1').find('.progress-bar').css({
			             width: '80%'
			         });
			    	 $('.myMenuList li:nth-child(4)').addClass('active');
			    	 $('.myMenuList li:nth-child(3)').addClass('done');
					 
					 $scope.showtab4=true;
					 $scope.showtab5=false;
	   			   
					 
				 }
       });
	}
	$scope.continuePayTab1=function(paymentDetails){
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
		        	// $rootScope.setData(inmates);
		        	 $scope.showtab2=true;
		        	 $scope.inmatesList=inmates;
		        	 $('#form_wizard_1').find('.progress-bar').css({width: '40%'});
		        	 $('.myMenuList li:nth-child(2)').addClass('active');
		        	 $('.myMenuList li:nth-child(1)').addClass('done');
		         }
		       });
			}
	
	$scope.change=function(){
		//alert("change()");
	
	}
	$scope.selectFac=function(facilityLocation){
		$scope.paymentDetails.inmateFacility=facilityLocation.facilityID;
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
	        	 $http.get('managelines/getFacilities?facId='+$scope.paymentDetails.inmateFacility).success(function(facilities){
		     			$scope.facilityLocs = facilities;
		     	    });
	        	 $scope.showtab2=true;
	        	 $scope.inmatesList=inmates;
	        	 $('.myMenuList li:nth-child(1)').addClass('done');
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
		$scope.paymentDetails.bop=$scope.selectedInMateIds.toString();
		//alert($scope.selectedInMateIds.toString());
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
		$http.get('account/getPaymentProfile').success(function(paymentDetail){
			//	alert(states);     	
				$scope.paymentProfileDetails = paymentDetail;
				 });
		if(($scope.paymentDetails.amount!=null)){
			//alert($scope.paymentDetails.amount);
		 $('#form_wizard_1').find('.progress-bar').css({
             width: '80%'
         });
    	 $('.myMenuList li:nth-child(4)').addClass('active');
    	 $('.myMenuList li:nth-child(3)').addClass('done');
	$scope.paymentProfile=true;
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
		//alert($scope.selectedInMateIds);
		 $http.post('quickpay/getInMateName', $scope.selectedInMateIds).success(function(inmateName){
			 $scope.inmateFullName=inmateName;
		       
		 });
			
	}
	$scope.checkCreditCard = function($event){
//		console.log($event.currentTarget.checked);
//		console.log($event.currentTarget.value);
		//var selectedProfileId = $event.currentTarget.value
		if($event.currentTarget.checked){
			$scope.paymentDetails.selectedPayProfile=$event.currentTarget.value;
			$scope.paymentDetails.paymentGatewayProfileID=$scope.paymentProfileDetails.paymentGatewayProfileID;
			$scope.paymentDetails.paymentProfileID=$event.currentTarget.value;
		}else{
			$scope.paymentDetails.selectedPayProfile="";
		}
		//alert($scope.selectedPayProfileId)	;
	};
	$scope.backTab4=function(){
		 $('#form_wizard_1').find('.progress-bar').css({width: '60%'});
		 $('.myMenuList li:nth-child(3)').removeClass('done');
		 $('.myMenuList li:nth-child(3)').addClass('active');
    	 $('.myMenuList li:nth-child(4)').removeClass('active');
    	 
    	 $http.post('quickpay/getInMate', $scope.paymentDetails).success(function(inmates){
    	        $scope.inmate=inmates[0];
    	       });
		$scope.showtab1=false;
		$scope.showtab11=false;
		
		$scope.errortab3=false;
		$scope.showtab2=false;
		$scope.showtab3=true;
		$scope.showtab4=false;
		$scope.showtab5=false;
		
	}
	$scope.continuePayTab4=function(){
		 $('#form_wizard_1').find('.progress-bar').css({width: '90%'});
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
	$scope.selectState=function(facilityLocation){
		//alert(facilityLocation.state);
		$scope.paymentDetails.stateID=facilityLocation.stateID;
		$scope.paymentDetails.state=facilityLocation.stateName;
		//alert(facilityLocation.state);
	}
	$scope.selectCountry=function(facilityLocation){
		//alert(facilityLocation.countryName);
		//alert(facilityLocation.countryID);
		$scope.paymentDetails.countryID=facilityLocation.countryID;
		$scope.paymentDetails.country=facilityLocation.countryName;
		//alert(facilityLocation.countryName);
	}


	$scope.fetchDashboardData();
	$scope.selectedInMateIds ="";
	$scope.checkInMates = function($event){
//		console.log($event.currentTarget.checked);
//		console.log($event.currentTarget.value);
		var selectedInMateId = $event.currentTarget.value;
		if($event.currentTarget.checked){
			$scope.selectedInMateIds=selectedInMateId;
		}else{
			$scope.selectedInMateIds="";
			}
			
	};
};