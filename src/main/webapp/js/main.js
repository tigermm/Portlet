'use strict';

function bootstrap(id, portletId) {

    var module = angular.module(id, []);

    module.controller("MainCtrl", ['$scope', '$http', function($scope, $http) {
            $scope.milk = 2;
            $scope.sugar = 3;
            $scope.isConfigure = false;
            $scope.sum = 0;

            $scope.doSum = function(url) {
                var params = {
                    milk:$scope.milk,
                    sugar:$scope.sugar
                };
                var httpPromise = $http({
                    method:'POST',
                    url:url,
                    params:params
                });
                httpPromise.success(function(data){
                    $scope.sum = data.sum;
                });
            };
        }]
    );

    angular.bootstrap(document.getElementById(id),[id]);
}