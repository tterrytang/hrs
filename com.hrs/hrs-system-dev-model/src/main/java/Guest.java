import java.time.LocalDate;

@Entity
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // Constructors, Getters, and Setters
}

@Entity
public class Parcel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private boolean pickedUp = false;

    @ManyToOne
    private Guest guest;

    // Constructors, Getters, and Setters
}

@Entity
public class Stay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Guest guest;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    // Constructors, Getters, and Setters
}
