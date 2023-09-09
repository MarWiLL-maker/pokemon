package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.models.Pokemon;
import com.repositories.PokemonRepository;

import reactor.core.publisher.Mono;
@CrossOrigins(orgins = "http;//localhost:3000")
@RestController
public class PokemonController {

    @Autowired
    private PokemonRepository pokemonRepository;
    private WebClient webClient = webClient.create();

    @GetMapping("/Collection")
    public List<Pokemon> getCollection(){ return (List<Pokemon>) pokemonRepository.findAll();
    }


    @PostMapping("/Capture")
    public void capturePokemon(@RequestBody Pokemon pokemon) {
        pokemonRepository.save(pokemon);
    }
     @GetMapping("/server-pokemon")
    public Mono<Pokemon> getServerPokemon() {
        return webClient.get()
        .uri("https://pokeapi.co/api/vs/pokemon-species")
        .retrieve()
        .bodyToMono(Map.class)
        .flatMap(speciesData -> {
            int count =(int) speciesData.get("count");
            int randomId = new  Random().nextInt(count) + 1;

            return webClient.get()
            .uri("https://pokemonapi.co/api/vs/pokemon/" + randomId)
            .retrieve()
            bodyToMono(Map.class)
            .map(pokemonData -> {
                String name = (String) pokemonData.get("name");
                String imageUrl =(String) ((map) ((List) pokemonData.get ("sprites")).get(0)).get("front_default");
                return new Pokemon(name, imageUrl);
            });
        });
        
    }
    
}
