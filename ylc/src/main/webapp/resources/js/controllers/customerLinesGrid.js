'use strict';

App.controller('customerLinesGrid', ['$scope', '$http', '$log', '$timeout','$rootScope', 'uiGridConstants', function ($scope, $http, $log, $timeout,$rootScope, uiGridConstants) {
  $scope.gridOptions = {
    enableRowSelection: true,
    enableSelectAll: true,
    selectionRowHeaderWidth: 25,
    rowHeight: 25,
    showGridFooter:true
  };
  
  $scope.gridOptions.columnDefs = [
									
                                   { name: 'inmateName', displayName: 'Inmate Name'},
                                   { name: 'bop', displayName: 'Inmate BOP Number', },
                                   { name: 'facility', displayName: 'Fecility' },
                                   { name: 'number', displayName: 'Telephone Number', },
                                   { name: 'status', displayName: 'Status'},
                                   { name: 'routingNumber', displayName: 'Destination Number' },
                                   { name: 'activation' , displayName: 'Activation Date'}
                                 ];
                                
                                 $scope.gridOptions.multiSelect = true;
                                
                                 	$rootScope.setCustomerLinesData = function(data){
                                 		$scope.gridOptions.data = data;
                                 	};
                                 
                                   $scope.gridOptions.onRegisterApi = function(gridApi){
                                     //set gridApi on scope
                                     $scope.gridApi = gridApi;
//                                     gridApi.selection.on.rowSelectionChanged($scope,function(row){
//                                       var msg = 'row selected ' + row.isSelected;
//                                       $log.log(msg);
//                                     });
                               // 
//                                     gridApi.selection.on.rowSelectionChangedBatch($scope,function(rows){
//                                       var msg = 'rows changed ' + rows.length;
//                                       $log.log(msg);
//                                     });
                                   };
                               }]);
  
  
 
 /* $scope.gridOptions.columnDefs = [
    { name: 'number', displayName: 'Telephone Number', },
    { name: 'status', displayName: 'Status'},
    { name: 'routingNumber', displayName: 'Routing Number' },
    { name: 'minutesRemaining' , displayName: 'Minutes Remaining'},
    { name: 'facility' , displayName: 'Facility'},
    { name: 'activation' , displayName: 'Activation Date'}
  ];
 
  $scope.gridOptions.multiSelect = true;
 
  	$rootScope.setCustomerLinesData = function(data){
  		$scope.gridOptions.data = data;
//        $timeout(function() {
//          if($scope.gridApi.selection.selectRow){
//            $scope.gridApi.selection.selectRow($scope.gridOptions.data[0]);
//          }
//        });
  	};
  
    $scope.gridOptions.onRegisterApi = function(gridApi){
      //set gridApi on scope
      $scope.gridApi = gridApi;
//      gridApi.selection.on.rowSelectionChanged($scope,function(row){
//        var msg = 'row selected ' + row.isSelected;
//        $log.log(msg);
//      });
// 
//      gridApi.selection.on.rowSelectionChangedBatch($scope,function(rows){
//        var msg = 'rows changed ' + rows.length;
//        $log.log(msg);
//      });
    };
}]);*/