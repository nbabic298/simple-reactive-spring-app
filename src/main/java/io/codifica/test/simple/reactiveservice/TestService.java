package io.codifica.test.simple.reactiveservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
@Service
public class TestService {

    public Mono<Void> doNoWork() {
        log.info("Doing no work!!!");
        return Mono.empty();
    }

    public Mono<Void> doSmallWork() {
        log.info("Doing small work!!!");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            log.error("doSmallWork() Error: {}", e.getMessage(), e);
        }
        return Mono.empty();
    }

    public Mono<Void> doPropagatedSmallWork() {
        Mono<Void> blockingWrapper = Mono.fromRunnable(() -> {
            try {
                log.info("Doing propagated small work!!!");
                Thread.sleep(200);
            } catch (InterruptedException e) {
                log.error("doPropagatedSmallWork() Error: {}", e.getMessage(), e);
            }
        });
        return blockingWrapper.subscribeOn(Schedulers.elastic());
    }

    public Mono<Void> doMediumWork() {
        log.info("Doing medium work!!!");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            log.error("doMediumWork() Error: {}", e.getMessage(), e);
        }
        return Mono.empty();
    }

    public Mono<Void> doPropagatedMediumWork() {
        Mono<Void> blockingWrapper = Mono.fromRunnable(() -> {
            try {
                log.info("Doing propagated medium work!!!");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                log.error("doPropagatedMediumWork() Error: {}", e.getMessage(), e);
            }
        });
        return blockingWrapper.subscribeOn(Schedulers.elastic());
    }

}
