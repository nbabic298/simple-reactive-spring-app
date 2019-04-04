package io.codifica.test.simple.reactiveservice;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class TestApiController {

    private final TestService testService;

    @GetMapping("test/no-work")
    public Mono<Void> doReactiveTestNoWork() {
        return testService.doNoWork();
    }

    @GetMapping("test/small-work")
    public Mono<Void> doReactiveTestSmallWork() {
        return testService.doSmallWork();
    }

    @GetMapping("test/small-scheduled-work")
    public Mono<Void> doReactiveTestScheduledSmallWork() {
        return testService.doPropagatedSmallWork();
    }

    @GetMapping("test/medium-work")
    public Mono<Void> doReactiveTestMediumWork() {
        return testService.doMediumWork();
    }

    @GetMapping("test/medium-scheduled-work")
    public Mono<Void> doReactiveTestScheduledMediumWork() {
        return testService.doPropagatedMediumWork();
    }

}
