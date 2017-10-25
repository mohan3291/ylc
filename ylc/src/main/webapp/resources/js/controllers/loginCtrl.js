
var loginApp = angular.module('loginApp', []);

loginApp.controller('loginCtrl', ['$scope', function ($scope) {
	console.log('in loginCtrl');
	$scope.uname = null;
	$scope.pass = null;
	$scope.email = null;
	 $scope.showAlert = function(){
	    	alert($scope.email);
	    };
}]);
