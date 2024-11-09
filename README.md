# **Doctor-Patient Location Sharing App**

## **Overview**

This JavaFX application allows **doctors** and **users** to interact with each other based on their proximity. The **doctor** can view nearby users, while **users** can share their locations with doctors. The app consists of three primary components:
- **Login Screen**: Allows users to log in as either a **doctor** or **user**.
- **Doctor Panel**: Enables the doctor to view nearby users.
- **User Panel**: Enables users to share their location with nearby doctors.

The app provides a simple, role-based interface for doctors and users to share location data, facilitating quick access to medical support.

## Connect to database source: 
-- host: sakta-do-user-18270856-0.i.db.ondigitalocean.com
-- port: 25060
-- username: doadmin
-- Database: defaultdb
-- password: AVNS_Ly595UDGmkZs5RVU6Sz

## **Features**

- **Login Screen**:
  - Login as a **doctor** or **user**.
  - Basic authentication with hardcoded credentials:
    - Username: `doctor`, Password: `321` (for doctor login).
    - Username: `user`, Password: `123` (for user login).
  
- **Doctor Panel**:
  - View a list of nearby users.
  - This feature is currently simulated with an informational alert.
  
- **User Panel**:
  - Share the user's location with nearby doctors.
  - This feature is currently simulated with an informational alert.

## **Technology Stack**

- **Java** (JDK 22)
- **JavaFX** for the graphical user interface (GUI).
- **Maven** for project management and dependencies.


## App Navigation

-    Login Screen:
        Enter username and password.
        Click the "Login" button to authenticate.

 -   Doctor Panel:
        After logging in as a doctor, the Doctor Panel will appear.
        Click "View Nearby Users" to simulate viewing a list of nearby users.

  -  User Panel:
        After logging in as a user, the User Panel will appear.
        Click "Share My Location" to simulate sharing your location with doctors.

## Code Structure

The project consists of the following main components:

   - Main.java: The entry point of the application that initializes and launches the GUI.
   - LoginController.java: Handles the login process and directs users to the appropriate panel based on their credentials.
   - DoctorPanelController.java: Manages the actions within the Doctor Panel.
   - UserPanelController.java: Manages the actions within the User Panel.
   - Login.fxml: The FXML layout file for the login screen.
   - DoctorPanel.fxml: The FXML layout file for the doctor’s panel.
   - UserPanel.fxml: The FXML layout file for the user’s panel.

## Future Enhancements

  - Location Sharing Integration: Integrate real location services (using GPS) for both doctor and user.
   - Backend Integration: Implement a backend to manage real user and doctor data, appointments, and locations.
   - Map Integration: Use an API like Google Maps or OpenStreetMap to show real-time locations.
   - Authentication: Implement more robust authentication mechanisms (e.g., using a database).


  
