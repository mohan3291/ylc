'use strict';

/**
 * CarController
 * @constructor
 */
var prePayCtrl = function($scope, $http) {
	
	$scope.fetchMinutesData = function() {
		 $scope.showAddMinTab1=true;
		 $('#form-wizard_1').find('.progress-bar').css({width: '30%'});
		 $('.myMenuList li:nth-child(1)').addClass('active');
		
		 $http.get('minutes/minutesDetails').success(function(pd){
		 $scope.pplist = pd;
      	 $http.get('quickpay/paymetDetails').success(function(pd){
          	$scope.paymentDetails = pd;
          });
      });
	}
	$scope.addMin = function() {
		$scope.AccInfo=false;
		$scope.showtabMain=true;
		 $scope.showAddMinTab1=true;
		$('#form-wizard_1').find('.progress-bar').css({width: '30%'});
		 $('.myMenuList li:nth-child(1)').addClass('active');
		 $http.get('minutes/minutesDetails').success(function(pd){
      	$scope.pplist = pd;
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
	
	$scope.continuePrepayTab1=function(){
		$('.myMenuList li:nth-child(1)').removeClass('active');
		$('.myMenuList li:nth-child(1)').addClass('done');
		$('.myMenuList li:nth-child(2)').addClass('active');
		 $('#form-wizard_1').find('.progress-bar').css({width: '60%'});
		$scope.showAddMinTab1=false;
		$scope.paymentProfile=true;
		$scope.showtabMain=true;
		$scope.showAddMinTab2=true;
		$scope.paymentDetails.totalPrice=$scope.paymentDetails.amount;
	}
	
	$scope.backAddMinTab2=function(){
		$('.myMenuList li:nth-child(2)').removeClass('active');
		$('.myMenuList li:nth-child(1)').removeClass('done');
		$('.myMenuList li:nth-child(1)').addClass('active');
		 $('#form-wizard_1').find('.progress-bar').css({width: '30%'});
		$scope.showAddMinTab1=true;
		$scope.showAddMinTab2=false;
		$scope.showAddMinTab3=false;
	}
	$scope.continueAddMinTab2=function(){
		$('.myMenuList li:nth-child(2)').removeClass('active');
		$('.myMenuList li:nth-child(2)').addClass('done');
		$('.myMenuList li:nth-child(3)').addClass('active');
		 $('#form-wizard_1').find('.progress-bar').css({width: '90%'});
		$scope.showAddMinTab1=false;
		$scope.showAddMinTab2=false;
		$scope.showAddMinTab3=true;
	}
	$scope.backAddMinTab3=function(){
		$('.myMenuList li:nth-child(3)').removeClass('active');
		$('.myMenuList li:nth-child(2)').removeClass('done');
		$('.myMenuList li:nth-child(2)').addClass('active');
		 $('#form-wizard_1').find('.progress-bar').css({width: '60%'});
		 $scope.showAddMinTab1=false;
			$scope.showAddMinTab3=false;
			$scope.showAddMinTab2=true;
	}
	$scope.submitPayment=function(paymentDetails){
		$scope.paymentDetails.paymentType="prepay";
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
				 }
	       });
	}
	$scope.selectBlock = function(blockOfMin){
		$scope.paymentDetails.blockId=blockOfMin.prepaidPricingID;
		$scope.paymentDetails.blockOfMins=blockOfMin.noOfMinutes;
		$scope.paymentDetails.pricePerBlock=blockOfMin.blockPrice;
		$scope.paymentDetails.totalPrice=blockOfMin.blockPrice;
		$scope.price==blockOfMin.blockPrice;
		}
	$scope.checkCreditCard = function($event){
		if($event.currentTarget.checked){
			$scope.paymentDetails.selectedPayProfile=$event.currentTarget.value;
		}else{
			$scope.paymentDetails.selectedPayProfile="";
		}
	};
	$scope.addMin();
    
};