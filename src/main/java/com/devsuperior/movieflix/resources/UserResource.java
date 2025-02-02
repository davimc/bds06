package com.devsuperior.movieflix.resources;

import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<Page<UserDTO>> findAllPaged(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAllPaged(pageable));
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

//    @PostMapping
//    public ResponseEntity<UserDTO> insert(@Valid @RequestBody UserInsertDTO dto) {
//        UserDTO newDto = service.insert(dto);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//                .buildAndExpand(newDto.getId()).toUri();
//        return ResponseEntity.created(uri).body(newDto);
//    }
//    @PutMapping(value="/{id}")
//    public ResponseEntity<UserDTO> update(@PathVariable Long id, @Valid @RequestBody UserUpdateDTO dto) {
//        UserDTO newDto = service.update(id,dto);
//        return ResponseEntity.ok().body(newDto);
//    }
//    @DeleteMapping(value="/{id}")
//    public ResponseEntity<UserDTO> delete(@PathVariable Long id) {
//        service.delete(id);
//        return ResponseEntity.noContent().build();
//    }
}
