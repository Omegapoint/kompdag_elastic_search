(function() {

    'use strict';

    angular.module('kompetensdag', ['elasticsearch'])

        .constant('SETTINGS',{
            INDEX: 'multicore',
            HOST: 'http://localhost:9200',
            VERSION: '1.2'
        })

        .service('client', ['esFactory', 'SETTINGS', function(esFactory, SETTINGS) {
            return esFactory({
                host: SETTINGS.HOST,
                apiVersion: SETTINGS.VERSION,
                log: 'trace'
            });
        }])

        .controller('kompetensDagCtrl', ['SETTINGS', 'client', 'esFactory', function(SETTINGS, client, esFactory) {

            var self = this;

            /**
             * Used to toggle between legacy and es search.
             */
            self.searchResultFromElastic = false;

            /**
             * Checks cluster state
             */
            client.cluster.state({
                metric: [
                    'cluster_name',
                    'nodes',
                    'master_node'
                ]
            })
                .then(function (resp) {
                    self.clusterState = resp;
                    self.error = null;
                    console.log(self.clusterState);
                })
                .catch(function (err) {
                    self.clusterState = null;
                    self.error = err;
                    // if the err is a NoConnections error, then the client was not able to
                    // connect to elasticsearch. In that case, create a more detailed error
                    // message
                    if (err instanceof esFactory.errors.NoConnections) {
                        self.error = new Error('Unable to connect to elasticsearch. ' +
                            'Make sure that it is running and listening at http://localhost:9200');
                    }
                });

            /**
             * Modify this code
             *
             * https://www.elastic.co/guide/en/elasticsearch/client/javascript-api/current/api-reference-1-2.html
             *
             */

            self.query = {};
            this.search = function() {
                self.searchResultFromElastic = true;

                /***
                 * example count query.
                 */
                client.count({
                    index: SETTINGS.INDEX
                }, function (error, response) {
                    console.log(response);
                });

                /**
                 * example get by id
                 */
                //client.get({
                //    index: SETTINGS.INDEX,
                //    type: '',
                //    id: 1
                //}, function (error, response) {
                //    console.log(response);
                //});


                /**
                 * example query-string search
                 */
                //client.search({
                //    index: SETTINGS.INDEX,
                //    q: '_all:test'
                //}, function (error, response) {
                //    console.log('es-query-string', response);
                //});

                /**
                 * example full request with query dsl
                 */
                client.search({
                    index: SETTINGS.INDEX,
                    body: {
                        query: {
                            match: {
                                _all: 'test'
                            }
                        }
                    }
                }, function (error, response) {
                    console.log(response);
                });


                /**
                 * the result from the search
                 */
                self.results = [{
                    description : 'Hello from Elastic Search!',
                    color: 'NO_COLOR',
                    weight: 'NO_WEIGHT',
                    suppliers: [
                        {supplierName: 'A'},
                        {supplierName: 'B'},
                        {supplierName: 'C'}
                    ]
                }];

            };
    }]);
})();