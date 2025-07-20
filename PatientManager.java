import java.sql.*;
import java.util.*;

public class PatientManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASS = "alicia_keyin";

    public static void insertPatients(List<Patient> patients) throws SQLException {
        try (Connection conn = DriverManager.getConnection((URL), USER, PASS)) {
          String sql = "INSERT INTO Patient (patientId, firstName, lastName, dob) VALUES (?, ?, ?, ?)";
            for (Patient p : patients) {
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setInt(1, p.getPatientID());
                    ps.setString(2, p.getFirstName());
                    ps.setString(3, p.getLastName());
                    ps.setString(4, p.getDob());
                     ps.executeUpdate();
                }
            }
        }
    }

    public static List<Patient> readPatients() throws SQLException {
        List<Patient> patients = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("Select * FROM Patient")) {
            
            while (rs.next()) {
                Patient p = new Patient(
                    rs.getInt("patientId"),
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("dob")
                );
                patients.add(p);
            }
        }

        return patients;

    }
}
