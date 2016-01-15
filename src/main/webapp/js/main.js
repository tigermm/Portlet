'use strict';

function bootstrap(id, portletId) {

    var module = angular.module(id, []);

    module.controller("MainCtrl", ['$scope', function($scope) {
            $scope.milk = 2;
            $scope.sugar = 3;
            $scope.isConfigure = false;
            $scope.sum = 0;

            $scope.configure = function() {
                $scope.isConfigure = !$scope.isConfigure;
            };

            $scope.doSum = function(url) {
                var httpPromise = $http({
                    method: 'POST',
                    url: url,
                    params: {
                        milk:$scope.milk,
                        sugar:$scope.sugar
                    }
                });
                httpPromise.success(function(data){
                    $scope.sum = data;
                });
            };

            $scope.load = function(sugar, milk) {
                $scope.milk = milk;
                $scope.sugar = sugar;
            };
        }]
    );

    angular.bootstrap(document.getElementById(id),[id]);
}