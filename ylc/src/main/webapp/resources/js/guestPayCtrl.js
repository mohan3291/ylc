var app = angular.module('myGuestPayApp', []);
app.controller('guestPayCtrl', function($scope,$http) {
	$scope.show=function(){

		$scope.tabCounter=1;
		$('.myMenuList li:nth-child(1)').addClass('active');
		 $('#form_wizard_1').find('.progress-bar').css({width: '20%'});
		$scope.showtab1=true;
		$scope.showtab11=false;
		$scope.showtab2=false;
		$scope.showtab3=false;
		$scope.errortab3=false;
		$scope.showtab4=false;
		$scope.showtab5=false;
		
        	$http.get('account/getStates').success(function(states){
        		$scope.stateList = states;		
        	});
         	
         	$http.get('account/getCountry').success(function(country){
        			$scope.countryList = country;
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
		 $('#form_wizard_1').find('.progress-bar').css({width: '90%'});
   	 $('.myMenuList li:nth-child(5)').addClass('active');
   	 $('.myMenuList li:nth-child(4)').addClass('done');
		
   	$http.post('quickpay/getInMate', $scope.paymentDetails).success(function(inmates){
        $scope.inmate=inmates[0];
       });
   	 
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
	$scope.savePayment = function(paymentDetails) {
		 $http.post('quickpay/savePaymetDetails', paymentDetails).success(function(paymentRes){
			//alert("Suresh");
			 //alert(paymentRes.statusCode);
			 //$scope.paymentDetails = pd;
			$scope.showtab1=false;
			$scope.showtab2=false;
			$scope.showtab3=false;
	
			if(paymentRes.statusCode==='0'){
					//("reddy");
					 $scope.orderConfMessgae=paymentRes.statusMessage;
					 $('#form_wizard_1').find('.progress-bar').css({width: '100%'});
					 $('.myMenuList li:nth-child(5)').addClass('done');
					 $scope.showtab5=false;
					 $scope.showtab4=false;
					 $scope.showCompleteTab=true;
					 
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
	
	$scope.show();
	$scope.selectedInMateIds = [];
	$scope.checkInMates = function($event){
//		console.log($event.currentTarget.checked);
//		console.log($event.currentTarget.value);
		var selectedInMateId = $event.currentTarget.value
		if($event.currentTarget.checked){
			$scope.selectedInMateIds.push(selectedInMateId);
		}else{
			var index = $scope.selectedInMateIds.indexOf(selectedInMateId);
			if (index > -1) {
				$scope.selectedInMateIds.splice(index, 1);
			}
		}
			
	};
	
	$scope.userType='';
	$scope.checkUserType = function($event){
		var selectedInMateId = $event.currentTarget.value
		if($event.currentTarget.checked){
			$scope.checkUserType=selectedInMateId;
		}else{
			$scope.checkUserType='';
			}	
		//alert(userType);
	};
	
});

