angular.module('app').controller('findController', function ($scope, $http) {
    const contextPath = 'http://localhost:8183/handbook';

    $scope.findEmployeeByName = function (){
        $http({
            url: contextPath + '/findEmployeeByName',
            method: 'GET',
            params: {
                name: $scope.lastName
            }
        }).then(function (response) {
            $scope.finderEmployee = response.data;
            $scope.lastName = '';
            console.log($scope.finderEmployee)
            console.log(response)
        });
    };
});