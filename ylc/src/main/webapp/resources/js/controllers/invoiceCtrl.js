'use strict';

/**
 * CarController
 * @constructor
 */
var invoiceCtrl = function($scope, $http) {
	
	$( ".account" ).removeClass( "active" );
	$( ".dashboard" ).removeClass( "active" );
	$( ".invoice" ).addClass( "active" );
	$( ".numbers" ).removeClass( "active" );
	$( ".call" ).removeClass( "active" );
	$( ".quickpay" ).removeClass( "active" );
	$( ".aselect" ).removeClass( "selected" );
	$( ".dselect" ).removeClass( "selected" );
	$( ".iselect" ).addClass( "selected" );
	$( ".nselect" ).removeClass( "selected" );
	$( ".cselect" ).removeClass( "selected" );
	$( ".qselect" ).removeClass( "selected" );
	
	$scope.featchInvoice = function() {
   	 $http.get('invoice/invoiceForUser').success(function(invoice){
          /*  alert("invoice/invoiceForUser");*/
        	$scope.invoiceInfoList = invoice;
        });
   	/*$http.get('dashboard/dashboardInfo.json').success(function(inmateList){
           alert("Dashboard");
       	//$scope.inmates = inmateList;
       });*/
      
   };
    $scope.featchInvoice();
};