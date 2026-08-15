package br.com.fiap2tdsps.projectmgt.controller;

import br.com.fiap2tdsps.projectmgt.model.Project;
import br.com.fiap2tdsps.projectmgt.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> findById(@PathVariable Long id) {
        Optional<Project> p = this.projectService.findById(id);

        if (p.isPresent()) {
            return ResponseEntity.ok(p.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project salvo = this.projectService.create(project)

    }
}