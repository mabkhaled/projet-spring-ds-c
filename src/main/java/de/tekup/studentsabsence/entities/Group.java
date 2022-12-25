package de.tekup.studentsabsence.entities;

import de.tekup.studentsabsence.enums.LevelEnum;
import de.tekup.studentsabsence.enums.SpecialityEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@ToString(exclude = "students")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "_group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Label is required")
    private String label;
    @Enumerated(EnumType.STRING)
    private LevelEnum level;
    @NotNull(message = "Speciality is required")
    @Enumerated(EnumType.STRING)
    private SpecialityEnum speciality;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public void setLevel(LevelEnum level) {
        this.level = level;
    }

    public SpecialityEnum getSpeciality() {
        return speciality;
    }

    public void setSpeciality(SpecialityEnum speciality) {
        this.speciality = speciality;
    }

    public GroupSubject getGroupSubject() {
        return groupSubject;
    }

    public void setGroupSubject(GroupSubject groupSubject) {
        this.groupSubject = groupSubject;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    //TODO Complete Relations with other entities

    //ManyToMany avec subject
    @ManyToOne
    private GroupSubject groupSubject;

    //OnToMany avec Student
    @OneToMany
    private List<Student> students;

}
