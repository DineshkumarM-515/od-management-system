package odsystem.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ODRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentName;

    private String registerNumber;

    private String reason;

    private String status;

    private String proofFile;

    private String rejectionReason;
}