package com.rishavtechie.springbootwebflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class MonoFluxTest {

    @Test
    public void testMono() {
        Mono<String> monoString = Mono.just("javaRishav").log();// execution of mono and used for single element//
        monoString.subscribe(System.out::println);
    }


    @Test
    public void testMonoError() {
        Mono<?> monoString = Mono.just("javaRishav")
                .then(Mono.error(new RuntimeException("Exception occured")))//creating the error //
                .log();
        monoString.subscribe(System.out::println, (e) -> System.out.println(e.getMessage())); //printing the exception //
    }


    @Test
    public void testFlux(){
        Flux<String> fluxString = Flux.just("spring", "spring boot", "hibernate", "microservice")
                .concatWithValues("AWS")// this adds element//
                .log();//creating of flux function//
        fluxString.subscribe(System.out::println);
    }

    @Test
    public void testFluxError(){
        Flux<String> fluxString = Flux.just("spring", "spring boot", "hibernate", "microservice")
                .concatWithValues("AWS")
                .concatWith(Flux.error(new RuntimeException("Exception occured in flux")))
                .concatWithValues("cloud")// after error 6th element will not be printed//
                .log();
        fluxString.subscribe(System.out::println,(e) -> System.out.println(e.getMessage()));//printing the exception//
    }











}
