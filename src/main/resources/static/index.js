angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8183/1';

    $scope.getEmployeeDev = function () {
            $http({
                url: contextPath + '/psb/' + 1,
                method: 'GET',
                params: {

                }
            }).then(function (response) {
                $scope.EmployeeDevDtoList = response.data;
            });
    };

    $scope.goBack = function() {
        window.history.back();
    };

    // $scope.searchByName = function (){
    //     $http({
    //         url: contextPath + '/searchByName/' + $scope.name,
    //         method: 'GET',
    //         params: {
    //
    //         }
    //     }).then(function (response) {
    //         $scope.EmployeeDevDtoList = response.data;
    //         $scope.semp = '';
    //         console.log(response)
    //     });
    // };

    $scope.searchByName = function (){
        $http.post(contextPath + '/searchByName', $scope.EmployeeName)
            .then(function (response) {
                // console.log('sended:');
                // console.log($scope.newProduct);
                // console.log('received');
                // console.log(response.data);
                console.log($scope.EmployeeName)
                $scope.EmployeeName = null;
                $scope.finderEmployee = response.data;
            });
    };

    $scope.getEmployeeServ = function () {
        $http({
            url: contextPath + '/psb/' + 2,
            method: 'GET',
            params: {

            }
        }).then(function (response) {
            $scope.EmployeeServDtoList = response.data;
        });
    };



    // $scope.fillTable();

});