package com.example.demo.data;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class UserDao {

    private static void waitForSomeTime(int i){
        try{
            Thread.sleep(1000);//ms
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
    public List getAllUsers() {
        return IntStream.rangeClosed(1, 10)
                .peek(UserDao::waitForSomeTime)
                .peek(i -> System.out.println("process user count" + i))
                .mapToObj(i -> new User(i, "user-"+i)).collect(Collectors.toList());
    }


    public Flux<User> getAllUsersStream(){
        return Flux.range( 1, 10).delayElements(Duration.ofSeconds (1))
                .doOnNext(i-> System.out.println("process user count" +i))
                .map(i-> new User (i, "user-"+i));
    }
}
