'use strict';

/**
 * CarController
 * @constructor
 */
var customerlinesCtrl = function($scope, $http,$rootScope) {
	
	$( ".account" ).removeClass( "active" );
	$( ".dashboard" ).removeClass( "active" );
	$( ".invoice" ).removeClass( "active" );
	$( ".numbers" ).addClass( "active" );
	$( ".call" ).removeClass( "active" );
	$( ".quickpay" ).removeClass( "active" );
	$( ".aselect" ).removeClass( "selected" );
	$( ".dselect" ).removeClass( "selected" );
	$( ".iselect" ).removeClass( "selected" );
	$( ".nselect" ).addClass( "selected" );
	$( ".cselect" ).removeClass( "selected" );
	$( ".qselect" ).removeClass( "selected" );
	
	$scope.fetchMinutesData1 = function() {
		$scope.phoneNumber = '';
		$scope.price='';
		$scope.showtab0=true;
		$scope.showtabMain=false;
		
		$scope.editRoutingTab=false;
		 $http.get('customerlines/customerLinesList').success(function(lineList){
         // alert("Suresh");
      	$scope.custlineList = lineList;
      	
      });
	}
	
	$scope.addMin = function(item) {
		$scope.phoneNumber =item.number;
		 //alert(item.number);
		$('#form-wizard').find('.progress-bar').css({width: '40%'});
		 $scope.showtab0=false;
			$scope.showtabMain=true;
			 $scope.showtab1=true;
		 $scope.showtab1=true;
		 $http.get('minutes/minutesDetails').success(function(pd){
         // alert("managelines/inmateNumDetails");
      	$scope.pplist = pd;
      	$http.get('quickpay/paymetDetails').success(function(pd){
             // alert("dashboard/customerInfo.json");
          	$scope.paymentDetails = pd;
          	$scope.paymentDetails.lineID=item.lineID;
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
		 $('.myMenuList li:nth-child(1)').addClass('active');
		 $('#form-wizard_1').find('.progress-bar').css({width: '30%'});
	}
	
	
	$scope.deleteLine = function(item) {
		 //alert(item.lineID);
		
		 $http.post('customerlines/removeLine', item).success(function(lineList){
			  	$scope.custlineList = lineList;
		       });
	}
	
	$scope.editLine = function(item) {
		$scope.showtab0=false;
		$scope.editRoutingTab=true;
		$scope.editLine=item;
		$http.get('managelines/getCountries').success(function(countries){

			$scope.countriesList = countries;
	    });
		 //alert(item.lineID);
		
	}
	
	$scope.backEditRoute = function() {
		$scope.showtab0=true;
		$scope.editRoutingTab=false;
	}
	
	$scope.saveEditRouting = function(paymentDetails) {
		//alert(paymentDetails.fwdLineNumber);
		$scope.editLine.routingNumber=paymentDetails.fwdLineNumber;
		 $http.post('customerlines/editLine', $scope.editLine).success(function(lineList){
			  	$scope.custlineList = lineList;
		       });
		$scope.showtab0=true;
		$scope.editRoutingTab=false;
	}
	
	$scope.selectBlock = function(blockOfMin){
	//	alert($scope.paymentDetails.blockId);
	$scope.paymentDetails.blockId=blockOfMin.prepaidPricingID;
	$scope.paymentDetails.blockOfMins=blockOfMin.noOfMinutes;
	$scope.paymentDetails.pricePerBlock=blockOfMin.blockPrice;
	$scope.price==blockOfMin.blockPrice;

	
	}
	
	$scope.continueTab1=function(){
		$('.myMenuList li:nth-child(1)').removeClass('active');
		$('.myMenuList li:nth-child(1)').addClass('done');
		$('.myMenuList li:nth-child(2)').addClass('active');
		 $('#form-wizard_1').find('.progress-bar').css({width: '60%'});
		//alert( $('.myMenuList li').length);
	//	alert($scope.paymentDetails.blockId);
		//alert("continueTab1");
		$scope.showtab1=false;
		$scope.showtab2=true;
		$scope.showtab3=false;
		
		
	}

	$scope.backTab2=function(){
		$('.myMenuList li:nth-child(2)').removeClass('active');
		$('.myMenuList li:nth-child(1)').removeClass('done');
		$('.myMenuList li:nth-child(1)').addClass('active');
		 $('#form-wizard_1').find('.progress-bar').css({width: '30%'});
		//alert("backTab2");
		$scope.showtab1=true;
		$scope.showtab2=false;
		$scope.showtab3=false;
		
		
	}
	$scope.continueTab2=function(){
		//alert("Suresh");
		$('.myMenuList li:nth-child(2)').removeClass('active');
		$('.myMenuList li:nth-child(2)').addClass('done');
		$('.myMenuList li:nth-child(3)').addClass('active');
		 $('#form-wizard_1').find('.progress-bar').css({width: '90%'});
		$scope.showtab1=false;
		$scope.showtab2=false;
		$scope.showtab3=true;
		$scope.showtab4=false;
		
	}
	$scope.backTab3=function(){
		//alert("backTab2");
		$('.myMenuList li:nth-child(3)').removeClass('active');
		$('.myMenuList li:nth-child(2)').removeClass('done');
		$('.myMenuList li:nth-child(2)').addClass('active');
		 $('#form-wizard_1').find('.progress-bar').css({width: '60%'});
		$scope.showtab1=false;
		$scope.showtab2=true;
		$scope.showtab3=false;
		
		
	}
	$scope.submitPayment=function(paymentDetails){
		$scope.showtab1=false;
		
		$scope.showtab2=false;
		
		$scope.showtab5=true;
		 $http.post('minutes/submitPayment', paymentDetails).success(function(paymentRes){
			 
			 if(paymentRes.statusCode==='0'){
					//("reddy");
					 $scope.orderConfMessgae=paymentRes.statusMessage;
					 
					 $scope.showtab2=false;
					 $scope.showtab3=false;
					 $scope.showCompleteTab=true;
					 $('.myMenuList li:nth-child(3)').removeClass('active');
					 $('.myMenuList li:nth-child(3)').addClass('done');
					 $('#form-wizard_1').find('.progress-bar').css({width: '100%'});
					 
				 }
				 else{
					 alert(paymentRes.statusMessage);
					 $scope.showtab3=false;
					 $scope.showtab2=true;
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
	$scope.fetchMinutesData1();
};