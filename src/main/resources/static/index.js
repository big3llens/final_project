angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8183/1';

    $scope.getEmployeesByOrganization = function (orgId) {
            $http({
                url: contextPath + '/findAllByOrganization',
                method: 'GET',
                params: {
                    orgId: orgId
                }
            }).then(function (response) {
                if (orgId === 1) {$scope.EmployeeDevDtoList = response.data; console.log($scope.EmployeeDevDtoList); return;}
                if (orgId === 2) {$scope.EmployeeInvestDtoList = response.data; console.log($scope.EmployeeInvestDtoList); return;}
                $scope.EmployeeServDtoList = response.data;
                console.log($scope.EmployeeServDtoList);
            });
    };

    $scope.searchByName = function (){
        $http({
            url: contextPath + '/searchEmployeeByName',
            method: 'GET',
            params: {
                name: $scope.semp
            }
        }).then(function (response) {
            $scope.finderEmployee = response.data;
            $scope.semp = '';
            console.log($scope.finderEmployee)
            console.log(response)
        });
    };

    $scope.hideEmployee = function (id){
        $http({
            url: contextPath + '/hideEmployee',
            method: 'GET',
            params: {
                id: id
            }
        });
    };



    $scope.goBack = function() {
        window.history.back();
    };
});