'use strict';

/**
 * PayController
 * @constructor
 */
var PayController = function($scope, $http) {
    $scope.fetchUsersList = function() {
    	//alert("Suresh")
    	$scope.showtab1=true;
		/*$scope.showtab2=false;
		$scope.showtab3=false;
		$scope.showtab4=false;*/
       /* $http.get('pay/userlist.json').success(function(inmateList){
            $scope.inmates = inmateList;
        });*/
    };
    
    $scope.inmateSearch = function(inmate) {      

        $http.post('pay/inmateSearch', inmate).success(function() {
        	//alert("inmateSearch");
        	//$scope.fetchUsersList();           
        }).error(function() {
            $scope.setError('Could not search inmate....');
        });
    };
    
    $scope.getInmate = function(inmate) {      

        $http.post('pay/getInmate', inmate).success(function() {
        	//alert("Suresh");
         //   $scope.fetchUsersList();           
        }).error(function() {
            $scope.setError('Could not search inmate....');
        });
    };

    $scope.continuePayTab1=function(){
	//	alert("continueTab1");
		/*$scope.showtab1=false;
		$scope.showtab2=true;
		$scope.showtab3=false;
		$scope.showtab4=false;*/
		
	}

   
    
    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };

    $scope.fetchUsersList();
};