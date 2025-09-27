package vn.iotstar.Entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Category") 
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cate_id") 
    private int cateId;  

    @Column(name = "cate_name", columnDefinition = "NVARCHAR(255)")
    private String cateName;  

    @Column(name = "icons", columnDefinition = "NVARCHAR(255)")
    private String icons;  

}