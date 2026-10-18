package demo.notes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
public class ApiApplication {
 public static void main(String[] args){SpringApplication.run(ApiApplication.class,args);}
 @RestController @RequestMapping("/api/notes") @CrossOrigin(origins="*")
 static class NotesApi {
  private final Map<Integer,Map<String,Object>> notes=new LinkedHashMap<>();private final AtomicInteger ids=new AtomicInteger();
  @GetMapping List<Map<String,Object>> all(){return new ArrayList<>(notes.values());}
  @PostMapping ResponseEntity<?> create(@RequestBody Map<String,Object> body){String title=String.valueOf(body.getOrDefault("title","")).trim();if(title.isEmpty())return ResponseEntity.badRequest().body(Map.of("error","title is required"));int id=ids.incrementAndGet();Map<String,Object>n=new LinkedHashMap<>();n.put("id",id);n.put("title",title);n.put("body",body.getOrDefault("body",""));n.put("created",java.time.Instant.now().toString());n.put("updated",n.get("created"));notes.put(id,n);return ResponseEntity.status(201).body(n);}
  @PutMapping("/{id}") ResponseEntity<?> update(@PathVariable int id,@RequestBody Map<String,Object> body){Map<String,Object>n=notes.get(id);if(n==null)return ResponseEntity.notFound().build();String title=String.valueOf(body.getOrDefault("title","")).trim();if(title.isEmpty())return ResponseEntity.badRequest().body(Map.of("error","title is required"));n.put("title",title);n.put("body",body.getOrDefault("body",""));n.put("updated",java.time.Instant.now().toString());return ResponseEntity.ok(n);}
  @DeleteMapping("/{id}") ResponseEntity<?> delete(@PathVariable int id){return notes.remove(id)==null?ResponseEntity.notFound().build():ResponseEntity.noContent().build();}
 }
}