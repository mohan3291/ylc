'use strict';

var AngularSpringApp = {};

var App = angular.module('AngularSpringApp', ['ngRoute','AngularSpringApp.filters', 'AngularSpringApp.services', 'AngularSpringApp.directives','ui.grid', 'ui.grid.selection']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {
	
	$routeProvider.when('/inmateSearch', {
        templateUrl: 'pay/inmateSearch',
        controller: PayController              
    });
	$routeProvider.when('/userHome', {
        templateUrl: 'pay/inmateSearch',
        controller: PayController              
    });
	$routeProvider.when('/numbermgmt', {
        templateUrl: 'numbermgmt/layout',
        controller: numbermgmtCtrl              
    });
	$routeProvider.when('/dashboard', {
        templateUrl: 'dashboard/layout',
        controller: dashboardCtrl              
    });
    $routeProvider.when('/getInmate', {
        templateUrl: 'pay/getInmate',
        controller: PayController              
    });
    $routeProvider.when('/account', {
        templateUrl: 'account/layout',
        controller: accountCtrl              
    });
    $routeProvider.when('/invoice', {
        templateUrl: 'invoice/layout',
        controller: invoiceCtrl              
    });
    $routeProvider.when('/customerlines', {
        templateUrl: 'customerlines/layout',
        controller: customerlinesCtrl              
    });
    $routeProvider.when('/managelines', {
        templateUrl: 'managelines/layout',
        controller: managelinesCtrl              
    });
    $routeProvider.when('/calllog', {
        templateUrl: 'calllog/layout',
        controller: calllogCtrl              
    });
    $routeProvider.when('/quickpay', {
        templateUrl: 'quickpay/layout',
        controller: quickpayCtrl              
    });
    $routeProvider.when('/minutes', {
        templateUrl: 'minutes/layout',
        controller: minutesCtrl              
    });
    
    $routeProvider.when('/guestPay', {
        templateUrl: 'guest/pay',
        controller: guestPayCtrl              
    });
    $routeProvider.when('/prepay', {
        templateUrl: 'prepay/prePayLayout',
        controller: prePayCtrl              
    });
    
  /*  $routeProvider.when('/railwaystations', {
        templateUrl: 'railwaystations/layout',
        controller: RailwayStationController
    });*/
    $routeProvider.otherwise({redirectTo: '/dashboard'});
}]);
