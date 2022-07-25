angular.module('app').controller('homeController', function ($scope, $http) {
    const contextPath = 'http://localhost:8183/handbook';

    $scope.getEmployeesByOrganization = function (orgId) {
        $http({
            url: contextPath + '/findAllByOrganization',
            method: 'GET',
            params: {
                orgId: orgId
            }
        }).then(function (response) {
            $scope.EmployeesDtoList = response.data;
            console.log($scope.EmployeesDtoList);
        });
    };

    $scope.getAllEmployees = function () {
        $http({
            url: contextPath + '/findAllEmployees',
            method: 'GET',
            params: {

            }
        }).then(function (response) {
            $scope.EmployeesDtoList = response.data;
            console.log($scope.EmployeesDtoList);
        });
    };
});