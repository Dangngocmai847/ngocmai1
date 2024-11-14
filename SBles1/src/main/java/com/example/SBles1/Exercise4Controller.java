package com.example.SBles1;

import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/exercise4")
public class Exercise4Controller {
    private int autoId = 4;
    private List<Exercise4> employees = new ArrayList<>(
            Arrays.asList(
                    new Exercise4( 1 , LocalDate.of(2004 , 10 , 30),"Nu", 10000000, "Xuan My"  ),
                    new Exercise4( 2 , LocalDate.of(2004 , 05 , 18) ,"Nữ", 20000000, "Ngọc Mai"  ),
                    new Exercise4( 3 , LocalDate.of(2004 , 04 , 13) ,"Nữ", 20000000, "Minh Anh"  )
            ));

    @GetMapping
    public List<Exercise4> getAllStudents(){
                return employees;
            }

    @PostMapping
    public Exercise4 createEmployee(@RequestBody Exercise4 newExercise4) {
        newExercise4.setId(autoId++);
        employees.add(newExercise4);
        return newExercise4;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>>
    update(@PathVariable int id, @RequestBody Exercise4
           updatedExercise4){
        Map<String, Object> response = new HashMap<>();
        Exercise4 existingExercise4 = employees.stream()
                .filter(e->e.getId()==id)
                .findFirst()
                .orElse(null);
        existingExercise4.setFullName(updatedExercise4.getFullName());
        existingExercise4.setBirthDay(updatedExercise4.getBirthDay());
        existingExercise4.setGender(updatedExercise4.getGender());
        existingExercise4.setSalary(updatedExercise4.getSalary());
        response.put("status", HttpStatus.OK);
        response.put("message", "Nhan vien co id"+id+"duoc cap nhat thanh cong");
        response.put("employee", existingExercise4);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exercise4> getById(@PathVariable int id) {
        Exercise4 employee = employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
        return (employee != null)
                ? ResponseEntity.ok(employee)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable int id) {
        Map<String, Object> response = new HashMap<>();
        Exercise4 employee = employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
        if (employee == null) {
            response.put("status", HttpStatus.NOT_FOUND);
            response.put("message", "Nhan vien khong ton tai");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        employees.remove(employee);
        response.put("status", HttpStatus.OK);
        response.put("message", "Nhan vien co id " + id + " da duoc xoa thanh cong");
        return ResponseEntity.ok(response);
    }

    }




