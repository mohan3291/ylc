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
     	$scope.editAcc=false;
     	$scope.saveCard=false;
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
	
	$scope.fetchMinutesData();
    
};