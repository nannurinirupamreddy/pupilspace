import java.sql.*;

/**
 * The Student class represents a student with various attributes and provides methods to
 * perform CRUD operations on student data in a database.
 *
 * @author Nirupam Reddy Nannuri
 *
 */
public class Student {

    private int id;
    private String name;
    private int age;
    private String gender;
    private String email;
    private String phoneNumber;
    private String address;
    final String SEPARATING_LINE = "-".repeat(137);
    String url = "jdbc:mysql://localhost:3306/pupilspace";
    String user = "root";
    String password = "nirupam2006";
    String insertQuery = "INSERT INTO information (id, name, age, " +
            "gender, email, phoneNumber, address) VALUES (?,?,?,?,?,?,?)";
    String updateQuery = "UPDATE information SET id = ?, name = " +
            " ?, age = ?, gender = ?, email = ?, phoneNumber = ?, " +
            "address = ? WHERE id = ?";
    String deleteQuery = "DELETE FROM information WHERE id = ?";
    String retrieveQuery = "SELECT * FROM information WHERE id = ?";

    /**
     * Default constructor for the Student class.
     */
    public Student(){

    }

    /**
     * Parameterized constructor for the Student class.
     *
     * @param id The student's ID.
     * @param name The student's name.
     * @param age The student's age.
     * @param gender The student's gender.
     * @param email The student's email.
     * @param phoneNumber The student's phone number.
     * @param address The student's address.
     */
    public Student(int id, String name, int age, String gender, String email, String phoneNumber, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    /**
     * Gets the student's ID.
     *
     * @return The student's ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the student's ID.
     *
     * @param id The student's ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the student's name.
     *
     * @return The student's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the student's name.
     *
     * @param name The student's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the student's age.
     *
     * @return The student's age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the student's age.
     *
     * @param age The student's age.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the student's gender.
     *
     * @return The student's gender.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the student's gender.
     *
     * @param gender The student's gender.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets the student's email.
     *
     * @return The student's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the student's email.
     *
     * @param email The student's email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the student's phone number.
     *
     * @return The student's phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the student's phone number.
     *
     * @param phoneNumber The student's phone number.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the student's address.
     *
     * @return The student's address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the student's address.
     *
     * @param address The student's address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Adds a new student to the database.
     *
     * @param student The student to be added.
     * @throws SQLException If a database access error occurs.
     */
    public void addStudent(Student student) throws SQLException{
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(insertQuery);
        ps.setInt(1, student.getId());
        ps.setString(2, student.getName());
        ps.setInt(3, student.getAge());
        ps.setString(4, student.getGender());
        ps.setString(5, student.getEmail());
        ps.setString(6, student.getPhoneNumber());
        ps.setString(7, student.getAddress());
        ps.executeUpdate();
    }

    /**
     * Retrieves a student from the database by ID.
     *
     * @param id The ID of the student to be retrieved.
     * @throws SQLException If a database access error occurs.
     */
    public void retrieveStudent(int id) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(retrieveQuery);
        ps.setInt(1, id);
        ResultSet rs =
                ps.executeQuery();
        while (rs.next()) {
            int studentId = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String gender = rs.getString("gender");
            String email = rs.getString("email");
            String phoneNumber = rs.getString("phoneNumber");
            String address = rs.getString("address");
            System.out.printf("%-7d%-14s%-9d%-10s%-30s%-20s%-17s\n",
                    studentId, name, age, gender, email, phoneNumber, address);
            System.out.println();
            }
    }

    /**
     * Updates a student's information in the database.
     *
     * @param student The student with updated information.
     * @throws SQLException If a database access error occurs.
     */
    public void updateStudent(Student student) throws SQLException{
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conn.prepareStatement(updateQuery);
            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getGender());
            ps.setString(5, student.getEmail());
            ps.setString(6, student.getPhoneNumber());
            ps.setString(7, student.getAddress());
            ps.setInt(8, 2);
            ps.executeUpdate();
    }

    /**
     * Updates a student's ID in the database.
     *
     * @param newId The new ID for the student.
     * @param oldId The current ID of the student.
     * @throws SQLException If a database access error occurs.
     */
    public void updateStudentId(int newId, int oldId) throws SQLException{
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "UPDATE information SET id = ? WHERE " +
                        "id = ?");
        ps.setInt(1, newId);
        ps.setInt(2, oldId);
        ps.executeUpdate();
    }

    /**
     * Updates a student's name in the database.
     *
     * @param newName The new name for the student.
     * @param studentId The ID of the student to be updated.
     * @throws SQLException If a database access error occurs.
     */
    public void updateStudentName(String newName, int studentId) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "UPDATE information SET name = ? " +
                        "WHERE id = ?");
        ps.setString(1, newName);
        ps.setInt(2, studentId);
        ps.executeUpdate();
    }

    /**
     * Updates a student's age in the database.
     *
     * @param newAge The new age for the student.
     * @param studentId The ID of the student to be updated.
     * @throws SQLException If a database access error occurs.
     */
    public void updateStudentAge(int newAge, int studentId) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "UPDATE information SET age = ? WHERE" +
                        " id = ?");
        ps.setInt(1, newAge);
        ps.setInt(2, studentId);
        ps.executeUpdate();
    }

    /**
     * Updates a student's gender in the database.
     *
     * @param updatedStudentGender The new gender for the student.
     * @param studentId The ID of the student to be updated.
     * @throws SQLException If a database access error occurs.
     */
    public void updateStudentGender(String updatedStudentGender,
                                    int studentId) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "UPDATE information SET gender = ? " +
                        "WHERE id = ?");
        ps.setString(1, updatedStudentGender);
        ps.setInt(2, studentId);
        ps.executeUpdate();
    }

    /**
     * Updates a student's email in the database.
     *
     * @param updatedStudentEmail The new email for the student.
     * @param studentId The ID of the student to be updated.
     * @throws SQLException If a database access error occurs.
     */
    public void updateStudentEmail(String updatedStudentEmail, int studentId) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "UPDATE information SET email = ? " +
                        "WHERE id = ?");
        ps.setString(1, updatedStudentEmail);
        ps.setInt(2, studentId);
        ps.executeUpdate();
    }

    /**
     * Updates a student's phone number in the database.
     *
     * @param updatedStudentPhoneNumber The new phone number for the student.
     * @param studentId The ID of the student to be updated.
     * @throws SQLException If a database access error occurs.
     */
    public void updateStudentPhoneNumber(String updatedStudentPhoneNumber, int studentId) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "UPDATE information SET phoneNumber =" +
                        " ? WHERE id = ?");
        ps.setString(1, updatedStudentPhoneNumber);
        ps.setInt(2, studentId);
        ps.executeUpdate();
    }

    /**
     * Updates a student's address in the database.
     *
     * @param updatedStudentAddress The new address for the student.
     * @param studentId The ID of the student to be updated.
     * @throws SQLException If a database access error occurs.
     */
    public void updateStudentAddress(String updatedStudentAddress, int studentId) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
                "UPDATE information SET address = ? " +
                        "WHERE id = ?");
        ps.setString(1, updatedStudentAddress);
        ps.setInt(2, studentId);
        ps.executeUpdate();
    }

    /**
     * Deletes a student from the database by ID.
     *
     * @param studentId The ID of the student to be deleted.
     * @throws SQLException If a database access error occurs.
     */
    public void deleteStudent(int studentId) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement("DELETE " +
                "FROM information WHERE id = ?");
        ps.setInt(1, studentId);
        ps.executeUpdate();
    }

    /**
     * Formats and prints the header for displaying student information.
     */
    public void format(){
            System.out.println(String.format("%-7s%-14s%-9s%-10s%-30s%-20s" +
                            "%-17s", "Id",
                    "Name", "Age", "Gender", "Email", "Phone Number",
                    "Address"));
            System.out.println(SEPARATING_LINE);
    }
}