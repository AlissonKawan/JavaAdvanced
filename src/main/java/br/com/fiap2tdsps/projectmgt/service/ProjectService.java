package br.com.fiap2tdsps.projectmgt.service;

import br.com.fiap2tdsps.projectmgt.model.Project;
import br.com.fiap2tdsps.projectmgt.repository.ProjectRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    public List<Project> findAll() {
        return this.projectRepository.findAll();
    }

    public ResponseEntity<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    public Project create(Project project) {
        project.setId(null); // garante que o cliente nunca escolha o próprio id
        return this.projectRepository.save(project);
    }
}
