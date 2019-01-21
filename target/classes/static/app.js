// источник: https://www.airpair.com/angularjs/posts/angularjs-from-prototyping-to-functional-code

angular.module('clientsApp', []);

angular
  .module('clientsApp')
  .controller('ClientsCtrl', function($scope,$http) {
	  $scope.clients=[];
	  $scope.getClientes=function(){
		  $http({
	          url: '/clientes',
	          method:'GET',
	          dataType: 'json',
	          timeout:10000,
	          headers : {
	          //'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8'
	          }
	      }).success(function(data){
	          $scope.clients=data;
	          console.log(data)
	      }).error(function(err){
	          console.log(err);
	      }); 
	  };
	  $scope.getClientes();
   

    $scope.delete = function(client) {
    	$http({
	          url: '/clientes/'+client.id,
	          method:'DELETE',
	          dataType: 'json',
	          timeout:10000,
	          headers : {
	          //'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8'
	          }
	      }).success(function(data){
	    	  console.log(data);
	    	  $scope.newClient = null
	    	  $scope.getClientes();
	      }).error(function(err){
	          console.log(err);
	      });
    };
    $scope.newClient={
    		id:null,
    		name:null,
    		age:null
    };
    $scope.create = function() {
      //$scope.newClient = null;
    	//$scope.newClient.id=$scope.clients.length;
		  console.log($scope.newClient);
	      $http({
	          url: '/clientes',
	          method:'POST',
	          dataType: 'json',
	          timeout:10000,
	          data:JSON.stringify($scope.newClient),
	          headers : {
	        	  'Content-Type' : 'application/json; charset=utf-8'
	          }
	      }).success(function(data){
	    	  console.log(data);
	    	  $scope.newClient = null;
	    	  $scope.getClientes();
	      }).error(function(err){
	          console.log(err);
	      });
    };

    $scope.edit = function(client) {
      $scope.activeClient = client;
      $scope.newClient = client;
    };
    $scope.update = function(client) {
      $scope.activeClient = null;
      $scope.newClient = null;
    };
  });

// scripts/directives/integer.coffee 
var INTEGER_REGEXP = /^\-?\d+$/;
angular.module('clientsApp').directive('integer', function() {
  return {
    require: 'ngModel',
    link: function(scope, elm, attrs, ctrl) {
      ctrl.$validators.integer = function(modelValue, viewValue) {
        if (ctrl.$isEmpty(modelValue)) return true;
        if (INTEGER_REGEXP.test(viewValue)) return true;
        return false;
      };
    }
  };
});



$(function() {
  $('#clientTable').floatThead({
    scrollContainer: function($table) {
      return $table.closest('.table-wrap');
    }
  });
});