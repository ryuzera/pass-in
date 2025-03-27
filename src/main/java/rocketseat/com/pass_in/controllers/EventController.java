package rocketseat.com.pass_in.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {
    @GetMapping
    public ResponseEntity<String> getTest(){
        return ResponseEntity.ok("Event Success!");
    }
}
