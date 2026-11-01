package sn.uasz.taches;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/taches")
public class TacheController {

    private final TacheRepository repository;

    public TacheController(TacheRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Tache> lister() {
        return repository.findAll();
    }

    @PostMapping
    public Tache ajouter(@Valid @RequestBody Tache tache) {
        tache.setId(null);
        return repository.save(tache);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tache> modifier(@PathVariable Long id, @Valid @RequestBody Tache donnees) {
        return repository.findById(id).map(t -> {
            t.setTitre(donnees.getTitre());
            t.setTerminee(donnees.isTerminee());
            return ResponseEntity.ok(repository.save(t));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
