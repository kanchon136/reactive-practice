package reactivepractice.reactivepraactice.entity;

 

import java.time.Duration;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReactivePractice {
	
	public static void main(String[]ar) {
		System.out.println("========================");
		
		Flux<String> fluxString = Flux.just("Kanchon","Testing","No increment No Work");
		fluxString.subscribe(
				v-> System.out.println("recieve Item===:"+v), 
				eror-> System.out.println("Have an Error "+eror.getMessage()),
				()-> System.out.println("Flux Complete==="));
		
		
		Mono<Integer> intmono = Mono.just(42);
		
		intmono.subscribe(
				v-> System.out.println("item of mono=:"+v), 
				error-> System.out.println("An Error accoured"+error),
				()-> System.out.println());
		
		Flux<Integer> numbersFlux = Flux.range(1, 20)
				.map(d-> d *2)
				.filter(f-> f % 3 ==0);
		
		 numbersFlux.subscribe(
				 v-> System.out.println("value=:"+v), 
				 e-> System.out.println(e.getMessage()),
				  ()-> System.out.println("Completed=="));
				
		
		String [] stArray = {"a","b","c","d"};
		Flux<String> stFlux= Flux.fromArray(stArray);
		
		stFlux.subscribe(
				s-> System.out.println("Value===:"+s), 
				er-> System.out.println("Error=:"+er),
				()-> System.out.println("====Completed===="));
		
		
		Flux<Integer> firsInts = Flux.range(1, 5);
		Flux<Integer> secondInts = Flux.range(6, 10);
		
		Flux<Integer> combinedFlux = Flux.concat(firsInts,secondInts);
		
		combinedFlux.subscribe(
				v-> System.out.println("v=:"+v),
				error-> System.out.println(error.getMessage()),
				()-> System.out.println("=Completed="));
		
		
		
		 Flux<String> letters1 = Flux.just("A", "B", "C").delayElements(Duration.ofMillis(100));
	        Flux<String> letters2 = Flux.just("X", "Y", "Z").delayElements(Duration.ofMillis(150));
	        
	        Flux<String> mergedFlux = Flux.merge(letters1, letters2);
	        
	        mergedFlux.subscribe(
	            letter -> System.out.println("Received: " + letter),
	            error -> System.err.println("Error: " + error),
	            () -> System.out.println("Flux completed.")
	        );
		
		System.out.println("======================================================");
		 
		Flux<Integer> f = Flux.range(1, 10);
		
		f.flatMap(num-> Mono.just(num*num)).subscribe(s-> System.out.println("value =="+s));
		
		 
	}

}
