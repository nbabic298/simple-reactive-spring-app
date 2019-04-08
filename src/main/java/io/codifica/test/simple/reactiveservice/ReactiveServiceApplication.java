package io.codifica.test.simple.reactiveservice;

import io.netty.util.NettyRuntime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.netty.ReactorNetty;

@Slf4j
@SpringBootApplication
public class ReactiveServiceApplication {

	public static void main(String[] args) {

        log.info("Java runtime available processors: {}", Runtime.getRuntime().availableProcessors());
        log.info("Netty runtime available processors: {}", NettyRuntime.availableProcessors());
        log.info("reactor.netty.ioWorkerCount = {}", System.getProperty(ReactorNetty.IO_WORKER_COUNT));
        log.info("reactor.netty.ioSelectCount = {}", System.getProperty(ReactorNetty.IO_SELECT_COUNT));
        log.info("reactor.netty.pool.maxConnections = {}", System.getProperty(ReactorNetty.POOL_MAX_CONNECTIONS));
        log.info("io.netty.eventLoopThreads = {}", System.getProperty("io.netty.eventLoopThreads"));

        System.setProperty("reactor.netty.ioWorkerCount", "" + Runtime.getRuntime().availableProcessors() * 2);

        log.info("Available memory: {} bytes", Runtime.getRuntime().totalMemory());

		SpringApplication.run(ReactiveServiceApplication.class, args);

        log.info("reactor.netty.ioWorkerCount = {}", System.getProperty(ReactorNetty.IO_WORKER_COUNT));

	}

}
