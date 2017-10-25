'use strict';

/**
 * dashboardCtrl
 * @constructor
 */
var dashboardCtrl = function($scope,$rootScope, $http,$location) {
	$( ".account" ).removeClass( "active" );
	$( ".dashboard" ).addClass( "active" );
	$( ".invoice" ).removeClass( "active" );
	$( ".numbers" ).removeClass( "active" );
	$( ".call" ).removeClass( "active" );
	$( ".quickpay" ).removeClass( "active" );
	$( ".aselect" ).removeClass( "selected" );
	$( ".dselect" ).addClass( "selected" );
	$( ".iselect" ).removeClass( "selected" );
	$( ".nselect" ).removeClass( "selected" );
	$( ".cselect" ).removeClass( "selected" );
	$( ".qselect" ).removeClass( "selected" );
	
	$rootScope.show = function (){
		 $http.get('dashboard/logout').success(function(){
	          $location.path('login');
	         });
	}
    $scope.fetchDashboardData = function() {
    	 $http.get('dashboard/customerInfo.json').success(function(dashBoard){
           //  alert("dashboard/customerInfo.json");
         	$scope.dashBoardInfo = dashBoard;
         	$rootScope.userName=dashBoard.accountname;
         });
    	/*$http.get('dashboard/dashboardInfo.json').success(function(inmateList){
            alert("Dashboard");
        	//$scope.inmates = inmateList;
        });*/
    	 $scope.balance=20;
    	 $scope.accountStatus="Inactive";
    	 $scope.activeLines=5;
    	 
    };
    
    $scope.inmateSearch = function(inmate) {      

        $http.post('dashboard/inmateSearch', inmate).success(function() {
        	//alert("dashboard-inmateSearch");
        	//$scope.fetchUsersList();           
        }).error(function() {
            $scope.setError('Could not search inmate....');
        });
    };
    
       $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };

    $scope.fetchDashboardData();
};