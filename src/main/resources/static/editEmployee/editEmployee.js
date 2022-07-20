angular.module('app').controller('editEmployeeController', function ($scope, $http) {
    const contextPath = 'http://localhost:8183/handbook';

    $scope.prints = [{"id": "Отобразить", "print": "true"}, {"id": "Скрыть", "print": "false"}];

    $scope.findEmployeeByName = function (){
        $http({
            url: contextPath + '/findEditEmployeeByName',
            method: 'GET',
            params: {
                name: $scope.lastName
            }
        }).then(function (response) {
            $scope.getDepartmens();
            $scope.getOrganizations();
            $scope.getRoomNumbers();
            $scope.finderEmployee = response.data;
            $scope.editedEmployee = $scope.finderEmployee;
            $scope.lastName = '';
            console.log($scope.finderEmployee)
            console.log(response)
        });
    };

    $scope.submitEditEmployee = function (){
        $http.post(contextPath + '/editEmployee', $scope.editedEmployee, console.log($scope.editedEmployee))
            .then(function successCallback(response) {
                $scope.editedEmployee = null;
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
            console.log($scope.departments)
        });
    }

    $scope.getRoomNumbers = function () {
        $http({
            url: contextPath + '/assist/getAllRoomNumbers',
            method: 'GET',
        }).then(function (response) {
            $scope.roomNumbers = response.data
            console.log($scope.departments)
        });
    }
});