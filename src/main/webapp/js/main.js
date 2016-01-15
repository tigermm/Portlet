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
                $.ajax({
                    method: 'POST',
                    url: url,
                    params: params,
                    success: function(data){
                        $scope.sum = data;
                    }
                });
            };
        }]
    );

    angular.bootstrap(document.getElementById(id),[id]);
}