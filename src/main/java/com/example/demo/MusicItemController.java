package com.example.demo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
class MusicItemController {

    private final MusicItemRepository repository;

    MusicItemController(MusicItemRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method=RequestMethod.GET, value="/items")
    List<MusicItem> allMusicItems() {
        return repository.findAll();
    }

    @PostMapping("/items")
    @ResponseStatus(HttpStatus.CREATED)
    MusicItem newItem(@RequestBody MusicItem item) {
        return repository.save(item);
    }

    // Single item

    @GetMapping("/items/{id}")
    MusicItem getMusicItem(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new MusicItemNotFoundException(id));
    }

    @GetMapping("/itemsrp")
    MusicItem getMusicItemrp(@RequestParam(value = "id",
            defaultValue = "1", required = false) Long id){
        return repository.findById(id)
                .orElseThrow(() -> new MusicItemNotFoundException(id));
    }

    @PutMapping("/items/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    MusicItem updateMusicItem(@RequestBody MusicItem newItem, @PathVariable Long id) {
        return repository.findById(id)
                .map(item -> {
                    item.setName(newItem.getName());
                    item.setArtist_group(newItem.getArtist_group());
                    item.setGenre(newItem.getGenre());
                    return repository.save(item);
                })
                .orElseGet(() -> {
                    newItem.setId(id);
                    return repository.save(newItem);
                });
    }

    @DeleteMapping("/items/{id}")
    void deleteMusicItem(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
