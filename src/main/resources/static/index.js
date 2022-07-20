(function ($localStorage) {
    'use strict';
    angular
        .module('app', ['ngRoute', 'ngStorage'])
        .config(config)
        .run(run);

    function config($routeProvider, $httpProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'home/home.html',
                controller: 'homeController'
            })
            .when('/editEmployee', {
                templateUrl: 'editEmployee/editEmployee.html',
                controller: 'editEmployeeController'
            })
            .when('/findByLastName', {
                templateUrl: 'findByLastName/findByLastName.html',
                controller: 'findController'
            })
            .when('/groups/dev', {
                templateUrl: 'groups/dev/dev.html',
                controller: 'homeController',
            })
            .when('/groups/invest', {
                templateUrl: 'groups/invest/invest.html',
                controller: 'homeController',
            })
            .when('/groups/service', {
                templateUrl: 'groups/service/service.html',
                controller: 'homeController',
            })
            .when('/saveEmployee', {
                templateUrl: 'saveEmployee/saveEmployee.html',
                controller: 'saveEmployeeController',
            })
            .otherwise({
                redirectTo: '/'
            });

        $httpProvider.interceptors.push(function ($q, $location) {
            return {
                'responseError': function (rejection, $localStorage, $http) {
                    var defer = $q.defer();
                    if (rejection.status == 401 || rejection.status == 403) {
                        console.log('error: 401-403');
                        $location.path('/auth');
                        if (!(localStorage.getItem("localUser") === null)) {
                            delete $localStorage.currentUser;
                            $http.defaults.headers.common.Authorization = '';
                        }
                        console.log(rejection.data);
                        var answer = JSON.parse(rejection.data);
                        console.log(answer);
                        // window.alert(answer.message);
                    }
                    defer.reject(rejection);
                    return defer.promise;
                }
            };
        });
    }

    function run($rootScope, $http, $localStorage) {
        if ($localStorage.currentUser) {
            $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.currentUser.token;
        }
    }
})();

angular.module('app').controller('indexController', function ($scope, $http, $localStorage) {
    const contextPath = 'http://localhost:8183/handbook';

    $scope.role = null;

    $scope.tryToAuth = function () {
        $http.post(contextPath + '/auth', $scope.user)
            .then(function successCallback(response) {
                if (response.data.token) {
                    $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
                    $localStorage.currentUser = {username: $scope.user.username, token: response.data.token};
                    $scope.currentUserName = $scope.user.username;

                    $scope.user.username = null;

                    $scope.user.password = null;

                    $scope.role = response.data.admin;
                    console.log($scope.role);
                }

            }, function errorCallback(response) {
            });
    };

    $scope.tryToLogout = function () {
        $scope.clearUser();
        if ($scope.user.username) {
            $scope.user.username = null;
        }
        if ($scope.user.password) {
            $scope.user.password = null;
        }
    };

    $scope.clearUser = function () {
        delete $localStorage.currentUser;
        $http.defaults.headers.common.Authorization = '';
    };

    $scope.isUserLoggedIn = function () {
        if ($localStorage.currentUser) {
            return true;
        } else {
            return false;
        }
    };
});