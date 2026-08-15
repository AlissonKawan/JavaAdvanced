package br.com.fiap2tdsps.projectmgt.model;

import java.time.LocalDate;

public class Project {

        private final Long id;
        private String name;
        private String description;
        private ProjectStatus status;
        private LocalDate startDate;
        private LocalDate endDate;

        public Project(Long id, String name, String description) {
            this.id = id;
            this.name = name;
            this.description = description;
        }

        public void setStatus(ProjectStatus status) {
            if (this.status == null && status != ProjectStatus.PLANEJADO) {
                throw new IllegalArgumentException(
                        "O status do projeto deve ser PLANEJADO"
                );
            } else if ((this.status == ProjectStatus.CONCLUIDO || status == ProjectStatus.CANCELADO)
                    || (this.status == ProjectStatus.EM_ANDAMENTO
                    && (status == ProjectStatus.CONCLUIDO || status == ProjectStatus.CANCELADO))) {

                throw new IllegalArgumentException(
                        "Este projeto não pode ser alterado para " + status + ""
                );
            } else {
                this.status = status;
            }
        }

    public void setId(Object o) {
    }

    public String getId() {
    }
}