'use strict';

/**
 * CarController
 * @constructor
 */
var managelinesCtrl = function($scope, $http) {
	$scope.searchInmateTab=true;
	$scope.addInmateTab=false;
	$scope.showSelectInmateTab=false;
	$scope.selectLoaclNumberTab=false;
	$scope.selectFwdNumTab=false;
	$scope.fetchInmateData = function() {
		//alert();
		$('.myMenuList li:nth-child(1)').addClass('active');
		$('#form_wizard_1').find('.progress-bar').css({width: '10%'});

		$http.get('managelines/imateNumberDetails').success(function(pd){
		
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
		$http.get('minutes/minutesDetails').success(function(pp){
	      	$scope.pplist = pp;
		});
     	$http.get('account/getCountry').success(function(country){
    			$scope.countryList = country;

    			for(var var1 in country){
        			if(country[var1].countryID===$scope.paymentDetails.countryID){
        				$scope.acountry=country[var1];
        				$scope.paymentDetails.countryID=country[var1].countryID
        				break;
        			}
    			}
    	});
    });
	}
	$scope.selectBlock = function(blockOfMin){
	$scope.paymentDetails.blockId=blockOfMin.prepaidPricingID;
	$scope.paymentDetails.blockOfMins=blockOfMin.noOfMinutes;
	$scope.paymentDetails.pricePerBlock=blockOfMin.blockPrice;
	
	}
	$scope.saveInmateNumDetails = function(inameteNumDetails) {
		 $http.post('managelines/saveInmateNumDetails', inameteNumDetails).success(function(){
      });
	}
	
	
	$scope.continueSearchInmateTab=function(paymentDetails){
		$scope.searchInmateTab=false;
		//$scope.showSelectInmateTab=false;
		$scope.selectLoaclNumberTab=false;
		$scope.addInmateTab=false;
		
		$http.post('quickpay/getInMate', paymentDetails).success(function(inmates){
	    
			
			if(inmates.length==0){
	        	 $scope.addInmateTab=true;
	         }
	         else{
	        	 $('.myMenuList li:nth-child(1)').addClass('done');
	     		$('.myMenuList li:nth-child(2)').addClass('active');
	     		$('#form_wizard_1').find('.progress-bar').css({width: '25%'});
	        	 $scope.showSelectInmateTab=true;
	        	 $scope.inmatesList=inmates;
	        	 
	         }
	       });
	}
	$scope.addInmate=function(paymentDetails){
		$scope.searchInmateTab=false;
		$scope.addInmateTab=false;
		
		 $http.post('quickpay/saveInMate', paymentDetails).success(function(inmates){
	         if(inmates.length==0){
	        	 $scope.showtab11=true;
         }
	         else{
	        	 $http.get('managelines/getFacilities?facId='+$scope.paymentDetails.inmateFacility).success(function(facilities){
	     			$scope.facilityLocs = facilities;
	     	    });
	        	$('.myMenuList li:nth-child(1)').addClass('done');
	     		$('.myMenuList li:nth-child(2)').addClass('done');
	     		$('#form_wizard_1').find('.progress-bar').css({width: '30%'});
	     		$scope.searchInmateTab=false;
	    		$scope.showSelectInmateTab=false;
	    		$scope.selectLoaclNumberTab=true;
	    		$scope.showAddMin=false;
	    		$scope.showCompleteTab=false;
	        	$scope.inmatesList=inmates;
	        	 
	         }
	       });
	}
	
	
	$scope.continueSelectLoaclNumberTab=function(paymentDetails){
	
		$scope.searchInmateTab=false;
		$scope.showSelectInmateTab=false;
		$scope.selectLoaclNumberTab=false;
		$scope.showAddMin=false;
		$scope.selectFwdNumTab=true;
		$('.myMenuList li:nth-child(3)').addClass('done');
		$('.myMenuList li:nth-child(4)').addClass('active');
		$('#form_wizard_1').find('.progress-bar').css({width: '55%'});
		$http.get('managelines/getCountries').success(function(countries){

			$scope.countriesList = countries;
	    });
		
	}
	$scope.continueShowSelectInmateTab=function(){
		$scope.paymentDetails.bop=$scope.selectedInMateId;
		$http.get('managelines/getFacilitiesByInmate?inametBOP='+$scope.selectedInMateId).success(function(facilities){
			$scope.facilityLocs = facilities;
	    });
		$('.myMenuList li:nth-child(2)').addClass('done');
		$('.myMenuList li:nth-child(3)').addClass('active');
		$('#form_wizard_1').find('.progress-bar').css({width: '40%'});
		
		$scope.searchInmateTab=false;
		$scope.showSelectInmateTab=false;
		$scope.selectLoaclNumberTab=true;
		$scope.showAddMin=false;
		$scope.showCompleteTab=false;
		
	}
	
	$scope.continueSelectFwdNumTab=function(){
		$http.get('account/getPaymentProfile').success(function(paymentDetail){
			//	alert(states);     	
				$scope.paymentProfileDetails = paymentDetail;
				 });
		$scope.searchInmateTab=false;
		$scope.showSelectInmateTab=false;
		$scope.selectLoaclNumberTab=false;
		$scope.selectFwdNumTab=false;
		$scope.showBillingDetailsTab=true;
		$scope.paymentProfile=true;
		$scope.showCompleteTab=false;
		$scope.showAddMin=false;
		$('.myMenuList li:nth-child(4)').addClass('done');
		$('.myMenuList li:nth-child(5)').addClass('active');
		$('#form_wizard_1').find('.progress-bar').css({width: '65%'});
		
	
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
	
	$scope.continueAddMin=function(){
		$scope.searchInmateTab=false;
		$scope.showSelectInmateTab=false;
		$scope.selectLoaclNumberTab=false;
		$scope.selectFwdNumTab=false;
		$scope.showAddMin=false;
		$scope.showBillingDetailsTab=true;
		$scope.showConfTab=false;
		$scope.showCompleteTab=false;
		$('.myMenuList li:nth-child(5)').addClass('done');
		$('.myMenuList li:nth-child(6)').addClass('active');
		$('#form_wizard_1').find('.progress-bar').css({width: '80%'});
	}
	$scope.continueBillingDetTab=function(){
		$scope.searchInmateTab=false;
		$scope.showSelectInmateTab=false;
		$scope.selectLoaclNumberTab=false;
		$scope.selectFwdNumTab=false;
		$scope.showAddMin=false;
		$scope.showBillingDetailsTab=false;
		$scope.showConfTab=false;
		$scope.showCompleteTab=false;
		$scope.showConfTab=true;
		$('.myMenuList li:nth-child(6)').addClass('done');
		$('.myMenuList li:nth-child(7)').addClass('active');
		$('#form_wizard_1').find('.progress-bar').css({width: '90%'});
	}
	
	$scope.submitLinePayment=function(paymentDetails){
		$scope.searchInmateTab=false;
		$scope.showSelectInmateTab=false;
		$scope.selectLoaclNumberTab=false;
		$scope.selectFwdNumTab=false;
		$scope.showAddMin=false;
		$scope.showBillingDetailsTab=false;
		
		
		
		$http.post('managelines/saveInmateNumDetails', paymentDetails).success(function(paymentRes){
			 if(paymentRes.statusCode==='0'){
				 $scope.orderConfMessgae=paymentRes.statusMessage;
				 $scope.showConfTab=false;
				 $scope.showBillingDetailsTab=false;
				 $scope.showCompleteTab=true;
				 $('.myMenuList li:nth-child(7)').addClass('done');
				 $('#form_wizard_1').find('.progress-bar').css({width: '100%'});
			 }
			 else{
				 $scope.showConfTab=false;
				 $scope.showBillingDetailsTab=true;
				 $('.myMenuList li:nth-child(7)').removeClass('done');
					$('.myMenuList li:nth-child(6)').addClass('active');
					$('#form_wizard_1').find('.progress-bar').css({width: '80%'});
				 
			 }
		       	//$location.path('/managelines');
		      });
	}
	$scope.selectFac=function(facilityLocation){
		$scope.paymentDetails.inmateFacility=facilityLocation.facilityID;
	}
	
	$scope.selectState=function(facilityLocation){
		$scope.paymentDetails.location=facilityLocation.facilityID;
		$http.get('managelines/getFacilityNumber').success(function(noPool){
			$scope.noList=noPool;
	    });
	}
	$scope.selectDest=function(destCountry){
	}
	
	$scope.selectNumber=function(pline){
		$scope.paymentDetails.lineNumber=pline.pNumber;
	}
	$scope.backShowSelectInmateTab=function(){
		$('.myMenuList li:nth-child(1)').addClass('active');
		$('.myMenuList li:nth-child(2)').removeClass('active');
		$('#form_wizard_1').find('.progress-bar').css({width: '10%'});
		$scope.searchInmateTab=true;
		$scope.showSelectInmateTab=false;
		$scope.selectLoaclNumberTab=false;
		$scope.selectFwdNumTab=false;
		$scope.showAddMin=false;
		$scope.showBillingDetailsTab=false;
		$scope.showConfTab=false;
		$scope.showCompleteTab=false;

		
	}

	$scope.backSubmitPage=function(){
		$scope.searchInmateTab=false;
		$scope.showSelectInmateTab=false;
		$scope.selectLoaclNumberTab=false;
		$scope.selectFwdNumTab=false;
		$scope.showAddMin=false;
		$scope.showBillingDetailsTab=true;
		$scope.showConfTab=false;
		$scope.showCompleteTab=false;
		$('.myMenuList li:nth-child(7)').removeClass('active');
		$('.myMenuList li:nth-child(6)').removeClass('done');
		$('.myMenuList li:nth-child(6)').addClass('active');
		
		$('#form_wizard_1').find('.progress-bar').css({width: '80%'});
		
	}
	$scope.backSelectFwdNumTab=function(){
		$scope.searchInmateTab=false;
		$scope.showSelectInmateTab=false;
		$scope.selectLoaclNumberTab=true;
		$scope.selectFwdNumTab=false;
		$scope.showAddMin=false;
		$scope.showBillingDetailsTab=false;
		$scope.showConfTab=false;
		$scope.showCompleteTab=false;
		$('.myMenuList li:nth-child(3)').removeClass('done');
		$('.myMenuList li:nth-child(3').addClass('active');
		$('.myMenuList li:nth-child(4)').removeClass('active');
		$('#form_wizard_1').find('.progress-bar').css({width: '45%'});
		
	}
	$scope.backAddMinTab=function(){
		$scope.searchInmateTab=false;
		$scope.showSelectInmateTab=false;
		$scope.selectLoaclNumberTab=false;
		$scope.selectFwdNumTab=true;
		$scope.showBillingDetailsTab=false;
		$scope.showAddMin=false;
		$scope.showConfTab=false;
		$scope.showCompleteTab=false;
		$('.myMenuList li:nth-child(4)').removeClass('done');
		$('.myMenuList li:nth-child(4)').addClass('active');
		$('.myMenuList li:nth-child(5)').removeClass('active');
		$('#form_wizard_1').find('.progress-bar').css({width: '55%'});
		
	}
	$scope.backBillingDetTab=function(){
		$scope.searchInmateTab=false;
		$scope.showSelectInmateTab=false;
		$scope.selectLoaclNumberTab=false;
		$scope.selectFwdNumTab=true;
		$scope.showAddMin=false;
		$scope.showBillingDetailsTab=false;
		$scope.showConfTab=false;
		$scope.showCompleteTab=false;
		$('.myMenuList li:nth-child(5)').removeClass('done');
		$('.myMenuList li:nth-child(5)').addClass('active');
		$('.myMenuList li:nth-child(6)').removeClass('active');
		$('#form_wizard_1').find('.progress-bar').css({width: '65%'});
		
	}
	
	$scope.backSelectLoaclNumberTab=function(){
		$scope.searchInmateTab=false;
		$scope.showSelectInmateTab=true;
		$scope.selectLoaclNumberTab=false;
		$scope.selectFwdNumTab=false;
		$scope.showBillingDetailsTab=false;
		$scope.showAddMin=false;
		$scope.showConfTab=false;
		$scope.showCompleteTab=false;
		$('.myMenuList li:nth-child(2)').removeClass('done');
		$('.myMenuList li:nth-child(2)').addClass('active');
		$('.myMenuList li:nth-child(3)').removeClass('active');
		$('#form_wizard_1').find('.progress-bar').css({width: '30%'});
		
	}
	$scope.selectedInMateId='';
	$scope.checkInMates = function($event){
		var selectedInMateId = $event.currentTarget.value
		if($event.currentTarget.checked){
			$scope.selectedInMateId = $event.currentTarget.value;
		}else{
			$scope.selectedInMateId = '';
		}
			
	};
	$scope.fetchInmateData();
    
};