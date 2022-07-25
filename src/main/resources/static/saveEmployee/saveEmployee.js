angular.module('app').controller('saveEmployeeController', function ($scope, $http) {
    const contextPath = 'http://localhost:8183/handbook';

    $scope.print = [{"id": "Да"}, {"id": "Нет"}];

    $scope.init = function (){
        $scope.getDepartmens();
        $scope.getOrganizations();
        $scope.getRoomNumbers();

    };

    $scope.submitSaveEmployee = function (){
        $http.post(contextPath + '/saveEmployee', $scope.newEmployee, console.log($scope.newEmployee))
            .then(function successCallback(response) {
                $scope.newEmployee = null;
            }, function errorCallback(response) {
            });
    };

    $scope.getDepartmens = function () {
        $http({
            url: contextPath + '/assist/getAllDepartments',
            method: 'GET',
        }).then(function (response) {
            $scope.departments = response.data
            console.log($scope.departments)
        });
    }

    $scope.getOrganizations = function () {
        $http({
            url: contextPath + '/assist/getAllOrganizations',
            method: 'GET',
        }).then(function (response) {
            $scope.organizations = response.data
            console.log($scope.organizations)
        });
    }

    $scope.getRoomNumbers = function () {
        $http({
            url: contextPath + '/assist/getAllRoomNumbers',
            method: 'GET',
        }).then(function (response) {
            $scope.roomNumbers = response.data
            console.log($scope.roomNumbers)
            console.log(response)
        });
    }
});