package demo.notes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
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
  @PutMapping("/sync") ResponseEntity<?> sync(@RequestBody List<Map<String,Object>> incoming){notes.clear();int max=0;for(Map<String,Object> item:incoming){Object raw=item.get("id");int id=raw instanceof Number n?n.intValue():ids.incrementAndGet();if(id<1)id=ids.incrementAndGet();Map<String,Object>n=new LinkedHashMap<>();n.put("id",id);n.put("title",String.valueOf(item.getOrDefault("title","Untitled")));n.put("body",item.getOrDefault("body",""));n.put("created",item.getOrDefault("created",java.time.Instant.now().toString()));n.put("updated",item.getOrDefault("updated",n.get("created")));notes.put(id,n);max=Math.max(max,id);}ids.set(Math.max(ids.get(),max));return ResponseEntity.ok(new ArrayList<>(notes.values()));}
  @DeleteMapping("/{id}") ResponseEntity<?> delete(@PathVariable int id){return notes.remove(id)==null?ResponseEntity.notFound().build():ResponseEntity.noContent().build();}
 }
}