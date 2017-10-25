'use strict';

/**
 * CarController
 * @constructor
 */
var accountCtrl = function($scope, $http) {
	
	$( ".account" ).addClass( "active" );
	$( ".dashboard" ).removeClass( "active" );
	$( ".invoice" ).removeClass( "active" );
	$( ".numbers" ).removeClass( "active" );
	$( ".call" ).removeClass( "active" );
	$( ".quickpay" ).removeClass( "active" );
	$( ".aselect" ).addClass( "selected" );
	$( ".dselect" ).removeClass( "selected" );
	$( ".iselect" ).removeClass( "selected" );
	$( ".nselect" ).removeClass( "selected" );
	$( ".cselect" ).removeClass( "selected" );
	$( ".qselect" ).removeClass( "selected" );
	
	$scope.fetchMinutesData = function() {
		$scope.selectedPayProfileId="";
		//alert("Suresh");
		$scope.AccInfo=true;
		 $http.get('account/customerDetails').success(function(pd){
     	$scope.accountDetails = pd;
     	$scope.tab2=false;
     	$scope.tab1=true;
     	$http.get('account/getStates').success(function(states){
    		$scope.stateList = states;	
    		for(var var1 in states){
    			if(states[var1].stateID===$scope.accountDetails.stateID){
    				$scope.aState=states[var1];
    				$scope.accountDetails.stateID=states[var1].stateID
    				break;
    			}
    		}
    	});
     	
     	$http.get('account/getCountry').success(function(country){
    			$scope.countryList = country;
    			//alert($scope.accountDetails.countryID);
    			for(var var1 in country){
        			if(country[var1].countryID===$scope.accountDetails.countryID){
        				$scope.acountry=country[var1];
        				$scope.accountDetails.countryID=country[var1].countryID
        				break;
        			}
    			}
    	});
     	
     });
	
	$http.get('account/getCCInfo').success(function(ccInfo){
		//	alert(states);     	
			$scope.ccInfo = ccInfo;
			 });
	}
	
	$scope.showTab2 = function(){
		
		$scope.tab1=false;
		$scope.saveCard=false;
		$scope.editAcc=true;
	}
	$scope.showCCEdit = function(){
	//	alert("dasdas");
		/*$scope.tab1=false;
		$scope.tab2=false;*/
		$http.get('account/getPaymentProfile').success(function(paymentDetail){
			//	alert(states);     	
				$scope.paymentDetails = paymentDetail;
				 });
		$scope.editAcc=false;
		$scope.tab1=false;
		$scope.saveCard=true;
//		$scope.tab1=false;
	}
	
	$scope.saveCCInfo = function(paymentDetails) {
	//	alert("saveCCInfo");
		// $location.path("/account");
		console.log(paymentDetails);
			$scope.tab1=true;
			$scope.tab2=false;
			
			 $http.post('account/saveCCInfo', paymentDetails).success(function(){
					alert("Customer Information Updated..");
					$scope.tab1=true;
					$scope.tab2=false;
					
//					$scope.accountDetails = accountDetails;
					 // $scope.paymentDetails = pd;
					// $location.path("/account");
		      }); 
		
	}
	
	$scope.saveAccountInfo = function(accountDetails) {
		 $http.post('account/saveAccountInfo', accountDetails).success(function(){
			alert("Customer Information Updated..");
			$scope.tab1=true;
			$scope.tab2=false;
			
//			$scope.accountDetails = accountDetails;
			 // $scope.paymentDetails = pd;
			// $location.path("/account");
      }); 
		/* $http.get('account/customerDetails').success(function(pd){
		     	$scope.accountDetails = pd;
		     });*/
		
	}
	$scope.selectState=function(facilityLocation){
		//alert(facilityLocation.stateID);
		$scope.accountDetails.stateID=facilityLocation.stateID;
		$scope.accountDetails.state=facilityLocation.stateName;
	}
	$scope.selectCountry=function(facilityLocation){
		//alert(facilityLocation.countryID);
		$scope.accountDetails.countryID=facilityLocation.countryID;
		$scope.accountDetails.country=facilityLocation.countryName;
	}

	
	
	
	$scope.addMin = function() {
		//alert("Suresh");
		$scope.AccInfo=false;
		$scope.showtabMain=true;
		 $scope.showAddMinTab1=true;
		$('#form-wizard_1').find('.progress-bar').css({width: '30%'});
		 $('.myMenuList li:nth-child(1)').addClass('active');
		
		
		
		 
		 $http.get('minutes/minutesDetails').success(function(pd){
         // alert("managelines/inmateNumDetails");
      	$scope.pplist = pd;
      	$http.get('quickpay/paymetDetails').success(function(pd){
             // alert("dashboard/customerInfo.json");
          	$scope.paymentDetails = pd;
        //  	$scope.paymentDetails.lineID=item.lineID;
         // 	alert($scope.paymentDetails.pricePerBlock);
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
    
      });
		
	}
	
	$scope.continueAddMinTab1=function(){
		$('.myMenuList li:nth-child(1)').removeClass('active');
		$('.myMenuList li:nth-child(1)').addClass('done');
		$('.myMenuList li:nth-child(2)').addClass('active');
		 $('#form-wizard_1').find('.progress-bar').css({width: '60%'});
		//alert( $('.myMenuList li').length);
		//alert($scope.paymentDetails.cardNumber);
		//alert("continueTab1");
		$scope.showAddMinTab1=false;
		$scope.paymentProfile=true;
		$scope.showtabMain=true;
		$scope.showAddMinTab2=true;
	}
	
	$scope.backAddMinTab2=function(){
		$('.myMenuList li:nth-child(2)').removeClass('active');
		$('.myMenuList li:nth-child(1)').removeClass('done');
		$('.myMenuList li:nth-child(1)').addClass('active');
		 $('#form-wizard_1').find('.progress-bar').css({width: '30%'});
		//alert("backTab2");
		$scope.showAddMinTab1=true;
		$scope.showAddMinTab2=false;
		$scope.showAddMinTab3=false;
		
		
	}
	$scope.continueAddMinTab2=function(){
		//alert("Suresh");
		$('.myMenuList li:nth-child(2)').removeClass('active');
		$('.myMenuList li:nth-child(2)').addClass('done');
		$('.myMenuList li:nth-child(3)').addClass('active');
		 $('#form-wizard_1').find('.progress-bar').css({width: '90%'});
		$scope.showAddMinTab1=false;
		$scope.showAddMinTab2=false;
		$scope.showAddMinTab3=true;
		
		
	}
	$scope.backAddMinTab3=function(){
		//alert("backTab2");
		$('.myMenuList li:nth-child(3)').removeClass('active');
		$('.myMenuList li:nth-child(2)').removeClass('done');
		$('.myMenuList li:nth-child(2)').addClass('active');
		 $('#form-wizard_1').find('.progress-bar').css({width: '60%'});
		 $scope.showAddMinTab1=false;
			$scope.showAddMinTab3=false;
			$scope.showAddMinTab2=true;
		
		
	}
	$scope.submitPayment=function(paymentDetails){
		 $scope.showAddMinTab1=false;
			$scope.showAddMinTab3=false;
			$scope.showAddMinTab2=false;
		
		$scope.showtab5=true;
		 $http.post('minutes/submitPayment', paymentDetails).success(function(paymentRes){
			 
			 if(paymentRes.statusCode==='0'){
					//("reddy");
					 $scope.orderConfMessgae=paymentRes.statusMessage;
					 
					 $scope.showAddMinTab1=false;
						$scope.showAddMinTab3=false;
						$scope.showAddMinTab2=false;
					 $scope.showCompleteTab=true;
					 $('.myMenuList li:nth-child(3)').removeClass('active');
					 $('.myMenuList li:nth-child(3)').addClass('done');
					 $('#form-wizard_1').find('.progress-bar').css({width: '100%'});
					 $http.get('account/customerDetails').success(function(pd){
					     	$scope.accountDetails = pd;
					     	});
					 
				 }
				 else{
					 alert(paymentRes.statusMessage);
					 $scope.showAddMinTab1=false;
						$scope.showAddMinTab3=false;
						$scope.showAddMinTab2=true;
					 $scope.showCompleteTab=false;
					 $('.myMenuList li:nth-child(3)').removeClass('active');
					 $('.myMenuList li:nth-child(2)').removeClass('done');
					 $('.myMenuList li:nth-child(2)').addClass('active');
					 $('#form-wizard_1').find('.progress-bar').css({width: '60%'});
					/* $('#form_wizard_1').find('.progress-bar').css({
			             width: '80%'
			         });
			    	 $('.myMenuList li:nth-child(4)').addClass('active');
			    	 $('.myMenuList li:nth-child(3)').addClass('done');
					 
					 $scope.showtab4=true;
					 $scope.showtab5=false;*/
	   			   
					 
				 }
	       // alert(data);
	       });
	}
	$scope.selectBlock = function(blockOfMin){
		//	alert($scope.paymentDetails.blockId);
		$scope.paymentDetails.blockId=blockOfMin.prepaidPricingID;
		$scope.paymentDetails.blockOfMins=blockOfMin.noOfMinutes;
		$scope.paymentDetails.pricePerBlock=blockOfMin.blockPrice;
		$scope.paymentDetails.totalPrice=blockOfMin.blockPrice;
		$scope.price==blockOfMin.blockPrice;

		
		}
	//$scope.selectedPayProfileId="";
	$scope.checkCreditCard = function($event){
//		console.log($event.currentTarget.checked);
//		console.log($event.currentTarget.value);
		//var selectedProfileId = $event.currentTarget.value
		if($event.currentTarget.checked){
			$scope.paymentDetails.selectedPayProfile=$event.currentTarget.value;
		}else{
			$scope.paymentDetails.selectedPayProfile="";
		}
		//alert($scope.selectedPayProfileId)	;
	};
	
	
	
	$scope.fetchMinutesData();
    
};