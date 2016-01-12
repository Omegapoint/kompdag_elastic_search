(function() {

    'use strict';

    angular.module('kompetensdag', ['elasticsearch'])

        .constant('SETTINGS',{

            HOST: '** ADD_HOST_HERE **',
            VERSION: '1.2'

        })

        .service('client', ['esFactory', 'SETTINGS', function(esFactory, SETTINGS) {
            return esFactory({

                host: SETTINGS.HOST,
                apiVersion: SETTINGS.VERSION,
                log: 'trace'

            });
        }])

        .controller('kompetensDagCtrl', ['client', 'esFactory', function(client, esFactory) {

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
                    'master_node',
                    'version'
                ]
            })
                .then(function (resp) {
                    self.clusterState = resp;
                    self.error = null;
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
             */

            self.query = {};

            this.search = function() {
                self.searchResultFromElastic = true;
                self.results = [{
                    description : 'Hello from Elastic Search!'
                }];
            };
    }]);
})();