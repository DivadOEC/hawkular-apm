///
/// Copyright 2015-2016 Red Hat, Inc. and/or its affiliates
/// and other contributors as indicated by the @author tags.
///
/// Licensed under the Apache License, Version 2.0 (the "License");
/// you may not use this file except in compliance with the License.
/// You may obtain a copy of the License at
///
///    http://www.apache.org/licenses/LICENSE-2.0
///
/// Unless required by applicable law or agreed to in writing, software
/// distributed under the License is distributed on an "AS IS" BASIS,
/// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
/// See the License for the specific language governing permissions and
/// limitations under the License.
///

/// <reference path="btmPlugin.ts"/>
module BTM {

  export var BTMIgnoredController = _module.controller('BTM.BTMIgnoredController', ['$scope', '$http', '$location',
    '$interval', ($scope, $http, $location, $interval) => {

    $scope.newBTxnName = '';
    $scope.candidateCount = 0;

    $scope.reload = function() {
      $http.get('/hawkular/apm/config/businesstxn/summary').then(function(resp) {
        $scope.businessTransactions = resp.data;
        $scope.businessTransactions.$resolved = true;
      },function(resp) {
        console.log('Failed to get business txn summaries: ' + JSON.stringify(resp));
      });

      $http.get('/hawkular/apm/analytics/unboundendpoints').then(function(resp) {
        $scope.candidateCount = Object.keys(resp.data).length;
      },function(resp) {
        console.log('Failed to get candidate count: ' + JSON.stringify(resp));
      });
    };

    $scope.reload();

    $scope.deleteBusinessTxn = function(btxn) {
      if (confirm('Are you sure you want to delete business transaction \'' + btxn.name + '\'?')) {
        $http.delete('/hawkular/apm/config/businesstxn/full/' + btxn.name).then(function(resp) {
          console.log('Deleted: ' + btxn.name);
          $scope.businessTransactions.remove(btxn);
        },function(resp) {
          console.log('Failed to delete business txn \'' + btxn.name + '\': ' + JSON.stringify(resp));
        });
      }
    };

  }]);

}
