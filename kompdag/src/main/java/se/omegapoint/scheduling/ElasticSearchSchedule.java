package se.omegapoint.scheduling;

import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.unit.ByteSizeUnit;
import org.elasticsearch.common.unit.ByteSizeValue;
import org.elasticsearch.common.unit.TimeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import se.omegapoint.repositories.ArticleRepository;

import java.time.LocalDateTime;

@Component
public class ElasticSearchSchedule {

    private final ArticleRepository articleRepository;
    private final Client client;

    private final BulkProcessor bulkProcessor;

    @Autowired
    public ElasticSearchSchedule(final ArticleRepository articleRepository, final Client client) {
        this.articleRepository = articleRepository;
        this.client = client;

        this.bulkProcessor = createBulkProcessor(client);
    }



    @Scheduled(initialDelay = 10000L, fixedDelay = 10000L)
    public void index() {
        System.out.print(LocalDateTime.now());
        System.out.println("\tDo stuff here!");
    }

    private BulkProcessor createBulkProcessor(final Client client) {
        return BulkProcessor
                .builder(client, new BulkProcessorListener())
                .setBulkActions(100)
                .setBulkSize(new ByteSizeValue(10, ByteSizeUnit.MB))
                .setConcurrentRequests(1)
                .setFlushInterval(TimeValue.timeValueSeconds(20))
                .build();
    }

    private class BulkProcessorListener implements BulkProcessor.Listener {

        @Override
        public void beforeBulk(long executionId, BulkRequest request) {
        }

        @Override
        public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {
        }

        @Override
        public void afterBulk(long executionId, BulkRequest request, Throwable failure) {
        }
    }
}
