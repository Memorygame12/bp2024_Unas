package entity;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categorieen")
public class Categorie {

    public Categorie() {
        // Standaard constructor
    }

    public Categorie(String naam) {
        this.naam = naam;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categorie_id;

    @Column(name = "naam")
    private String naam;

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
//    @JoinTable(
//            name = "boek_categorie",
//            joinColumns = @JoinColumn(name = "categorie_id"),
//            inverseJoinColumns = @JoinColumn(name = "boek_id")
//    )
//    private Set<Boek> boeken;



    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "boek_categorie",
            joinColumns = { @JoinColumn(name = "categorie_id") },
            inverseJoinColumns = { @JoinColumn(name = "boek_id") }
    )
    Set<Boek> boeken = new HashSet<>();



//    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//    @JoinTable(
//            name = "boek_categorie",
//            joinColumns = @JoinColumn(name = "categorie_id"),
//            inverseJoinColumns = @JoinColumn(name = "boek_id")
//    )
//    private Set<Boek> boeken;

    // Getters en setters
    public int getId() { return categorie_id; }
    public void setId(int id) { this.categorie_id = id; }
    public String getNaam() { return naam; }
    public void setNaam(String naam) { this.naam = naam; }
    public Set<Boek> getBoeken() { return boeken; }
    public void setBoeken(Set<Boek> boeken) {
        this.boeken = boeken;
    }

}
