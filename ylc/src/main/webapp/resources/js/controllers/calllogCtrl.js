'use strict';

/**
 * calllogCtrl
 * @constructor
 */
var calllogCtrl = function($scope, $http) {
	
	$( ".account" ).removeClass( "active" );
	$( ".dashboard" ).removeClass( "active" );
	$( ".invoice" ).removeClass( "active" );
	$( ".numbers" ).removeClass( "active" );
	$( ".call" ).addClass( "active" );
	$( ".quickpay" ).removeClass( "active" );
	$( ".aselect" ).removeClass( "selected" );
	$( ".dselect" ).removeClass( "selected" );
	$( ".iselect" ).removeClass( "selected" );
	$( ".nselect" ).removeClass( "selected" );
	$( ".cselect" ).addClass( "selected" );
	$( ".qselect" ).removeClass( "selected" );
    
};