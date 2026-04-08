package com.hospitalVM.atenciones.models;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.*;
import java.time.LocalDateTime;
@Embeddable
@Getter @Setter @NoArgsConstructor @ToString
public class Audit {
    @Column(name="create_at")
    private LocalDateTime createAt;
    @Column(name="update_at")
    private LocalDateTime updateAt;

    @PrePersist
    public void prePersit(){
        this.createAt = LocalDateTime.now();
    }
    @PreUpdate
    public Void preUpdate() {
        this.updateAt = LocalDateTime.now();
    }
}
